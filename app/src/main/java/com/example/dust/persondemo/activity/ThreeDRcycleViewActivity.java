package com.example.dust.persondemo.activity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.dust.persondemo.R;
import com.example.dust.persondemo.adapter.InstallPackageAdapter;
import com.example.dust.persondemo.adapter.ThreeDPackageAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;


/**
 * @author dust
 * @function 带刷新的recycleView 页面
 * @created at 2017/8/3
 */
public class ThreeDRcycleViewActivity extends AppCompatActivity {
    
    private static final String TAG = ThreeDRcycleViewActivity.class.getSimpleName();

    private Toolbar toolbar3;
    private RecyclerView mRecycleView;
    private ThreeDPackageAdapter installPackageAdapter;
    private List<PackageInfo> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_3d);


        mRecycleView = (RecyclerView) findViewById(R.id.recycleView);
        toolbar3 = (Toolbar) findViewById(R.id.toolbar3);
        toolbar3.setTitle("3D翻页效果");


        setSupportActionBar(toolbar3);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
        }




        int i = 0;

        PackageManager pm = getPackageManager();
        List<PackageInfo> list = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        mList.clear();
        mList.addAll(list);

        for (PackageInfo packageInfo : list) {
            //获取到设备上已经安装的应用的名字,即在AndriodMainfest中的app_name。
            String appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
            //获取到应用所在包的名字,即在AndriodMainfest中的package的值。
            String packageName = packageInfo.packageName;
            Log.i(TAG, "应用的名字:" + appName);
            Log.i(TAG, "应用的包名字:" + packageName);
            i++;
        }
        Log.i(TAG, "应用的总个数:" + i);


        LinearLayoutManager layoutManager = new LinearLayoutManager(ThreeDRcycleViewActivity.this);
        mRecycleView.setLayoutManager(layoutManager);

//        mRecycleView.setEmptyView(layout_no_data);
        //设置Item增加、移除动画
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        installPackageAdapter = new ThreeDPackageAdapter(ThreeDRcycleViewActivity.this, mList);
        mRecycleView.setAdapter(installPackageAdapter);
        mRecycleView.addItemDecoration(new DividerItemDecoration(ThreeDRcycleViewActivity.this, layoutManager.getOrientation()));







    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
