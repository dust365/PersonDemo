package com.example.dust.persondemo.Activity;

import android.app.ActionBar;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.dust.persondemo.R;

public class DesignDetialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_detial);

        CollapsingToolbarLayout collToolBar = (CollapsingToolbarLayout) findViewById(R.id.coll_toolbar);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collToolBar.setTitle("详情页面");

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
