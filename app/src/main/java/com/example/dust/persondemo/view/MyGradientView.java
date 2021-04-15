package com.example.dust.persondemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
//import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.dust.persondemo.R;

/**
 *
 */

public class MyGradientView extends View {
    private Paint mPaint;
    private Bitmap mBitMap = null;

    private int mWidth;
    private int mHeight;
    private int[] mColors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

    public MyGradientView(Context context) {
        super(context);
        mBitMap = ((BitmapDrawable)getResources().getDrawable(R.drawable.xyjy2)).getBitmap();
        mPaint = new Paint();
        mWidth = mBitMap.getWidth();
        mHeight = mBitMap.getHeight();
    }

    public MyGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBitMap = ((BitmapDrawable)getResources().getDrawable(R.drawable.xyjy2)).getBitmap();
        mPaint = new Paint();
        mWidth = mBitMap.getWidth();
        mHeight = mBitMap.getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        /**
         * TileMode.CLAMP 拉伸最后一个像素去铺满剩下的地方
         * TileMode.MIRROR 通过镜像翻转铺满剩下的地方。
         * TileMode.REPEAT 重复图片平铺整个画面（电脑设置壁纸）
         * 在图片和显示区域大小不符的情况进行扩充渲染
         */


        /** 图像着色器  **/
//      BitmapShader bitMapShader = new BitmapShader(mBitMap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//      BitmapShader bitMapShader = new BitmapShader(mBitMap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
//        mPaint.setShader(bitMapShader);
//        mPaint.setAntiAlias(true);
        //设置像素矩阵，来调整大小，为了解决宽高不一致的问题。
//        float scale = Math.max(mWidth,mHeight) / Math.min(mWidth,mHeight);
//
//        Matrix matrix = new Matrix();
//        matrix.setScale(scale,scale);
//        bitMapShader.setLocalMatrix(matrix);
//
        //如果使用drawBitmap  无法画一个原型  所以放弃
//        canvas.drawBitmap(mBitMap,10,20,mPaint);


//        canvas.drawCircle(mHeight / 2,mHeight / 2, mHeight / 2 ,mPaint);
//        canvas.drawOval(new RectF(0 , 0, mWidth, mHeight),mPaint);
//        canvas.drawRect(new Rect(0,0 , 1000, 1600),mPaint);





//        通过shapeDrawable也可以实现
//        ShapeDrawable shapeDrawble = new ShapeDrawable(new OvalShape());
//        shapeDrawble.getPaint().setShader(bitMapShader);
//        shapeDrawble.setBounds(0,0,mWidth,mWidth);
//        shapeDrawble.draw(canvas);

        /**线性渐变
         * x0, y0, 起始点
         *  x1, y1, 结束点
         * int[]  mColors, 中间依次要出现的几个颜色
         * float[] positions,数组大小跟colors数组一样大，中间依次摆放的几个颜色分别放置在那个位置上(参考比例从左往右)
         *    tile
         */
//	LinearGradient linearGradient = new LinearGradient( 0, 0,800, 800, mColors, null, Shader.TileMode.CLAMP);
//        // linearGradient = new LinearGradient(0, 0, 400, 400, mColors, null, Shader.TileMode.REPEAT);
//		mPaint.setShader(linearGradient);
//		canvas.drawRect(0, 0, 800, 800, mPaint);


        /**  环形渲染  **/
//        RadialGradient mRadialGradient = new RadialGradient(300, 300, 100, mColors, null, Shader.TileMode.REPEAT);
//		mPaint.setShader(mRadialGradient);
//		canvas.drawCircle(300, 300, 300, mPaint);


        /**  渐变渲染/梯度渲染 **/
//        SweepGradient mSweepGradient = new SweepGradient(300, 300, mColors, null);
//		mPaint.setShader(mSweepGradient);
//		canvas.drawCircle(300, 300, 300, mPaint);


        /**  组合渲染 **/
//        LinearGradient mLinearGradient = new LinearGradient( 0, 0,200, 200, mColors, null, Shader.TileMode.CLAMP);
//        BitmapShader mBitmapShader = new BitmapShader(mBitMap, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);
//
//        ComposeShader mComposeShader = new ComposeShader(mLinearGradient, mBitmapShader, PorterDuff.Mode.SRC_IN);
//        mPaint.setShader(mComposeShader);
////        canvas.drawRect(0, 0, 800, 1000, mPaint);
//        canvas.drawCircle(400, 400, 400, mPaint);

        /***************用ComposeShader即可实现心形图渐变效果*********************************/
        //创建BitmapShader，用以绘制心
        Bitmap mBitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.heart)).getBitmap();
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        //创建LinearGradient，用以产生从左上角到右下角的颜色渐变效果
        LinearGradient linearGradient = new LinearGradient(0, 0, mWidth, mHeight, Color.GREEN, Color.BLUE, Shader.TileMode.CLAMP);
        //bitmapShader对应目标像素，linearGradient对应源像素，像素颜色混合采用MULTIPLY模式
        ComposeShader composeShader = new ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.MULTIPLY);
        //ComposeShader composeShader2 = new ComposeShader(composeShader, linearGradient, PorterDuff.Mode.MULTIPLY);
        //将组合的composeShader作为画笔paint绘图所使用的shader
        mPaint.setShader(composeShader);

        //用composeShader绘制矩形区域
        canvas.drawRect(0, 0, mBitmap.getWidth(), mBitmap.getHeight(), mPaint);


        //所谓渲染就是对于我们绘制区域进行按照上诉渲染规则进行色彩的填充
    }
}
