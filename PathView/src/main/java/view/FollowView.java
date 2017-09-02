package view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static android.content.ContentValues.TAG;

/**
 * @author dust
 * @function  自定义跟随的view
 * @created at 2017/9/2
 */
public class FollowView  extends ImageView{



    /**  ActionBar 的高度 **/
    private int actionBarHeight=0;
    /**  状态栏高度  **/
    private  int statusBarHeight=0;
    /**  屏幕的宽高 **/
    private  int screenWidth;
    private  int screenHeight;



    private int lastX;
    private int lastY;
    private Context mContext;


    /**  控件本身的宽高 **/
    private int mselfWidth;
    private int mselfHeigh;


    public FollowView(Context context) {
        super(context);
    }

    public FollowView(Context context, AttributeSet attrs) {

        super(context, attrs);
        mContext=context;

        // 获取屏幕宽高（方法1）
         screenWidth =((Activity)mContext).getWindowManager().getDefaultDisplay().getWidth(); // 屏幕宽（像素，如：480px）
         screenHeight = ((Activity)mContext).getWindowManager().getDefaultDisplay().getHeight(); // 屏幕高（像素，如：800p）

        Log.d(TAG, "screenWidth:== "+screenWidth);
        Log.d(TAG, "screenHeight:== "+screenHeight);


        //状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 获得状态栏高度
            int resourceId = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
             statusBarHeight = getContext().getResources().getDimensionPixelSize(resourceId);

        }

        //ActionBar 的高度
         actionBarHeight = ((Activity) mContext).getActionBar().getHeight();


    }

    public FollowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);



    }


    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mselfWidth = getMeasuredWidth();
        mselfHeigh = getMeasuredHeight();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {



//        return super.onTouchEvent(event);
        // 获取当前触摸的绝对坐标
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();


        //处理边界的问题  x  y 轴


        Log.d(TAG, "onTouchEvent:==rawX "+rawX);
        Log.d(TAG, "onTouchEvent:==rawY "+rawY);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 上一次离开时的坐标
                lastX = rawX;
                lastY = rawY;
                break;
            case MotionEvent.ACTION_MOVE:
                // 两次的偏移量
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;

                if (rawX<(mselfWidth/2) || rawX>(screenWidth-mselfWidth/2) ||rawY<(statusBarHeight+actionBarHeight) || rawY>(screenHeight-mselfHeigh/2) ){

                    Log.d(TAG, "onTouchEvent: 越界");
                    Log.d(TAG, "onTouchEvent: statusBarHeight=="+statusBarHeight);
                    Log.d(TAG, "onTouchEvent: actionBarHeight=="+actionBarHeight);


                }else {


                    moveView(offsetX, offsetY);
                    // 不断修改上次移动完成后坐标
                    lastX = rawX;
                    lastY = rawY;
                }

                break;
            default:
                break;
        }
        return true;

        }



    private void moveView(int offsetX, int offsetY) {


//        Log.d(TAG, "moveView:==offsetX "+offsetX);
//        Log.d(TAG, "moveView:==offsetY "+offsetY);



        // 方法一
        // layout(getLeft() + offsetX, getTop() + offsetY, getRight() +
        // offsetX, getBottom() + offsetY);

        // 方法二
         offsetLeftAndRight(offsetX);
         offsetTopAndBottom(offsetY);

        // 方法三
        // LinearLayout.LayoutParams layoutParams = (LayoutParams)
        // getLayoutParams();
        // layoutParams.leftMargin = getLeft() + offsetX;
        // layoutParams.topMargin = getTop() + offsetY;
        // setLayoutParams(layoutParams);

        // 方法四
        // ViewGroup.MarginLayoutParams layoutParams = (MarginLayoutParams)
        // getLayoutParams();
        // layoutParams.leftMargin = getLeft() + offsetX;
        // layoutParams.topMargin = getLeft() + offsetY;
        // setLayoutParams(layoutParams);

        // 方法五
//        ((View) getParent()).scrollBy(-offsetX, -offsetY);
    }
}
