package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Diamond;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class DiamondTool extends ShapeTool implements Tools
{
    @bardiademon
    private final List <Diamond> diamonds = new ArrayList <> ();

    @bardiademon
    public DiamondTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        diamonds.get (index).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        diamonds.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final Diamond diamond = new Diamond ();
        diamond.setPoint (point);
        diamond.shape (setShape (diamond));
        diamonds.add (diamond);
        index = diamonds.size () - 1;
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        diamonds.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void remove (int index)
    {
        if (index >= 0 && index < diamonds.size ())
            diamonds.remove (index);
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < diamonds.size ())
        {
            Diamond diamond = diamonds.get (index);
            whiteBoard.setWHXY (diamond.getSize () , diamond.getPoint ());
            diamonds.get (index).paint (g);
        }
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < diamonds.size ())
            return diamonds.get (getIndex ()).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < diamonds.size ())
            return diamonds.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
