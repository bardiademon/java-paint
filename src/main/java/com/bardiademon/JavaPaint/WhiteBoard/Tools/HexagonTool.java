package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Hexagon;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class HexagonTool extends ShapeTool implements Tools
{
    private final List <Hexagon> hexagons = new ArrayList <> ();

    public HexagonTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDragged (final Point point)
    {
        hexagons.get (getIndex ()).setSizeWithPoint (point);
    }

    @Override
    public void mouseDragged (final Size size)
    {
        hexagons.get (getIndex ()).setSize (size);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final Hexagon hexagon = new Hexagon ();
        hexagon.shape (setShape (hexagon));
        hexagon.setPoint (point);
        hexagons.add (hexagon);
        setIndex (hexagons.size () - 1);
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < hexagons.size ())
        {
            final Hexagon hexagon = hexagons.get (index);
            whiteBoard.setWHXY (hexagon.getSize () , hexagon.getPoint ());
            hexagon.paint (g);
        }
    }

    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < hexagons.size ())
            hexagons.get (index).setPoint (point);
    }

    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < hexagons.size ())
            hexagons.remove (index);
    }

    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < hexagons.size ())
            return hexagons.get (index).getPoint ();
        else return null;
    }

    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < hexagons.size ())
            return hexagons.get (index).getAllPoint ();
        else return null;
    }
}
