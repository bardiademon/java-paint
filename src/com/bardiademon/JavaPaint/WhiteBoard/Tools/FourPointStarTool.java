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
    private final WhiteBoard whiteBoard;

    public FourPointStarTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
        this.whiteBoard = _WhiteBoard;
    }

    @Override
    public void select ()
    {
        setCursor ();
    }

    @Override
    public void mouseDragged (final Point point)
    {
        fourPointStars.get (fourPointStars.size () - 1).setSizeWithPoint (point);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final FourPointStar fourPointStar = new FourPointStar ();
        fourPointStar.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        fourPointStar.setPoint (point);
        fourPointStar.setColor (whiteBoard.getPaintView ().getColor ());
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