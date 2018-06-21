package com.example.dust.persondemo.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dust.persondemo.R;
import com.example.dust.persondemo.bean.Person;
import com.example.dust.persondemo.dialog.VoiceDialog;
import com.example.dust.persondemo.factory.BlackHuman;
import com.example.dust.persondemo.factory.Human;
import com.example.dust.persondemo.factory.HumanFactory;
import com.example.dust.persondemo.factory.WhiteHuman;
import com.example.dust.persondemo.factory.YellowHuman;
import com.example.dust.persondemo.utils.CircularAnimUtil;
import com.example.dust.persondemo.utils.JNIUtils;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.logging.Logger;

import io.reactivex.functions.Consumer;
import skin.support.SkinCompatManager;

import static com.tencent.bugly.crashreport.crash.c.i;
import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private boolean isDefultSkin=true;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);


        Toolbar toolbar_main = (Toolbar) findViewById(R.id.toolbar_main);

        toolbar_main.setTitle("Android万花筒");
        setSupportActionBar(toolbar_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar_main, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);


        //初始化左侧边栏目
        initNavigationView();


           /**　　JNI 　测试案例　**/
         TextView tv = (TextView) findViewById(R.id.sample_text);

        JNIUtils jniUtils = new JNIUtils();
//        String stringFromJNI = jniUtils.stringFromJNI();
        String nameFromJNI = jniUtils.getNameFromJNI();
        tv.setText(nameFromJNI +"");


        /**　　　播放器　　**/
        TextView tv2 = (TextView) findViewById(R.id.sample_text2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //播放器的实现页面
                Intent intent = new Intent(MainActivity.this, MediaPlayerActivity.class);
                startActivity(intent);

            }
        });


        //工厂模式
        TextView tv3 = (TextView) findViewById(R.id.sample_text3);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //女娲第一次造人，试验性质，少造点，火候不足，缺陷产品
                System.out.println("------------造出的第一批人是这样的：白人 -----------------");
                 Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
                whiteHuman.cry();
                whiteHuman.laugh();
                whiteHuman.talk();
            //女娲第二次造人，火候加足点，然后又出了个次品，黑人
                System.out.println("\n\n------------造出的第二批人是这样的：黑-----------------");
                 Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
                blackHuman.cry();
                blackHuman.laugh();
                blackHuman.talk();


                //第三批人了，这次火候掌握的正好，黄色人种（不写黄人，免得引起歧义），备注：RB人不属于此列
                System.out.println("\n\n------------造出的第三批人是这样的：黄色人种-----------------");

                Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
                yellowHuman.cry();
                yellowHuman.laugh();
                yellowHuman.talk();



            }
        });

        //数据持久化之写入
        TextView tv4 = (TextView) findViewById(R.id.sample_text4);
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String  data="woshi ceshi shuju 852fas555as5f5ass55fasf55as5f5a5f5as5f5a5f5ads55fdss55ds55d5d55 ";
                 FileOutputStream outputStream=null;
                 BufferedWriter write=null;
                try {
                    outputStream=openFileOutput("filename", Context.MODE_PRIVATE);
                    write=new BufferedWriter(new OutputStreamWriter(outputStream));
                    try {
                        write.write(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {

                        try {
                            if(write!=null) {
                                write.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }

            }
        });
        //数据持久化之读文件
        TextView tv5 = (TextView) findViewById(R.id.sample_text5);
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String  data="woshi ceshi shuju 852fas555as5f5ass55fasf55as5f5a5f5as5f5a5f5ads55fdss55ds55d5d55 ";
                FileInputStream fileInputStream=null;
                BufferedReader reader=null;

                StringBuilder content=new StringBuilder();
                try {
                     fileInputStream = openFileInput("filename");
                    reader=new BufferedReader(new InputStreamReader(fileInputStream));

                    String line="";

                    try {
                        while ((line=reader.readLine())!=null){
                            content.append(line);
                        }
                        Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
                        if(reader.read()==1) {

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally {

                    try {
                        if(reader!=null) {
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }




            }
        });

        //测试通知栏
        TextView tv6= (TextView) findViewById(R.id.sample_text6);
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(MainActivity.this, NotificationTestActivity.class);
                startActivity(intent);


            }
        });




        /**　　　design 详情页 页面　　**/
        TextView tv7 = (TextView) findViewById(R.id.sample_text7);
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DesignDetialActivity.class);
                startActivity(intent);

            }
        });

        /**　　　贝塞尔 页面　　**/
        TextView tv8 = (TextView) findViewById(R.id.sample_text8);
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, BezierCurveActivity.class);
                startActivity(intent);

            }
        });

//gjsdlkgmhsmdmfgmhsmdflkfmghjmmlskdf,

        /**　　　带刷新的recycleView 页面　　**/

        TextView tv9 = (TextView) findViewById(R.id.sample_text9);
        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RcycleViewActivity.class);
                startActivity(intent);

            }
        });



        /**　　　卸载指定包的apk  　　**/

        TextView tv10 = (TextView) findViewById(R.id.sample_text10);
        tv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RcycleViewActivity.class);
                startActivity(intent);


            }
        });


        /**　　　侧滑删除  　　**/

        TextView tv11 = (TextView) findViewById(R.id.sample_text11);
        tv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SlidingActivity.class);
                startActivity(intent);


            }
        });


        /**　　　绘制图形 paint  　　**/

        TextView tv12 = (TextView) findViewById(R.id.sample_text12);
        tv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PaintActivity.class);
                startActivity(intent);


            }
        });



        /**    热修复相关的业务  13 14  **/


        /**    自定义控件  15  **/

        TextView sample_text15 = (TextView) findViewById(R.id.sample_text15);
        sample_text15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction( "com.example.dust.persondemo");
              //不加下面这行也行，因为intent的这个属性默认值即系Intent.CATEGORY_DEFAULT
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);


            }
        });


        /**    权限和 16  **/
        TextView sample_text16 = (TextView) findViewById(R.id.sample_text16);
        sample_text16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RxPermissions rxPermissions = new RxPermissions(MainActivity.this); // where this is an Activity instance

                //不区分拒绝  状态权限的申请
                rxPermissions
                        .request(Manifest.permission.CAMERA,
                                Manifest.permission.INTERNET)
                        .subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(Boolean granted) throws Exception {

                                if (granted) {
//                                // All requested permissions are granted

                                    Intent intent = new Intent(MainActivity.this, VoiceDialogActivity.class);
                                    startActivity(intent);

                                } else {
                                    // At least one permission is denied

                                    Toast.makeText(MainActivity.this, "被拒绝", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }



//                rxPermissions
//                        .requestEachCombined(Manifest.permission.CAMERA,
//                                Manifest.permission.READ_PHONE_STATE)
//                        .subscribe(new Consumer<Permission>() {
//                            @Override
//                            public void accept(Permission permission) throws Exception {
//
//
//                                if (permission.granted) {
//                                    // All permissions are granted !
//                                    //所有权限被同意
//
//                                    Toast.makeText(MainActivity.this, "所有权限被同意", Toast.LENGTH_SHORT).show();
//
//                                } else if (permission.shouldShowRequestPermissionRationale) {
//                                    // At least one denied permission without ask never again
//                                    ////至少有一个被拒绝的权限，而不会再次询问
//                                    Toast.makeText(MainActivity.this, "被拒绝的权限", Toast.LENGTH_SHORT).show();
//
//                                } else {
//                                    // At least one denied permission with ask never again
//                                    // Need to go to the settings
//                                    Toast.makeText(MainActivity.this, "Need to go to the settings", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//
//                        });
//
//                }

            });




        /** 传感器    **/

        TextView sample_text17 = (TextView) findViewById(R.id.sample_text17);
        sample_text17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(intent);


            }
        });


        /** 上拉翻页商品详情    **/

        TextView sample_text18 = (TextView) findViewById(R.id.sample_text18);
        sample_text18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, SlidingShopDetialsActivity.class);
                startActivity(intent);


            }
        });

        /** scrollView商品详情    **/

        TextView sample_text19 = (TextView) findViewById(R.id.sample_text19);
        sample_text19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, ScrollShopDetialsActivity.class);
                startActivity(intent);


            }
        });


        final VoiceDialog voiceDialog=new VoiceDialog(MainActivity.this);

       /** Dialog 生命周期   **/
        TextView sample_text20 = (TextView) findViewById(R.id.sample_text20);
        sample_text20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voiceDialog.setMessage("确定退出应用");
//                voiceDialog.setMessage("确定退出应用?");
                voiceDialog.show();


            }
        });






        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /**
                 * 带动画特效的启动
                 */
                CircularAnimUtil.startActivity(MainActivity.this, DesignDetialActivity.class, v, R.color.colorAccent);


            }
        });


//


        Person p=   new Person.Builder()
                .name("fasf")
                .setCountry(1)
                .create();






    }

    private void initNavigationView() {


        NavigationView navigationView = findViewById(R.id.navigation_view);

        final MenuItem item = navigationView.getMenu().findItem(R.id.switch_skin);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                String message = "功能暂未开通";
                switch (menuItem.getItemId()) {

                    // 修改密码
                    case R.id.change_password:


                        break;

                    // 换肤
                    case R.id.switch_skin:


                        SkinCompatManager.SkinLoaderListener skinLoaderListener = new SkinCompatManager.SkinLoaderListener() {
                            @Override
                            public void onStart() {

                                Log.e(TAG,"onStart()");

                            }

                            @Override
                            public void onSuccess() {

                                Log.e(TAG,"onSuccess()");

                            }

                            @Override
                            public void onFailed(String errMsg) {


                                Log.e(TAG,"onFailed()"+errMsg);

                            }
                        };

//                        SkinCompatManager.getInstance().loadSkin("dust_night.skin", skinLoaderListener, SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                        if (isDefultSkin) {
//                          SkinCompatManager.getInstance().loadSkin("dust_night.skin", skinLoaderListener, SkinCompatManager.SKIN_LOADER_STRATEGY_ASSETS);
//                           SkinCompatManager.getInstance().loadSkin("dust.skin", skinLoaderListener, SkinCompatManager.SKIN_LOADER_STRATEGY_ASSETS);
                           SkinCompatManager.getInstance().loadSkin("night.skin", skinLoaderListener, SkinCompatManager.SKIN_LOADER_STRATEGY_ASSETS);
                            isDefultSkin=false;
                        } else {
                            SkinCompatManager.getInstance().restoreDefaultTheme();
                            isDefultSkin=true;
                        }





                        break;

                    // 清除缓存
                    case R.id.action_feed_back:



                        break;

                    // 登出
                    case R.id.logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("提示")//
                                .setMessage("确定退出该账号?")//
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int whitch) {

                                    }
                                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                            }
                        }).create();
                        builder.show();



                        break;

                }

//                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return false;
            }
        });



    }

    /**
//     * A native method that is implemented by the 'native-lib' native library,
//     * which is packaged with this application.
//     */
//    public native String stringFromJNI();
//
//    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib1");
//    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
//                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
