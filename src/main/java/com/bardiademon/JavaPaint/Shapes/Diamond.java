package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public final class Diamond extends Rectangle {
    @bardiademon
    @Override
    public void paint(final Graphics2D g) {
        if (getSize() != null && getPoint() != null) {
            if (isFill()) {
                fill((point , size) ->
                {
                    final Diamond diamond = new Diamond();
                    diamond.shape(Diamond.this);
                    diamond.setPoint(point);
                    diamond.setSize(size);
                    diamond.draw(g);
                } , size(getSize().width , getSize().height) , point(getPoint().x , getPoint().y));
            }
            draw(g);
        }
    }

    @bardiademon
    @Override
    protected void draw(Graphics2D g) {
        apply();

        final Point point = getPoint();
        final Point halfPoint = getHalfPoint();
        final Point allPoint = getAllPoint();

        final Point point1 = point(halfPoint.x , point.y);
        final Point point2 = point(point.x , halfPoint.y);
        final Point point3 = point(halfPoint.x , allPoint.y);
        final Point point4 = point(allPoint.x , halfPoint.y);

        g.setStroke(new BasicStroke(getThickness()));

        g.drawLine(point1.x , point1.y , point2.x , point2.y);
        g.drawLine(point2.x , point2.y , point3.x , point3.y);
        g.drawLine(point3.x , point3.y , point4.x , point4.y);
        g.drawLine(point4.x , point4.y , point1.x , point1.y);
    }
}
