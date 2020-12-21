package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Lightning;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class LightningTool extends ShapeTool <Lightning> implements Tools <Lightning>
{

    @bardiademon
    private final List <Lightning> lightnings = new ArrayList <> ();

    @bardiademon
    public LightningTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        lightnings.get (lightnings.size () - 1).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        lightnings.get (lightnings.size () - 1).setSize (size);
    }

    @Override
    public Size getSize (int index)
    {
        if (checkIndex (index , lightnings.size ()))
            return lightnings.get (index).getSize ();
        else return null;
    }

    @Override
    public boolean isFill (final int index)
    {
        if (checkIndex (index , lightnings.size ()))
            return lightnings.get (index).isFill ();
        else return super.isFill (index);
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , lightnings.size ()))
            return lightnings.get (index).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , lightnings.size ()))
            return lightnings.get (index).getColor ();
        else return super.getColor (index);
    }

    @Override
    public Color getBackgroundColor (final int index)
    {
        if (checkIndex (index , lightnings.size ()))
            return lightnings.get (index).getBackgroundColor ();
        else return super.getBackgroundColor (index);
    }

    @Override
    public void setFill (final int index , final boolean fill)
    {
        if (checkIndex (index , lightnings.size ()))
            lightnings.get (index).setFill (fill);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , lightnings.size ()))
            lightnings.get (index).setThickness (thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , lightnings.size ()))
            lightnings.get (index).setColor (color);
    }

    @Override
    public void setBackgroundColor (final int index , final Color color)
    {
        if (checkIndex (index , lightnings.size ()))
            lightnings.get (index).setBackgroundColor (color);
    }

    @Override
    public void setPoint (final Point point , final int index)
    {
        if (index >= 0 && index < lightnings.size ())
            lightnings.get (index).setPoint (point);
    }

    @Override
    public void setSize (final Size size , final int index)
    {
        if (index >= 0 && index < lightnings.size ())
            lightnings.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final Lightning lightning = new Lightning ();
        lightning.shape (setShape (lightning));
        lightning.setPoint (point);
        lightnings.add (lightning);
        setIndex (lightnings.size () - 1);
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < lightnings.size ())
        {
            final Lightning lightning = lightnings.get (index);
            whiteBoard.setWHXY (lightning.getSize () , lightning.getPoint ());
            lightning.paint (g);
        }
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < lightnings.size ())
            lightnings.get (getIndex ()).setPoint (point);
    }

    @bardiademon
    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < lightnings.size ())
            lightnings.remove (index);
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < lightnings.size ())
            return lightnings.get (index).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < lightnings.size ())
            return lightnings.get (index).getAllPoint ();
        else return null;
    }
}
