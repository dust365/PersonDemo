package com.example.dust.persondemo.bezier;

import android.animation.TypeEvaluator;
import android.graphics.PointF;


/**
 * Created by dust on 2017/5/6.
 */

public class BezierTypeEvaluator implements TypeEvaluator<PointF> {


    private  PointF pointF2;
    private  PointF pointF1;

    public BezierTypeEvaluator(PointF pointF1,PointF pointF2){
        this.pointF1=pointF1;
        this.pointF2=pointF2;

    }

    @Override
    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
      //fraction  百分比0-1.0f  ， 该duration 时间段里面任何时间点完成度

        PointF pointF=new PointF();
        pointF.x=startValue.x*(1-fraction)*(1-fraction)*(1-fraction)
                +3*pointF1.x*fraction*(1-fraction)*(1-fraction)
                +3*pointF2.x*fraction*fraction*(1-fraction)
                +endValue.x*fraction*fraction*fraction;
        pointF.y=startValue.y*(1-fraction)*(1-fraction)*(1-fraction)
                +3*pointF1.y*fraction*(1-fraction)*(1-fraction)
                +3*pointF2.y*fraction*fraction*(1-fraction)
                +endValue.y*fraction*fraction*fraction;

        return pointF;
    }
}
