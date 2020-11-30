package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Lightning;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class LightningTool extends ShapeTool implements Tools
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
        lightnings.get (getIndex ()).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        lightnings.get (getIndex ()).setSize (size);
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
        else return null;
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
