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
    private final WhiteBoard whiteBoard;

    public FivePointStarTool (final WhiteBoard _WhiteBoard)
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
        fivePointStars.get (index).setSizeWithPoint (point);
    }

    @Override
    public void mousePressed (final Point point)
    {
        FivePointStar fivePointStar = new FivePointStar ();
        fivePointStar.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        fivePointStar.setPoint (point);
        fivePointStar.setColor (whiteBoard.getPaintView ().getColor ());
        fivePointStars.add (fivePointStar);
        index = fivePointStars.size () - 1;
    }

    @Override
    public void mouseReleased (final Point point)
    {
        index = fivePointStars.size () - 1;
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < fivePointStars.size ())
        {
            FivePointStar fivePointStar = fivePointStars.get (index);
            whiteBoard.setWHXY (fivePointStar.getSize () , fivePointStar.getPoint ());
            fivePointStar.paint (g);
        }
    }
}
