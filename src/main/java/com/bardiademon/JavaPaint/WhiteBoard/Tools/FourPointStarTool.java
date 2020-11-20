package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Stars.FourPointStar;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
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
        fourPointStars.get (index).setSizeWithPoint (point);
    }

    @Override
    public void mouseDragged (final Size size)
    {
        fourPointStars.get (index).setSize (size);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final FourPointStar fourPointStar = new FourPointStar ();
        fourPointStar.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        fourPointStar.setPoint (point);
        fourPointStar.setColor (whiteBoard.getPaintView ().getColor ());
        fourPointStars.add (fourPointStar);
        index = fourPointStars.size () - 1;
    }

    @Override
    public void setPoint (final Point point)
    {
        fourPointStars.get (index).setPoint (point);
    }

    @Override
    public void mouseReleased (Point point)
    {
        index = fourPointStars.size () - 1;
    }

    @Override
    public void remove (int index)
    {
        if (index >= 0 && index < fourPointStars.size ())
            fourPointStars.remove (index);
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < fourPointStars.size ())
        {
            FourPointStar fourPointStar = fourPointStars.get (index);
            whiteBoard.setWHXY (fourPointStar.getSize () , fourPointStar.getPoint ());
            fourPointStar.paint (g);
        }
    }
}
