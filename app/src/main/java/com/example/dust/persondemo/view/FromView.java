package com.example.dust.persondemo.view;

//表格选中的view

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckedTextView;
//import android.support.v7.widget.AppCompatCheckedTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dust.persondemo.R;

public class FromView extends LinearLayout{



    //view
    private View view;
    private Context mContext;

    private AppCompatCheckedTextView headTv;
    private AppCompatCheckedTextView bodyTv;
    private AppCompatCheckedTextView footTv;

    public FromView(Context context) {
        super(context);
    }

    public FromView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initView(attrs);
    }



    public FromView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    /**   加载布局
     * @param attrs**/

    private void initView(AttributeSet attrs) {
        //  View.inflate  View的填充器
        //  最后一个参数表示把谁当做父容器，这里我们当MySettingView当做父容器
        //  当然，如果这里写null就什么都没有显示了
        view = View.inflate(getContext(), R.layout.item_my_style_view, this);
        //   LayoutInflater.from(getContext()).inflate(R.layout.item_my_style_view,this,true);
         headTv = (AppCompatCheckedTextView)findViewById(R.id.tv_head);
         bodyTv = (AppCompatCheckedTextView)findViewById(R.id.tv_body);
         footTv = (AppCompatCheckedTextView)findViewById(R.id.tv_foot);

        TypedArray attributes  = mContext.obtainStyledAttributes(attrs, R.styleable.FromView);

            if (attributes!=null){




                 //头部是否选中
                boolean headButtoncheckable = attributes.getBoolean(R.styleable.FromView_head_button_checkable, false);

                if (headButtoncheckable){

                    headTv.setChecked(true);


                }else {

                    headTv.setChecked(false);

                }


                //中部是否选中
                boolean bodyButtoncheckable = attributes.getBoolean(R.styleable.FromView_body_button_checkable, false);

                if (bodyButtoncheckable){

                    bodyTv.setChecked(true);

                }else {

                    bodyTv.setChecked(false);

                }
                //底部是否选中
                boolean footButtoncheckable = attributes.getBoolean(R.styleable.FromView_foot_button_checkable, false);

                if (footButtoncheckable){

                    footTv.setChecked(true);

                }else {

                   footTv.setChecked(false);

                }

                //设置头的文字
                String headText = attributes.getString(R.styleable.FromView_head_text);
                headTv.setText(TextUtils.isEmpty(headText)?"":headText);


                //中间文字
                String bodyText = attributes.getString(R.styleable.FromView_body_text);
                bodyTv.setText(TextUtils.isEmpty(bodyText)?"":bodyText);



                //底部文字
                String footText = attributes.getString(R.styleable.FromView_foot_text);
               footTv.setText(TextUtils.isEmpty(footText)?"":footText);






                attributes.recycle();

            }






    }






}
