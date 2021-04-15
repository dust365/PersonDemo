package com.example.dust.persondemo.adapter;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dust.persondemo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author dust
 * @function 安装包列表
 * @created at 2017/9/9
 */
public class InstallPackageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<PackageInfo> mList;
    private MyItemClickListener mItemClickListener;


    public InstallPackageAdapter(Context mContext, List<PackageInfo> mList) {

        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(mContext).inflate(R.layout.install_package_item, parent, false);
        TopViewHolder holder = new TopViewHolder(itemView);
        //设置item点击事件
        itemView.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        /**  将位置保存在itemView的Tag中，以便点击时进行获取  **/
        holder.itemView.setTag(position);


        final TopViewHolder topViewHolder = (TopViewHolder) holder;


        PackageInfo packageInfo = mList.get(position);

        String appName = packageInfo.applicationInfo.loadLabel(mContext.getPackageManager()).toString();
        //获取到应用所在包的名字,即在AndriodMainfest中的package的值。
        String packageName = packageInfo.packageName;


        Drawable logoDrawable = packageInfo.applicationInfo.loadIcon(mContext.getPackageManager());






//        ActivityInfo[] activities = packageInfo.activities;
//
//        if (activities.length>2){
//
//            int iconResource = activities[1].getIconResource();
//
//        }

        topViewHolder.imageView.setBackground(logoDrawable);

        if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
             //非系统应用


            topViewHolder.NameTv.setText( " "+appName );


        } else {
        //系统应用　

            topViewHolder.NameTv.setText( "(系统) "+appName );

        }



        topViewHolder.DescTv.setText("  " + packageName);


    }


    @Override
    public int getItemCount() {
        return mList.size();

    }


    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            int position = (int) v.getTag();
            mItemClickListener.onItemClick(v, position);
        }
    }

    public static class TopViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.name_tv)
        TextView NameTv;


        @BindView(R.id.tv_desc)
        TextView DescTv;


        @BindView(R.id.imageView)
        ImageView imageView;


        public TopViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }


    /**
     * item点击事件的监听
     **/
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener) {
        this.mItemClickListener = listener;
    }


}
