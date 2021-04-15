package com.example.dust.persondemo.behavior;

import android.content.Context;
import androidx.annotation.NonNull;
//import android.support.design.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;


/**
 * @author dust
 * @function   自定义    MyBehavior
 * @created at 2018/5/21
 */
public class MyBehavior  extends CoordinatorLayout.Behavior {


    /**
     * 如果布局使用这个     必须重写这个两参数构造
     * @param context
     * @param attrs
     */
    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
//        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
        return true;



    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);


        if (dy<0){


            ViewCompat.animate(child).scaleX(1).scaleY(1).start();

        }else {

            ViewCompat.animate(child).scaleX(0).scaleY(0).start();

        }
    }

    @Override
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);




    }
}
