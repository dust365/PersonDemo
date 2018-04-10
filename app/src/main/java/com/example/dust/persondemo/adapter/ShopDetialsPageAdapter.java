package com.example.dust.persondemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dust.persondemo.R;
import com.example.dust.persondemo.bean.Stock2Bean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * $ desc &
 *
 * @author dust
 * @function 商品详情页面
 * created at 2017/3/13  16:18
 */

public class ShopDetialsPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private static final String TAG = ShopDetialsPageAdapter.class.getSimpleName();

    public static enum ITEM_TYPE {
        ITEM_TITLE,
        ITEM_GOODS
    }

    private Context mContext;
    private List<Stock2Bean> mList;
    private ValueChangeListener mValueChangeListener;


    public ShopDetialsPageAdapter(Context mContext, List<Stock2Bean> mList) {

        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        if (viewType == ITEM_TYPE.ITEM_TITLE.ordinal()) {
            // 库存标题

            View itemView = LayoutInflater.from(mContext).inflate(R.layout.easy_damage_title_item, parent, false);
            return  new TitleViewHolder(itemView);

        } else {

            //普通商品

            View itemView = LayoutInflater.from(mContext).inflate(R.layout.easy_damage_goods_item, parent, false);
            return new GoodsViewHolder(itemView);

        }


    }

    @Override
    public int getItemViewType(int position) {

        int type = mList.get(position).getType();


        //type==1   标题     0是商品


        return (type==1) ? ITEM_TYPE.ITEM_TITLE.ordinal() : ITEM_TYPE.ITEM_GOODS.ordinal();
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {



        if (holder instanceof TitleViewHolder) {

            final TitleViewHolder topViewHolder = (TitleViewHolder) holder;
            Stock2Bean stock2Bean = mList.get(position);

             //标题名称
            String name = stock2Bean.getTitleName();
            topViewHolder.titleNameTv.setText(TextUtils.isEmpty(name)?"":name);





        } else if (holder instanceof GoodsViewHolder) {


            final GoodsViewHolder topViewHolder = (GoodsViewHolder) holder;
            topViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (myOnItemClickListener != null) {
                        myOnItemClickListener.onItemClick(v, position);
                    }
                }
            });

            Stock2Bean stock2Bean = mList.get(position);


            String goods_image_url = stock2Bean.getGoods_image_url();


//            Bitmap imageBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.gouwu_blue);
//            topViewHolder.main_Img.setImageBitmap(imageBitmap);
//            ImageLoaderUtil.load(mContext, topViewHolder.main_Img, goods_image_url, R.mipmap.default_classify);


            //商品名称
            String name = stock2Bean.getGoods_name();
            topViewHolder.nameTV.setText((TextUtils.isEmpty(name)) ? "" : name);


//            String goods_id = stock2Bean.getGoods_id();
//            topViewHolder.tv_series_year.setText((TextUtils.isEmpty(goods_id))?"":goods_id);


//            //单个商品价
//            String orderPrice = stock2Bean.getGoods_price();
//            topViewHolder.goodsPriceTv.setText((TextUtils.isEmpty(orderPrice)) ? "" : orderPrice);


        }


    }


    @Override
    public int getItemCount() {
        return mList.size();
    }



    public static class TitleViewHolder extends RecyclerView.ViewHolder {



        @BindView(R.id.tv_title_name)
        TextView titleNameTv;


        public TitleViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }


    public static class GoodsViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.main_img)
        ImageView main_Img;

        @BindView(R.id.tv_name)
        TextView nameTV;



        @BindView(R.id.tv_series_year)
        TextView tv_series_year;







        public GoodsViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }


    /**
     * 值变化事件的监听
     **/
    public interface ValueChangeListener {


        void onValeChange(View view, ImageView goodImageView, int position, int value);

    }

    /**
     * 设置值变化事件的监听
     *
     * @param listener
     */
    public void setValueChangeListener(ValueChangeListener listener) {
        this.mValueChangeListener = listener;
    }

    private MyOnItemClickListener myOnItemClickListener;

    public interface MyOnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListner(MyOnItemClickListener listner) {
        myOnItemClickListener = listner;
    }




}
