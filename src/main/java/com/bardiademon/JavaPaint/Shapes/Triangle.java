package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public class Triangle extends Rectangle
{
    @bardiademon
    @Override
    public void paint (final Graphics2D g)
    {
        if (getSize () != null && getPoint () != null)
        {
            if (isFill ())
            {
                fill ((point , size) -> {
                    final Triangle triangle = new Triangle ();
                    triangle.shape (Triangle.this);
                    triangle.setPoint (point);
                    triangle.setSize (size);
                    triangle.draw (g);
                } , size (getSize ().width , getSize ().height) , point (getPoint ().x , getPoint ().y));
            }
            draw (g);

        }
    }

    @bardiademon
    @Override
    protected void draw (final Graphics2D g)
    {
        apply ();

        final Point point = getPoint ();
        final Point allPoint = getAllPoint ();

        final Point point1 = point (getHalfPoint ().x , point.y);
        final Point point2 = point (point.x , allPoint.y);
        final Point point3 = point (allPoint.x , allPoint.y);

        g.setColor (getColor ());
        g.setBackground (getBackgroundColor ());
        g.setStroke (new BasicStroke (getThickness ()));

        g.drawLine (point1.x , point1.y , point2.x , point2.y);
        g.drawLine (point2.x , point2.y , point3.x , point3.y);
        g.drawLine (point3.x , point3.y , point1.x , point1.y);
    }
}
