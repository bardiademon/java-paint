package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Pentagon;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class PentagonTool extends ShapeTool <Pentagon> implements Tools <Pentagon>
{
    @bardiademon
    private final List <Pentagon> pentagons = new ArrayList <> ();

    @bardiademon
    public PentagonTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        pentagons.get (pentagons.size () - 1).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        pentagons.get (pentagons.size () - 1).setSize (size);
    }

    @Override
    public void setPoint (final Point point , final int index)
    {
        if (index >= 0 && index < pentagons.size ())
            pentagons.get (index).setPoint (point);
    }

    @Override
    public void setSize (final Size size , final int index)
    {
        if (index >= 0 && index < pentagons.size ())
            pentagons.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final Pentagon pentagon = new Pentagon ();
        pentagon.setPoint (point);
        pentagon.shape (setShape (pentagon));
        pentagons.add (pentagon);
        setIndex (pentagons.size () - 1);
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < pentagons.size ())
        {
            final Pentagon pentagon = pentagons.get (index);
            whiteBoard.setWHXY (pentagon.getSize () , pentagon.getPoint ());
            pentagon.paint (g);
        }
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < pentagons.size ())
            pentagons.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < pentagons.size ())
            pentagons.remove (index);
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < pentagons.size ())
            return pentagons.get (index).getPoint ();
        else return null;
    }

    @Override
    public boolean isFill (final int index)
    {
        if (checkIndex (index , pentagons.size ()))
            return pentagons.get (index).isFill ();
        else return super.isFill (index);
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , pentagons.size ()))
            return pentagons.get (index).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , pentagons.size ()))
            return pentagons.get (index).getColor ();
        else return super.getColor (index);
    }

    @Override
    public Color getBackgroundColor (final int index)
    {
        if (checkIndex (index , pentagons.size ()))
            return pentagons.get (index).getBackgroundColor ();
        else return super.getBackgroundColor (index);
    }

    @Override
    public void setFill (final int index , final boolean fill)
    {
        if (checkIndex (index , pentagons.size ()))
            pentagons.get (index).setFill (fill);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , pentagons.size ()))
            pentagons.get (index).setThickness (thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , pentagons.size ()))
            pentagons.get (index).setColor (color);
    }

    @Override
    public void setBackgroundColor (final int index , final Color color)
    {
        if (checkIndex (index , pentagons.size ()))
            pentagons.get (index).setBackgroundColor (color);
    }

    @Override
    public Size getSize (final int index)
    {
        if (checkIndex (index , pentagons.size ()))
            return pentagons.get (index).getSize ();
        else return null;
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < pentagons.size ())
            return pentagons.get (index).getAllPoint ();
        else return null;
    }
}
