package com.bardiademon.JavaPaint.Shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

public final class Diamond extends Rectangle
{
    @Override
    public void paint (final Graphics2D g)
    {
        final Point point = getPoint ();
        if (getSize () != null && point != null)
        {
            apply ();

            final Point halfPoint = getHalfPoint ();
            final Point allPoint = getAllPoint ();

            final Point point1 = point (halfPoint.x , point.y);
            final Point point2 = point (point.x , halfPoint.y);
            final Point point3 = point (halfPoint.x , allPoint.y);
            final Point point4 = point (allPoint.x , halfPoint.y);

            g.setStroke (new BasicStroke (getThickness ()));
            g.setColor (getColor ());
            g.setBackground (getBackgroundColor ());

            g.drawLine (point1.x , point1.y , point2.x , point2.y);
            g.drawLine (point2.x , point2.y , point3.x , point3.y);
            g.drawLine (point3.x , point3.y , point4.x , point4.y);
            g.drawLine (point4.x , point4.y , point1.x , point1.y);

        }
    }
}
