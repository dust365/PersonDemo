package cross.model;

import android.graphics.Path;

/**
 * Created by cross on 17/1/20.
 */

public class PathArea {
    private String AreaName; //名称
    private Path path;
    private String fillColor; //填充体颜色
    private double fillAlpha; //填充体透明度
    private double strokeAlpha; //边框透明度
    private String strokeColor;//边框颜色
    private int strokeWidth;//边框宽度



    private int state=0;//默认的0 没选中   1是钣金  2 是喷漆


    private String fillColor1="#d4237a"; //钣金的填充体颜色（红色）


    private String fillColor2="#9eea6a"; //漆的填充体颜色(浅绿色色)





    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public double getFillAlpha() {
        return fillAlpha;
    }

    public void setFillAlpha(double fillAlpha) {
        this.fillAlpha = fillAlpha;
    }

    public double getStrokeAlpha() {
        return strokeAlpha;
    }

    public void setStrokeAlpha(double strokeAlpha) {
        this.strokeAlpha = strokeAlpha;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getFillColor1() {
        return fillColor1;
    }

    public void setFillColor1(String fillColor1) {
        this.fillColor1 = fillColor1;
    }

    public String getFillColor2() {
        return fillColor2;
    }

    public void setFillColor2(String fillColor2) {
        this.fillColor2 = fillColor2;
    }
}
