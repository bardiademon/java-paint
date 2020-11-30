package com.bardiademon.JavaPaint.Shapes.Stars;

import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public final class FourPointStar extends Stars
{
    @bardiademon
    @Override
    public void paint (final Graphics2D g)
    {
        if (getPoint () != null && getSize () != null)
        {
            if (isFill ())
            {
                fill ((point , size) -> {
                    final FourPointStar fourPointStar = new FourPointStar ();
                    fourPointStar.shape (FourPointStar.this);
                    fourPointStar.setPoint (point);
                    fourPointStar.setSize (size);
                    fourPointStar.draw (g);
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

        g.setColor (getColor ());
        g.setStroke (new BasicStroke (getThickness ()));

        final Point point = getPoint ();
        final Point halfPoint = getHalfPoint ();
        final Point allPoint = getAllPoint ();

        final Point lineUpStart = point (halfPoint.x , point.y);

        final Point lineUpLeftEnd = point (ctpFirstHalfX (80) , ctpFirstHalfY (80));
        final Point lineUpRightEnd = point (ctpSecondHalfX (20) , lineUpLeftEnd.y);
        final Point lineDownStart = point (lineUpStart.x , allPoint.y);
        final Point lineDownLeftEnd = point (lineUpLeftEnd.x , ctpSecondHalfY (20));
        final Point lineDownRightEnd = point (lineUpRightEnd.x , lineDownLeftEnd.y);

        g.drawLine (lineUpStart.x , lineUpStart.y , lineUpLeftEnd.x , lineUpLeftEnd.y);
        g.drawLine (lineUpStart.x , lineUpStart.y , lineUpLeftEnd.x , lineUpLeftEnd.y);
        g.drawLine (lineUpStart.x , lineUpStart.y , lineUpRightEnd.x , lineUpRightEnd.y);
        g.drawLine (lineDownStart.x , lineDownStart.y , lineDownLeftEnd.x , lineDownLeftEnd.y);
        g.drawLine (lineDownStart.x , lineDownStart.y , lineDownRightEnd.x , lineDownRightEnd.y);
        g.drawLine (lineUpRightEnd.x , lineUpRightEnd.y , allPoint.x , halfPoint.y);
        g.drawLine (lineDownRightEnd.x , lineDownRightEnd.y , allPoint.x , halfPoint.y);
        g.drawLine (lineUpLeftEnd.x , lineUpLeftEnd.y , point.x , halfPoint.y);
        g.drawLine (lineDownLeftEnd.x , lineDownLeftEnd.y , point.x , halfPoint.y);
    }
}
