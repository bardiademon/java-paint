package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Stars.FivePointStar;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class FivePointStarTool extends ShapeTool implements Tools
{

    private final List <FivePointStar> fivePointStars = new ArrayList <> ();

    public FivePointStarTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDragged (final Point point)
    {
        fivePointStars.get (fivePointStars.size () - 1).setSizeWithPoint (point);
    }

    @Override
    public void mousePressed (final Point point)
    {
        FivePointStar fivePointStar = new FivePointStar ();
        fivePointStar.setPoint (point);
        fivePointStars.add (fivePointStar);
    }

    @Override
    public void mouseReleased (final Point point)
    {

    }

    @Override
    public void paint (final Graphics2D g)
    {
        for (FivePointStar fivePointStar : fivePointStars) fivePointStar.paint (g);
    }
}
