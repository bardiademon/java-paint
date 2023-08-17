package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public final class RightTriangle extends Triangle {
    @bardiademon
    @Override
    public void paint(final Graphics2D g) {
        if (getSize() != null && getPoint() != null) {
//            if (isFill ())
//            {
//                fill ((point , size) -> {
//                    final RightTriangle rightTriangle = new RightTriangle ();
//                    rightTriangle.shape (RightTriangle.this);
//                    rightTriangle.setPoint (point);
//                    rightTriangle.setSize (size);
//                    rightTriangle.draw (g);
//                } , size (getSize ().width , getSize ().height) , point (getPoint ().x , getPoint ().y));
//            }
            draw(g);
        }
    }

    @bardiademon
    @Override
    protected void draw(final Graphics2D g) {
        apply();

        Point point1 = point(getPoint().x , getPoint().y);
        Point point2 = point(getPoint().x , getAllPoint().y);
        Point point3 = point(getAllPoint().x , getAllPoint().y);

        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness()));

        g.drawLine(point1.x , point1.y , point2.x , point2.y);
        g.drawLine(point2.x , point2.y , point3.x , point3.y);
        g.drawLine(point3.x , point3.y , point1.x , point1.y);
    }
}
