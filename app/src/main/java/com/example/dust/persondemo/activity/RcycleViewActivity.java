package com.example.dust.persondemo.activity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.dust.persondemo.R;
import com.example.dust.persondemo.adapter.InstallPackageAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;


/**
 * @author dust
 * @function 带刷新的recycleView 页面
 * @created at 2017/8/3
 */
public class RcycleViewActivity extends AppCompatActivity {
    
    private static final String TAG = RcycleViewActivity.class.getSimpleName();

    private Toolbar toolbar3;
    private RecyclerView mRecycleView;
    private InstallPackageAdapter installPackageAdapter;
    private List<PackageInfo> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);


        mRecycleView = (RecyclerView) findViewById(R.id.recycleView);
        toolbar3 = (Toolbar) findViewById(R.id.toolbar3);
        toolbar3.setTitle("应用列表");


        setSupportActionBar(toolbar3);

      ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });


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


        LinearLayoutManager layoutManager = new LinearLayoutManager(RcycleViewActivity.this);
        mRecycleView.setLayoutManager(layoutManager);

//        mRecycleView.setEmptyView(layout_no_data);
        //设置Item增加、移除动画
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        installPackageAdapter = new InstallPackageAdapter(RcycleViewActivity.this, mList);
        mRecycleView.setAdapter(installPackageAdapter);
        mRecycleView.addItemDecoration(new DividerItemDecoration(RcycleViewActivity.this, layoutManager.getOrientation()));
        installPackageAdapter.setOnItemClickListener(new InstallPackageAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                PackageInfo packageInfo = mList.get(position);
                String packageName = packageInfo.packageName;
                if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                    //非系统应用

                  //通过程序的包名创建URI
                  //  Uri packageURI = Uri.parse("package:com.piccfs.lossassessment");
                    Uri packageURI = Uri.parse("package:" + packageName);
                    //创建Intent意图
                    Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
                    //执行卸载程序
                    startActivity(intent);


                } else {
                    //系统应用　

                    Toast.makeText(RcycleViewActivity.this, "系统应用不可卸载", Toast.LENGTH_SHORT).show();

                }
//

            
           




            }
        });


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
