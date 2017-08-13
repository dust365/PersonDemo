package com.example.dust.persondemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PaintView extends View {

	public PaintView(Context context) {
		super(context);
		mPaint = new Paint();
	}

	private Paint mPaint;

	public PaintView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
	}


	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

//		canvas.drawColor(Color.BLUE);


		//重置
		mPaint.reset();
		mPaint.setColor(Color.RED);
//		mPaint.setAlpha(255);
		//设置画笔的样式
//		mPaint.setStyle(Paint.Style.FILL);//填充内容
//		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mPaint.setStyle(Paint.Style.STROKE);//描边
		//画笔的宽度
		mPaint.setStrokeWidth(20);
		//线帽
		mPaint.setStrokeCap(Paint.Cap.BUTT);//没有
//		mPaint.setStrokeCap(Paint.Cap.ROUND);//圆形
//		mPaint.setStrokeCap(Paint.Cap.SQUARE);//方形

//		mPaint.setStrokeJoin(Paint.Join.MITER);//锐角
//		mPaint.setStrokeJoin(Paint.Join.ROUND);//圆弧
//		mPaint.setStrokeJoin(Paint.Join.BEVEL);//直线

//		canvas.drawCircle(100, 100, 100, mPaint);


		//测试1 画一个正方形
		Path path = new Path();
		path.moveTo(100, 100);
		path.lineTo(300, 100);
		path.lineTo(300, 300);
		path.lineTo(100, 300);
		path.lineTo(100, 90);

		mPaint.setStrokeJoin(Paint.Join.MITER);
		canvas.drawPath(path, mPaint);

//
//		path.moveTo(100, 400);
//		path.lineTo(300, 500);
//		path.lineTo(100, 700);
//		mPaint.setStrokeJoin(Paint.Join.ROUND);
//		canvas.drawPath(path, mPaint);
////
//		path.moveTo(100, 800);
//		path.lineTo(300, 800);
//		path.lineTo(100, 1100);
//		mPaint.setStrokeJoin(Paint.Join.BEVEL);
//		canvas.drawPath(path, mPaint);

		//2.
		// 绘制颜色	drawColor, drawRGB, drawARGB	使用单一颜色填充整个画布
		//绘制基本形状	drawPoint, drawPoints, drawLine, drawLines, drawRect, drawRoundRect, drawOval, drawCircle, drawArc	依次为 点、线、矩形、圆角矩形、椭圆、圆、圆弧
		//绘制图片	drawBitmap, drawPicture	绘制位图和图片
		//绘制文本	drawText, drawPosText, drawTextOnPath	依次为 绘制文字、绘制文字时指定每个文字位置、根据路径绘制文字
		//绘制路径	drawPath	绘制路径，绘制贝塞尔曲线时也需要用到该函数
		//顶点操作	drawVertices, drawBitmapMesh	通过对顶点操作可以使图像形变，drawVertices直接对画布作用、 drawBitmapMesh只对绘制的Bitmap作用
		//画布剪裁	clipPath, clipRect	设置画布的显示区域
		//画布快照	save, restore, saveLayerXxx, restoreToCount, getSaveCount	依次为 保存当前状态、 回滚到上一次保存的状态、 保存图层状态、 回滚到指定状态、 获取保存次数
		//画布变换	translate, scale, rotate, skew	依次为 位移、缩放、 旋转、错切
		//Matrix(矩阵)	getMatrix, setMatrix, concat	实际上画布的位移，缩放等操作的都是图像矩阵Matrix， 只不过Matrix比较难以理解和使用，故封装了一些常用的方法。

    //画 一个点
		  canvas.drawPoint(50,50,mPaint);

		//绘制矩形

//		Rect rect = new Rect(10,10,100,100);
//
//		canvas.drawRect(rect,mPaint);

		//绘制圆角矩形
		RectF rect = new RectF(10,10,100,100);

          canvas.drawRoundRect(rect,10,10,mPaint);


		// 绘制椭圆
		RectF rectF = new RectF(400,400,100,600);
		canvas.drawOval(rectF,mPaint);


       //绘制圆形：
		canvas.drawCircle(500,500,50,mPaint);  // 绘制一个圆心坐标在(500,500)，半径为400 的圆。



		//  mPaint.setColor(Color.BLUE);  绘制圆弧
		canvas.drawArc(rectF,0,90,true,mPaint);



	}



}
