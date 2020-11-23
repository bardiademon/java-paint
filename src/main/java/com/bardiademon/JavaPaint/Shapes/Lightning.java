package com.bardiademon.JavaPaint.Shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

public final class Lightning extends Rectangle
{
    @Override
    public void paint (final Graphics2D g)
    {
        final Point point = getPoint ();
        if (getSize () != null && point != null)
        {
            apply ();

            final Point allPoint = getAllPoint ();

            final Point point1 = point (ctpFirstHalfX (80) , point.y);
            final Point point2 = point (point.x , ctpFirstHalfY (40));
            final Point point3 = point (ctpFirstHalfX (70) , ctpFirstHalfY (80));
            final Point point4 = point (ctpFirstHalfX (50) , ctpFirstHalfY (90));
            final Point point5 = point (ctpSecondHalfX (10) , ctpSecondHalfY (35));
            final Point point6 = point (ctpFirstHalfX (98) , ctpSecondHalfY (45));
            final Point point7 = point (allPoint.x , allPoint.y);
            final Point point8 = point (ctpSecondHalfX (40) , ctpSecondHalfY (20));
            final Point point9 = point (ctpSecondHalfX (50) , ctpSecondHalfY (10));
            final Point point10 = point (ctpSecondHalfX (5) , ctpFirstHalfY (60));
            final Point point11 = point (ctpSecondHalfX (20) , ctpFirstHalfY (50));

            g.setColor (getColor ());
            g.setStroke (new BasicStroke (getThickness ()));
            g.setBackground (getBackgroundColor ());

            g.drawLine (point1.x , point1.y , point2.x , point2.y);
            g.drawLine (point2.x , point2.y , point3.x , point3.y);
            g.drawLine (point3.x , point3.y , point4.x , point4.y);
            g.drawLine (point4.x , point4.y , point5.x , point5.y);
            g.drawLine (point5.x , point5.y , point6.x , point6.y);
            g.drawLine (point6.x , point6.y , point7.x , point7.y);
            g.drawLine (point7.x , point7.y , point8.x , point8.y);
            g.drawLine (point8.x , point8.y , point9.x , point9.y);
            g.drawLine (point9.x , point9.y , point10.x , point10.y);
            g.drawLine (point10.x , point10.y , point11.x , point11.y);
            g.drawLine (point11.x , point11.y , point1.x , point1.y);
        }
    }
}
