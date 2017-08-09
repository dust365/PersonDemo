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
}
