package com.bardiademon.JavaPaint.Shapes.Stars;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

public final class FourPointStar extends Stars
{
    @Override
    public void paint (Graphics2D g)
    {
        if (getPoint () != null && getSize () != null)
        {
            apply ();
            Point point = getPoint ();
            Point halfPoint = getHalfPoint ();
            Point allPoint = getAllPoint ();

            Point lineUpStart = point (halfPoint.x , point.y);

            Point lineUpLeftEnd = point (ctpFirstHalfX (80) , ctpFirstHalfY (80));
            Point lineUpRightEnd = point (ctpSecondHalfX (20) , lineUpLeftEnd.y);
            Point lineDownStart = point (lineUpStart.x , allPoint.y);
            Point lineDownLeftEnd = point (lineUpLeftEnd.x , ctpSecondHalfY (20));
            Point lineDownRightEnd = point (lineUpRightEnd.x , lineDownLeftEnd.y);

            g.setColor (getColor ());
            g.setStroke (new BasicStroke (getThickness ()));

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

}
