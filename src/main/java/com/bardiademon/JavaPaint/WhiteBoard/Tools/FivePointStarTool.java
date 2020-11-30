package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Stars.FivePointStar;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class FivePointStarTool extends ShapeTool implements Tools
{

    @bardiademon
    private final List <FivePointStar> fivePointStars = new ArrayList <> ();

    @bardiademon
    private final WhiteBoard whiteBoard;

    @bardiademon
    public FivePointStarTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
        this.whiteBoard = _WhiteBoard;
    }

    @bardiademon
    @Override
    public void select ()
    {
        setCursor ();
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        fivePointStars.get (index).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        fivePointStars.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        FivePointStar fivePointStar = new FivePointStar ();
        fivePointStar.setPoint (point);
        fivePointStar.shape (setShape (fivePointStar));
        fivePointStars.add (fivePointStar);
        index = fivePointStars.size () - 1;
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        fivePointStars.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void mouseReleased (final Point point)
    {
        index = fivePointStars.size () - 1;
    }

    @bardiademon
    @Override
    public void remove (int index)
    {
        if (index >= 0 && index < fivePointStars.size ())
            fivePointStars.remove (index);
    }

    @bardiademon
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

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < fivePointStars.size ())
            return fivePointStars.get (getIndex ()).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < fivePointStars.size ())
            return fivePointStars.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
