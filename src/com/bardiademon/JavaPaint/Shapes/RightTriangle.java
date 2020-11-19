package com.bardiademon.JavaPaint.Shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

public final class RightTriangle extends Triangle
{
    @Override
    public void paint (Graphics2D g)
    {
        if (getSize () != null && getPoint () != null)
        {
            apply ();

            Point point1 = point (getPoint ().x , getPoint ().y);
            Point point2 = point (getPoint ().x , getAllPoint ().y);
            Point point3 = point (getAllPoint ().x , getAllPoint ().y);

            g.setBackground (getBackgroundColor ());
            g.setColor (getColor ());
            g.setStroke (new BasicStroke (getThickness ()));

            g.drawLine (point1.x , point1.y , point2.x , point2.y);
            g.drawLine (point2.x , point2.y , point3.x , point3.y);
            g.drawLine (point3.x , point3.y , point1.x , point1.y);

        }
    }
}
