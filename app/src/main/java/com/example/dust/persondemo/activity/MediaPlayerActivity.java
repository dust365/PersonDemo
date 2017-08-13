package com.example.dust.persondemo.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dust.persondemo.R;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;


/**
*  @author   dust
*  @function  播放器实现类
*  created at 2017/5/4  15:56
*/
public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mediaPlayer = new MediaPlayer();
    private static final String MUSIC_PATH = new String("/sdcard/");
    private ArrayList <String> mMusicList = new ArrayList<>();
    private ListView myListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);


        findViewById(R.id.tv_pause).setOnClickListener(this);
         findViewById(R.id.tv_play).setOnClickListener(this);
         findViewById(R.id.tv_stop).setOnClickListener(this);

         myListview = (ListView)findViewById(R.id.my_listview);


                //

        //动态获取权限
        if(ContextCompat.checkSelfPermission(MediaPlayerActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MediaPlayerActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        }else {

//            Toast.makeText(MediaPlayerActivity.this, "可以播放！", Toast.LENGTH_SHORT).show();
            getMusicList();
            initMediaPlayer();

        }



    }

    private void initMediaPlayer() {

        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File rootDirectory = Environment.getRootDirectory();
        File dataDirectory = Environment.getDataDirectory();
        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        File file = new File(dataDirectory, "emoji_music.mp3");

        String  path="/手机内存/Music/emoji_music.mp3";
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(MediaPlayerActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case  1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(MediaPlayerActivity.this, "已经获得授权", Toast.LENGTH_SHORT).show();
                    initMediaPlayer();

                }else {

                    Toast.makeText(MediaPlayerActivity.this, "拒绝权限无法使用", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_pause ://暂停
           if(mediaPlayer.isPlaying()) {
               mediaPlayer.pause();
           }else {
               mediaPlayer.start();
           }
                break;
            case R.id.tv_play ://播放

                if(!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }


                break;
            case R.id.tv_stop ://停止

                if(!mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                    initMediaPlayer();
                }

                break;
        }
    }



    //播放列表
    public void getMusicList()
    {
        File home = new File(MUSIC_PATH);
        if(home.listFiles(new MusicFilter()).length > 0)
        {
            for(File file : home.listFiles(new MusicFilter()))
            {
                mMusicList.add(file.getName());
            }
            ArrayAdapter<String> musicList = new ArrayAdapter<String>(MediaPlayerActivity.this,R.layout.musicitem,mMusicList);
            myListview.setAdapter(musicList);
        }
    }


    //过滤文件类型
    class MusicFilter implements FilenameFilter
    {

        public boolean accept(File dir, String name) {
            //这里还可以设置其他格式的音乐文件
            return (name.endsWith(".mp3"));
        }
    }
}
