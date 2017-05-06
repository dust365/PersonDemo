package com.example.dust.persondemo.bezier;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.dust.persondemo.R;

import java.util.Objects;
import java.util.Random;

/**
 * Created by dust on 2017/5/6.
 */

public class LoveLayout extends RelativeLayout {

    Drawable[] drawables=new Drawable[3];

     Random random  = new Random();
    private int dWidth;
    private int dHeight;
    private LayoutParams params;

    //屏幕的宽高
    private int mWidth;
    private int mHeight;

    //加速
    Interpolator acc=new AccelerateInterpolator();
    Interpolator dec=new DecelerateInterpolator();
    Interpolator adddec=new AccelerateDecelerateInterpolator();

    private   Interpolator[] interpolators;


    public LoveLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoveLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        interpolators=new Interpolator[3];
        interpolators[0]=acc;
        interpolators[1]=dec;
        interpolators[2]=adddec;

        drawables[0]=getResources().getDrawable(R.mipmap.ic_launcher);
        drawables[1]=getResources().getDrawable(R.mipmap.ic_launcher);
        drawables[2]=getResources().getDrawable(R.mipmap.ic_launcher);

        dWidth=drawables[0].getIntrinsicWidth();
        dHeight=drawables[0].getIntrinsicHeight();
        params = new LayoutParams(dWidth, dHeight);


    }

    /**
     * @function   添加view
     */
    public void addLove() {

        final ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(drawables[random.nextInt(3)]);
        params.addRule(CENTER_HORIZONTAL);
        params.addRule(ALIGN_PARENT_BOTTOM);
        //添加位置
        addView(imageView,params);


        //动画   1平移   2.渐变 3.缩放
        //属性动画集合
        AnimatorSet set=getAnimation(imageView);

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                removeView(imageView);
            }
        });
        //开启属性动画
        set.start();





    }

    private AnimatorSet getAnimation(ImageView imageView) {


        //1.缩放动画
        ObjectAnimator  scaleX=ObjectAnimator.ofFloat(imageView,"scaleX",0.4f,1f);
        ObjectAnimator  scaleY=ObjectAnimator.ofFloat(imageView,"scaleY",0.4f,1f);

        //2.alpha
        ObjectAnimator  alpha=ObjectAnimator.ofFloat(imageView,"alpha",0.4f,1f);

        //3.三个动画同时执行
        AnimatorSet enterSet=new AnimatorSet();
        enterSet.setDuration(500);
        enterSet.playTogether(scaleX,scaleY,alpha);

        //4贝塞尔曲线  估值器 evalutor
        ValueAnimator bezierAnimator=getBezierAnimator(imageView);


        //整合所有动画
        AnimatorSet  set=new AnimatorSet();
        set.playSequentially(enterSet,bezierAnimator);
        //加速器
        set.setInterpolator(interpolators[random.nextInt(3)]);

        set.setTarget(imageView);


        return set;
    }



    private ValueAnimator getBezierAnimator(final ImageView iv) {

        //贝塞尔曲线  准备4个坐标  (起点 p0,   拐点 p1, 拐点 p2 ,终点p3 )
     PointF pointF0=new PointF((mWidth-dWidth)/2,mHeight-dHeight);
     PointF pointF1=getTogglePointF(1);
     PointF pointF2=getTogglePointF(2);
     PointF pointF3=new PointF(random.nextInt(mWidth),0);

        BezierTypeEvaluator evalutor = new BezierTypeEvaluator(pointF1, pointF2);

      ValueAnimator animator=ValueAnimator.ofObject(evalutor,pointF0,pointF3);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) animation.getAnimatedValue();
                //控制属性的变化
                iv.setX(pointF.x);
                iv.setY(pointF.y);
                iv.setAlpha(1-animation.getAnimatedFraction());

            }
        });


        return animator;
    }


    //两个拐点测量的方法
    private PointF getTogglePointF(int i) {
        PointF pointF=new PointF();
        pointF.x=random.nextInt(mWidth);
        
        if(i==1) {//下面p1

            pointF.y=random.nextInt(mHeight/2)+mHeight/2;//范围  h/2-h
        }else {//上面p2  //范围  0-h
            pointF.y=random.nextInt(mHeight/2);//范围  h/2-h

        }
        return pointF;
    }

    /**
     *
     测量屏幕的宽高
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth=getMeasuredWidth();
        mHeight=getMeasuredHeight();
    }
}
