package com.example.dust.persondemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author dust
 * @function  雷达效果的类
 * @created at 2018/6/20
 */
public class RadarGradientView extends View {


    public RadarGradientView(Context context) {
        super(context);

        // 画圆用到的paint
        mPaintCircle = new Paint();
        mPaintCircle.setStyle(Paint.Style.STROKE); // 描边
        mPaintCircle.setStrokeWidth(1); // 宽度
        mPaintCircle.setAlpha(100); // 透明度
        mPaintCircle.setAntiAlias(true); // 抗锯齿
        mPaintCircle.setColor(Color.parseColor("#B0C4DE")); // 设置颜色 亮钢兰色

        // 扫描用到的paint
        mPaintRadar = new Paint();
        mPaintRadar.setStyle(Paint.Style.FILL_AND_STROKE); // 填充
        mPaintRadar.setAntiAlias(true); // 抗锯齿

        post(run);
    }

    public RadarGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RadarGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }




    private int mWidth, mHeight;

    //五个圆
    private float[] pots = {0.05f, 0.1f, 0.15f, 0.2f, 0.25f};
    private int[] colors = {Color.RED, Color.GRAY, Color.BLUE, Color.GREEN, Color.YELLOW};


    private Shader scanShader; // 扫描渲染shader
    private Matrix matrix = new Matrix(); // 旋转需要的矩阵
    private int scanSpeed = 5; // 扫描速度
    private int scanAngle; // 扫描旋转的角度

    private Paint mPaintCircle; // 画圆用到的paint
    private Paint mPaintRadar; // 扫描用到的paint



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < pots.length; i++) {
            mPaintCircle.setColor(colors[i]);
            canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth * pots[i], mPaintCircle);
        }

        // 画布的旋转变换 需要调用save() 和 restore()
        canvas.save();

//        scanShader = new SweepGradient(mWidth / 2, mHeight / 2, new int[]{Color.TRANSPARENT, Color.parseColor("#84B5CA")}, null);
        //浪的颜色
        scanShader = new SweepGradient(mWidth / 2, mHeight / 2, colors, null);
        mPaintRadar.setShader(scanShader); // 设置着色器
        canvas.concat(matrix);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth * pots[4], mPaintRadar);

        canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 取屏幕的宽高是为了把雷达放在屏幕的中间
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mWidth = mHeight = Math.min(mWidth, mHeight);
    }

    private Runnable run = new Runnable() {
        @Override
        public void run() {
            scanAngle = (scanAngle + scanSpeed) % 360; // 旋转角度 对360取余
            matrix.postRotate(scanSpeed, mWidth / 2, mHeight / 2); // 旋转矩阵
            invalidate(); // 通知view重绘
            postDelayed(run, 50); // 调用自身 重复绘制
        }
    };

}
