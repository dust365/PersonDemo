package view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * 根据手指拖动的当前位置，自动贴边的View
 */
public class DragView extends ImageView implements View.OnTouchListener{
    private int screenWidth;
    private int screenHeight;
    private Context mContext;
    private int lastX, lastY;
    private int left ,top;
    private ViewGroup.MarginLayoutParams layoutParams;
    private int startX;
    private int endX;
    private boolean isMoved = false;
    private onDragViewClickListener mLister;
    public interface onDragViewClickListener{
        void onDragViewClick();
    }
    public void setOnDragViewClickListener(onDragViewClickListener listener){
        this.mLister = listener;
    }
    public DragView(Context context) {
        this(context,null);
    }
    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels-getStatusBarHeight();
        init();
    }
    public void init(){
        setOnTouchListener(this);
        post(new Runnable() {
            @Override
            public void run() {
                layoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
                layoutParams.topMargin = screenHeight - getHeight();
                layoutParams.leftMargin = screenWidth - getWidth();
                setLayoutParams(layoutParams);
            }
        });
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                startX = lastX;
                break;
            case MotionEvent.ACTION_MOVE:
                isMoved = true;
                int dx = (int) event.getRawX() - lastX;
                int dy = (int) event.getRawY() - lastY;
                left = v.getLeft() + dx;
                top = v.getTop() + dy;
                int right = v.getRight() + dx;
                int bottom = v.getBottom() + dy;
                // 设置不能出界
                if (left < 0) {
                    left = 0;
                    right = left + v.getWidth();
                }
                if (right > screenWidth) {
                    right = screenWidth;
                    left = right - v.getWidth();
                }
                if (top < 0) {
                    top = 0;
                    bottom = top + v.getHeight();
                }
                if (bottom > screenHeight) {
                    bottom = screenHeight;
                    top = bottom - v.getHeight();
                }
                v.layout(left, top, right, bottom );
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                //只有滑动改变上边距时，抬起才进行设置
                if (isMoved) {
                    layoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
                    layoutParams.topMargin = top;
                    setLayoutParams(layoutParams);
                }
                endX = (int) event.getRawX();
                //滑动距离比较小，当作点击事件处理
                if (Math.abs(startX - endX) < 6) {
                    return false;
                }
                if (left +v.getWidth()/2 < screenWidth/2) {
                    startScroll(left,screenWidth/2,true);
                } else {
                    startScroll(left,screenWidth/2,false);
                }
                break;
        }
        return true;
    }
    //在此处理点击事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mLister.onDragViewClick();
        return super.onTouchEvent(event);
    }
    public void startScroll(final int start, int end, final boolean isLeft){
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(start,end).setDuration(800);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (isLeft) {
                    layoutParams.leftMargin = (int) (start*(1-animation.getAnimatedFraction()));
                } else {
                    layoutParams.leftMargin = (int) (start + (screenWidth - start - getWidth())*(animation.getAnimatedFraction()));
                }
                setLayoutParams(layoutParams);
            }
        });
        valueAnimator.start();
    }
    /**
     * 获取状态栏的高度
     * @return 状态栏高度
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}