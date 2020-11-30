package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Stars.SixPointStar;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class SixPointStarTool extends ShapeTool implements Tools
{
    @bardiademon
    private final List <SixPointStar> sixPointStars = new ArrayList <> ();

    @bardiademon
    public SixPointStarTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        sixPointStars.get (index).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        sixPointStars.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        SixPointStar sixPointStar = new SixPointStar ();
        sixPointStar.setPoint (point);
        sixPointStar.shape (setShape (sixPointStar));
        sixPointStars.add (sixPointStar);
        setIndex (sixPointStars.size () - 1);
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < sixPointStars.size ())
        {
            SixPointStar sixPointStar = sixPointStars.get (index);
            whiteBoard.setWHXY (sixPointStar.getSize () , sixPointStar.getPoint ());
            sixPointStar.paint (g);
        }
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < sixPointStars.size ())
            sixPointStars.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < sixPointStars.size ())
            sixPointStars.remove (index);
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < sixPointStars.size ())
            return sixPointStars.get (getIndex ()).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < sixPointStars.size ())
            return sixPointStars.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
