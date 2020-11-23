package com.bardiademon.JavaPaint.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class Polygon extends Shape
{
    private final List <Polygons> polygons = new ArrayList <> ();

    private boolean finish;

    public void setPolygon (final Point point , final Color color , final int thickness)
    {
        polygons.add (new Polygons (point , color , thickness));
    }

    public boolean isFinish ()
    {
        return finish;
    }

    public void setFinish (boolean finish)
    {
        this.finish = finish;
    }

    @Override
    public void paint (final Graphics2D g)
    {
        for (int i = 0, len = polygons.size (); i < len; i++)
        {
            Polygons polygon1 = null, polygon2 = null;
            try
            {
                polygon1 = this.polygons.get (i);
                polygon2 = this.polygons.get (i + 1);

            }
            catch (Exception e)
            {
                if (isFinish ())
                {
                    polygon1 = this.polygons.get (polygons.size () - 1);
                    polygon2 = this.polygons.get (0);
                }
            }

            if (polygon1 != null && polygon2 != null)
            {
                g.setColor (polygon2.color);
                g.setStroke (new BasicStroke (polygon2.thickness));
                g.drawLine (polygon1.point.x , polygon1.point.y , polygon2.point.x , polygon2.point.y);
            }

        }
    }

    private final static class Polygons
    {
        private final Point point;
        private final Color color;
        private final int thickness;

        public Polygons (final Point point , final Color color , final int thickness)
        {
            this.point = point;
            this.color = color;
            this.thickness = thickness;
        }

    }
}
