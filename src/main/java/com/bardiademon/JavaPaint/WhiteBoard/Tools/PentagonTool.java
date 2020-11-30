package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Pentagon;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class PentagonTool extends ShapeTool implements Tools
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

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < pentagons.size ())
            return pentagons.get (index).getAllPoint ();
        else return null;
    }
}
