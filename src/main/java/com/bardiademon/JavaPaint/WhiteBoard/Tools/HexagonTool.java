package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Hexagon;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class HexagonTool extends ShapeTool <Hexagon> implements Tools <Hexagon>
{
    @bardiademon
    private final List <Hexagon> hexagons = new ArrayList <> ();

    @bardiademon
    public HexagonTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        hexagons.get (getIndex ()).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        hexagons.get (getIndex ()).setSize (size);
    }

    @Override
    public Size getSize (int index)
    {
        if (checkIndex (index , hexagons.size ()))
            return hexagons.get (index).getSize ();
        else return null;
    }

    @Override
    public boolean isFill (final int index)
    {
        if (checkIndex (index , hexagons.size ()))
            return hexagons.get (index).isFill ();
        else return super.isFill (index);
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , hexagons.size ()))
            return hexagons.get (index).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , hexagons.size ()))
            return hexagons.get (index).getColor ();
        else return super.getColor (index);
    }

    @Override
    public Color getBackgroundColor (final int index)
    {
        if (checkIndex (index , hexagons.size ()))
            return hexagons.get (index).getBackgroundColor ();
        else return super.getBackgroundColor (index);
    }

    @Override
    public void setFill (final int index , final boolean fill)
    {
        if (checkIndex (index , hexagons.size ()))
            hexagons.get (index).setFill (fill);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , hexagons.size ()))
            hexagons.get (index).setThickness (thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , hexagons.size ()))
            hexagons.get (index).setColor (color);
    }

    @Override
    public void setBackgroundColor (final int index , final Color color)
    {
        if (checkIndex (index , hexagons.size ()))
            hexagons.get (index).setBackgroundColor (color);
    }

    @Override
    public void setPoint (final Point point , final int index)
    {
        if (index >= 0 && index < hexagons.size ())
            hexagons.get (index).setPoint (point);
    }

    @Override
    public void setSize (final Size size , final int index)
    {
        if (index >= 0 && index < hexagons.size ())
            hexagons.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final Hexagon hexagon = new Hexagon ();
        hexagon.shape (setShape (hexagon));
        hexagon.setPoint (point);
        hexagons.add (hexagon);
        setIndex (hexagons.size () - 1);
    }

    @bardiademon
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

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < hexagons.size ())
            hexagons.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < hexagons.size ())
            hexagons.remove (index);
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < hexagons.size ())
            return hexagons.get (index).getPoint ();
        else return null;
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < hexagons.size ())
            return hexagons.get (index).getAllPoint ();
        else return null;
    }
}
