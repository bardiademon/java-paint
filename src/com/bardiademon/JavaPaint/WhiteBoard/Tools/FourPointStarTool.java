package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Stars.FourPointStar;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class FourPointStarTool implements Tools
{
    private final List <FourPointStar> fourPointStars = new ArrayList <> ();

    @Override
    public void mouseDragged (final Point point)
    {
        fourPointStars.get (fourPointStars.size () - 1).setSizeWithPoint (point);
    }

    @Override
    public void mousePressed (final Point point)
    {
        FourPointStar fourPointStar = new FourPointStar ();
        fourPointStar.setPoint (point);
        fourPointStars.add (fourPointStar);
    }

    @Override
    public void mouseReleased (Point point)
    {
    }

    @Override
    public void paint (final Graphics2D g)
    {
        for (FourPointStar pointStar : fourPointStars) pointStar.paint (g);
    }
}
