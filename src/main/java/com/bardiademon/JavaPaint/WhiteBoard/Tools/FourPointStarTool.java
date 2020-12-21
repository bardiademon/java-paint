package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Stars.FourPointStar;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class FourPointStarTool extends ShapeTool <FourPointStar> implements Tools <FourPointStar>
{
    @bardiademon
    private final List <FourPointStar> fourPointStars = new ArrayList <> ();

    @bardiademon
    private final WhiteBoard whiteBoard;


    @bardiademon
    public FourPointStarTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
        this.whiteBoard = _WhiteBoard;
    }

    @Override
    public Size getSize (int index)
    {
        if (checkIndex (index , fourPointStars.size ()))
            return fourPointStars.get (index).getSize ();
        else return null;
    }

    @Override
    public void setPoint (final Point point , final int index)
    {
        if (index >= 0 && index < fourPointStars.size ())
            fourPointStars.get (index).setPoint (point);
    }

    @Override
    public void setSize (final Size size , int index)
    {
        if (index >= 0 && index < fourPointStars.size ())
            fourPointStars.get (index).setSize (size);
    }

    @Override
    public boolean isFill (final int index)
    {
        if (checkIndex (index , fourPointStars.size ()))
            return fourPointStars.get (index).isFill ();
        else return super.isFill (index);
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , fourPointStars.size ()))
            return fourPointStars.get (index).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , fourPointStars.size ()))
            return fourPointStars.get (index).getColor ();
        else return super.getColor (index);
    }

    @Override
    public Color getBackgroundColor (final int index)
    {
        if (checkIndex (index , fourPointStars.size ()))
            return fourPointStars.get (index).getBackgroundColor ();
        else return super.getBackgroundColor (index);
    }

    @Override
    public void setFill (final int index , final boolean fill)
    {
        if (checkIndex (index , fourPointStars.size ()))
            fourPointStars.get (index).setFill (fill);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , fourPointStars.size ()))
            fourPointStars.get (index).setThickness (thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , fourPointStars.size ()))
            fourPointStars.get (index).setColor (color);
    }

    @Override
    public void setBackgroundColor (final int index , final Color color)
    {
        if (checkIndex (index , fourPointStars.size ()))
            fourPointStars.get (index).setBackgroundColor (color);
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
        fourPointStars.get (index).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        fourPointStars.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final FourPointStar fourPointStar = new FourPointStar ();
        fourPointStar.setPoint (point);
        fourPointStar.shape (setShape (fourPointStar));
        fourPointStars.add (fourPointStar);
        index = fourPointStars.size () - 1;
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        fourPointStars.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void mouseReleased (Point point)
    {
        index = fourPointStars.size () - 1;
    }

    @bardiademon
    @Override
    public void remove (int index)
    {
        if (index >= 0 && index < fourPointStars.size ())
            fourPointStars.remove (index);
    }

    @bardiademon
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

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < fourPointStars.size ())
            return fourPointStars.get (index).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < fourPointStars.size ())
            return fourPointStars.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
