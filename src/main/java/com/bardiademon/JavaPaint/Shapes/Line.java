package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public class Line extends Pen {
    private Point point1;
    private Point point2;

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public void paint(final Graphics2D g) {
        if (point1 != null && point2 != null) {
            g.setStroke(new BasicStroke(getThickness()));
            g.setColor(getColor());
            g.drawLine(point1.x , point1.y , point2.x , point2.y);
        }
    }

}
