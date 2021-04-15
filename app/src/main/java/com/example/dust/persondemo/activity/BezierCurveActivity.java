package com.example.dust.persondemo.activity;

//import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.dust.persondemo.R;
import com.example.dust.persondemo.bezier.LoveLayout;

public class BezierCurveActivity extends AppCompatActivity {

    private Toolbar toolbar3;
    private LoveLayout loveLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier_curve);
        toolbar3 =(Toolbar) findViewById(R.id.toolbar3);
        toolbar3.setTitle("仿直播动画");


        setSupportActionBar(toolbar3);

       ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
        }


          /** 点击事件**/
        findViewById(R.id.tv_onclick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loveLayout.addLove();
            }
        });

        loveLayout= (LoveLayout) findViewById(R.id.love_layout);



    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case  android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
