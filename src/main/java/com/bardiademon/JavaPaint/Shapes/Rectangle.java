package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.Mth;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public class Rectangle extends Shape {
    @bardiademon
    private Point allPoint, allPoint2, halfPoint, halfPoint2;

    @bardiademon
    private Size arc;

    @bardiademon
    public Rectangle() {
        arc = new Size(0 , 0);
    }

    @bardiademon
    public Size getArc() {
        return arc;
    }

    @bardiademon
    public void setArc(Size arc) {
        this.arc = arc;
    }

    @bardiademon
    public void apply() {
        final Point point = getPoint();
        final Size size = getSize();

        if (point != null && size != null) {
            allPoint = Shape.point((size.width + point.x) , (size.height + point.y));
            halfPoint = Shape.point(((size.width / 2) + point.x) , ((size.height / 2) + point.y));
            allPoint2 = Shape.point(allPoint.x - getPoint().x , allPoint.y - getPoint().y);
            halfPoint2 = Shape.point(allPoint2.x / 2 , allPoint2.y / 2);
        }
    }

    @bardiademon
    public int allX(int width , int x) {
        return (width + x);
    }

    @bardiademon
    public int allX2(int width , int x) {
        return allX(width , x) - getAllPoint().x;
    }

    @bardiademon
    // CTP => calculateThePercentage
    public int CTPX(int percentage) {
        return getPoint().x + (Mth.percentageOfAValue(getAllPoint2().x , percentage));
    }

    @bardiademon
    // CTP => calculateThePercentage
    public int ctpY(int percentage) {
        return getPoint().y + (Mth.percentageOfAValue(getAllPoint2().y , percentage));
    }

    @bardiademon
    // CTP => calculateThePercentage
    public int ctpX(int percentage) {
        return getPoint().x + (Mth.percentageOfAValue(getAllPoint2().x , percentage));
    }

    @bardiademon
    // CTP => calculateThePercentage
    public int ctpFirstHalfX(int percentage) {
        return getPoint().x + (Mth.percentageOfAValue(getHalfPoint2().x , percentage));
    }

    @bardiademon
    // CTP => calculateThePercentage
    public int ctpFirstHalfY(int percentage) {
        return getPoint().y + (Mth.percentageOfAValue(getHalfPoint2().y , percentage));
    }

    @bardiademon
    // CTP => calculateThePercentage
    public int ctpSecondHalfX(int percentage) {
        return getPoint().x + ((Mth.percentageOfAValue(getHalfPoint2().x , percentage)) + getHalfPoint2().x);
    }

    @bardiademon
    // CTP => calculateThePercentage
    public int ctpSecondHalfY(int percentage) {
        return getPoint().y + ((Mth.percentageOfAValue(getHalfPoint2().y , percentage)) + getHalfPoint2().y);
    }

    @bardiademon
    public Point getAllPoint() {
        return allPoint;
    }

    @bardiademon
    public Point getHalfPoint() {
        return halfPoint;
    }

    @bardiademon
    public Point getAllPoint2() {
        return allPoint2;
    }

    @bardiademon
    public Point getHalfPoint2() {
        return halfPoint2;
    }

    @bardiademon
    @Override
    public void paint(Graphics2D g) {
        if (getSize() != null && getPoint() != null) {
            apply();

            g.setStroke(new BasicStroke(getThickness()));

            if (isFill()) {
                g.setColor(getBackgroundColor());
                g.fillRoundRect(getPoint().x , getPoint().y , getSize().width , getSize().height , getArc().width , getArc().height);
            }

            g.setColor(getColor());
            g.drawRoundRect(getPoint().x , getPoint().y , getSize().width , getSize().height , getArc().width , getArc().height);

        }
    }
}
