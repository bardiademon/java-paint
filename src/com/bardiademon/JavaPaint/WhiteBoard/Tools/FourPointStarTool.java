package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Stars.FourPointStar;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class FourPointStarTool extends ShapeTool implements Tools
{
    private final List <FourPointStar> fourPointStars = new ArrayList <> ();

    public FourPointStarTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

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
