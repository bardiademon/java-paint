package com.bardiademon.JavaPaint.Shapes.Arrow;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

public final class UpDownArrow extends Arrow
{
    @Override
    public void paint (final Graphics2D g)
    {
        if (getSize () != null && getPoint () != null)
        {
            apply ();

            final Point point1 = point (getHalfPoint ().x , getAllPoint ().y);
            final Point point2 = point (getAllPoint ().x , getHalfPoint ().y);
            final Point point3 = point (ctpSecondHalfX (50) , point2.y);
            final Point point4 = point (point3.x , getPoint ().y);
            final Point point5 = point (ctpFirstHalfX (50) , getPoint ().y);
            final Point point6 = point (point5.x , point2.y);
            final Point point7 = point (getPoint ().x , point2.y);

            g.setStroke (new BasicStroke (getThickness ()));
            g.setColor (getColor ());
            g.setBackground (getBackgroundColor ());

            g.drawLine (point1.x , point1.y , point2.x , point2.y);
            g.drawLine (point2.x , point2.y , point3.x , point3.y);
            g.drawLine (point3.x , point3.y , point4.x , point4.y);
            g.drawLine (point4.x , point4.y , point5.x , point5.y);
            g.drawLine (point5.x , point5.y , point6.x , point6.y);
            g.drawLine (point6.x , point6.y , point7.x , point7.y);
            g.drawLine (point7.x , point7.y , point1.x , point1.y);
        }
    }
}
