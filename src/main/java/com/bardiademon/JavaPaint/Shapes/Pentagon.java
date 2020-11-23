package com.bardiademon.JavaPaint.Shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

public final class Pentagon extends Rectangle
{
    @Override
    public void paint (final Graphics2D g)
    {
        if (getSize () != null && getPoint () != null)
        {
            apply ();

            final Point point1 = point (getHalfPoint ().x , getPoint ().y);
            final Point point2 = point (getPoint ().x , ctpFirstHalfY (90));
            final Point point3 = point (ctpFirstHalfX (50) , getAllPoint ().y);
            final Point point4 = point (ctpSecondHalfX (50) , getAllPoint ().y);
            final Point point5 = point (getAllPoint ().x , point2.y);

            g.setColor (getColor ());
            g.setBackground (getBackgroundColor ());
            g.setStroke (new BasicStroke (getThickness ()));

            g.drawLine (point1.x , point1.y , point2.x , point2.y);
            g.drawLine (point2.x , point2.y , point3.x , point3.y);
            g.drawLine (point3.x , point3.y , point4.x , point4.y);
            g.drawLine (point4.x , point4.y , point5.x , point5.y);
            g.drawLine (point5.x , point5.y , point1.x , point1.y);

        }
    }
}
