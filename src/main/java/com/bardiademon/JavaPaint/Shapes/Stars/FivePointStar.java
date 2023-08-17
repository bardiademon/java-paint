package com.bardiademon.JavaPaint.Shapes.Stars;

import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public class FivePointStar extends Stars implements Star {
    @bardiademon
    @Override
    public void paint(final Graphics2D g) {
        if (getSize() != null && getPoint() != null) {
//            if (isFill ())
//            {
//                fill ((point , size) -> {
//                    final FivePointStar fivePointStar = new FivePointStar ();
//                    fivePointStar.shape (FivePointStar.this);
//                    fivePointStar.setPoint (point);
//                    fivePointStar.setSize (size);
//                    fivePointStar.draw (g);
//                } , size (getSize ().width , getSize ().height) , point (getPoint ().x , getPoint ().y));
//            }
            draw(g);
        }
    }

    @bardiademon
    @Override
    protected void draw(final Graphics2D g) {
        apply();

        final Point point1 = point(getHalfPoint().x , getPoint().y);
        final Point point2 = point(ctpFirstHalfX(80) , ctpFirstHalfY(80));
        final Point point3 = point(getPoint().x , ctpFirstHalfY(80));
        final Point point4 = point(ctpFirstHalfX(60) , ctpSecondHalfY(20));
        final Point point5 = point(ctpFirstHalfX(50) , getAllPoint().y);
        final Point point6 = point(getHalfPoint().x , ctpSecondHalfY(50));
        final Point point7 = point(ctpSecondHalfX(50) , getAllPoint().y);
        final Point point8 = point(ctpSecondHalfX(40) , point4.y);
        final Point point9 = point(getAllPoint().x , point3.y);
        final Point point11 = point(ctpSecondHalfX(20) , point2.y);

        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness()));

        // g.drawRect (getPoint ().x , getPoint ().y , getSize ().width , getSize ().height);
        g.drawLine(point1.x , point1.y , point2.x , point2.y);
        g.drawLine(point2.x , point2.y , point3.x , point3.y);
        g.drawLine(point3.x , point3.y , point4.x , point4.y);
        g.drawLine(point4.x , point4.y , point5.x , point5.y);
        g.drawLine(point5.x , point5.y , point6.x , point6.y);
        g.drawLine(point6.x , point6.y , point7.x , point7.y);
        g.drawLine(point7.x , point7.y , point8.x , point8.y);
        g.drawLine(point8.x , point8.y , point9.x , point9.y);
        g.drawLine(point9.x , point9.y , point11.x , point11.y);
        g.drawLine(point1.x , point1.y , point11.x , point11.y);
    }
}
