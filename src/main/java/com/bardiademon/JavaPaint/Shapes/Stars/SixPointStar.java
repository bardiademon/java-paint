package com.bardiademon.JavaPaint.Shapes.Stars;

import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public final class SixPointStar extends Stars implements Star
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
                    final SixPointStar sixPointStar = new SixPointStar ();
                    sixPointStar.shape (SixPointStar.this);
                    sixPointStar.setPoint (point);
                    sixPointStar.setSize (size);
                    sixPointStar.draw (g);
                } , size (getSize ().width , getSize ().height) , point (getPoint ().x , getPoint ().y));
            }
            draw (g);
        }
    }

    @bardiademon
    @Override
    protected void draw (Graphics2D g)
    {

        apply ();

        final Point point = getPoint ();
        final Point halfPoint = getHalfPoint ();
        final Point allPoint = getAllPoint ();

        final Point point1 = point (halfPoint.x , point.y);
        final Point point2 = point (ctpFirstHalfX (60) , ctpFirstHalfY (50));
        final Point point3 = point (point.x , point2.y);
        final Point point4 = point (ctpFirstHalfX (30) , ctpY (50));
        final Point point5 = point (point.x , ctpSecondHalfY (50));
        final Point point6 = point (point2.x , point5.y);
        final Point point7 = point (halfPoint.x , allPoint.y);
        final Point point8 = point (ctpSecondHalfX (40) , point5.y);
        final Point point9 = point (allPoint.x , point8.y);
        final Point point10 = point (ctpSecondHalfX (70) , point4.y);
        final Point point11 = point (allPoint.x , point2.y);
        final Point point12 = point (point8.x , point2.y);

        g.setStroke (new BasicStroke (getThickness ()));
        g.setColor (getColor ());

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
        g.drawLine (point11.x , point11.y , point12.x , point12.y);
        g.drawLine (point12.x , point12.y , point1.x , point1.y);
    }
}
