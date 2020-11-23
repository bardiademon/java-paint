package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Pentagon;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class PentagonTool extends ShapeTool implements Tools
{
    private final List <Pentagon> pentagons = new ArrayList <> ();

    public PentagonTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDragged (final Point point)
    {
        pentagons.get (getIndex ()).setSizeWithPoint (point);
    }

    @Override
    public void mouseDragged (final Size size)
    {
        pentagons.get (getIndex ()).setSize (size);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final Pentagon pentagon = new Pentagon ();
        pentagon.setPoint (point);
        pentagon.shape (setShape (pentagon));
        pentagons.add (pentagon);
        setIndex (pentagons.size () - 1);
    }

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

    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < pentagons.size ())
            pentagons.get (index).setPoint (point);
    }

    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < pentagons.size ())
            pentagons.remove (index);
    }

    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < pentagons.size ())
            return pentagons.get (index).getPoint ();
        else return null;
    }

    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < pentagons.size ())
            return pentagons.get (index).getAllPoint ();
        else return null;
    }
}
