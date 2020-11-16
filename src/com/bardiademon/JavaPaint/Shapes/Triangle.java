package com.bardiademon.JavaPaint.Shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

public final class Triangle extends Rectangle
{
    @Override
    public void paint (Graphics2D g)
    {
        final Point point = getPoint ();
        if (getSize () != null && point != null)
        {
            apply ();

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
}
