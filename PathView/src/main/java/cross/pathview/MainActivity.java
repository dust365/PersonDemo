package cross.pathview;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cross.model.PathArea;
import cross.ui.PathView;
import cross.xmlanalysis.SAX;

public class MainActivity extends Activity {
    private PathView pathview;
    private  AnimationSet animatorSet;

    //全部数据
    private List<PathArea> pathAreas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pathview = (PathView) findViewById(R.id.pathView);
        pathview.setOnAreaLoadedCallback(new PathView.OnAreaLoadedCallback() {
            @Override
            public void onAreaLoaded() {
                showArea();
            }
        });


        pathview.addOnAreaClick(new PathView.OnAreaClick() {
            @Override
            public void OnClick(PathArea pathArea) {
                Toast.makeText(MainActivity.this, "点击了：" + pathArea.getAreaName(), Toast.LENGTH_SHORT).show();
                pathArea.setFillColor("#d4237a");
//                pathview.notify();


                pathview.setListData(pathAreas);


//               new Handler().postDelayed(new Runnable() {
//                   @Override
//                   public void run() {
//
//
//                       pathview.notifyAll();
//
//                   }
//               },2000);



            }
        });

//        pathview.setAnimation();



        TranslateAnimation upAnimation=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-0.3f);
        upAnimation.setDuration(300);
//        upAnimation.setInterpolator(new DecelerateInterpolator());
        TranslateAnimation downAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,-0.3f,Animation.RELATIVE_TO_SELF,0);
        downAnimation.setDuration(300);
        downAnimation.setStartOffset(300);
//        downAnimation.setInterpolator(new AccelerateInterpolator());
        animatorSet = new AnimationSet(true);
        animatorSet.addAnimation(upAnimation);
        animatorSet.addAnimation(downAnimation);
//        pathview.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_UP:
//                        PathArea pathArea = pathview.getPathArea(pathview.getWidth() / 2, pathview.getHeight() / 2);
//                        if (pathArea!=null){
//                            Toast.makeText(MainActivity.this,pathArea.getAreaName(), Toast.LENGTH_SHORT).show();
//
//                            findViewById(R.id.image).startAnimation(animatorSet);
//                        }
//                        break;
//                }
//                return false;
//            }
//        });
    }

    private void showArea() {
//
//        SvgPathToAndroidPath lParser = new SvgPathToAndroidPath();
//        List<PathArea> pathAreas = null;
//        for (int i = 0; i < svgPaths.length; i++) {
//            PathArea pathArea = new PathArea();
//            Path path = lParser.parser(svgPaths[i]);
//            pathArea.setAreaName(String.valueOf(i));
//            pathArea.setPath(path);
//            pathArea.setAreaColor(0xff22eeff);
//            pathAreas.add(pathArea);
//        }
//        String path = Environment.getExternalStorageDirectory().getPath()+ "/so/shop.xml";
        try {
            InputStream is = getAssets().open("world.xml");
            pathAreas = new SAX().readXML(is);
            pathview.setListData(pathAreas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

