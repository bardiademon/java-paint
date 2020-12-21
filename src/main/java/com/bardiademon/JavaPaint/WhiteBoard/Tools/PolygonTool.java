package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Polygon;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;

import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class PolygonTool extends ShapeTool <Polygon> implements Tools <Polygon>
{

    @bardiademon
    private final List <Polygon> polygons = new ArrayList <> ();

    @bardiademon
    private boolean newPolygon = true;

    @bardiademon
    public PolygonTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void setPoint (final Point point , final int index)
    {
        if (index >= 0 && index < polygons.size ())
            polygons.get (index).setPoint (point);
    }

    @Override
    public Size getSize (final int index)
    {
        if (checkIndex (index , polygons.size ()))
            return polygons.get (index).getSize ();
        else return null;
    }

    @Override
    public boolean isFill (final int index)
    {
        if (checkIndex (index , polygons.size ()))
            return polygons.get (index).isFill ();
        else return super.isFill (index);
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , polygons.size ()))
            return polygons.get (index).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , polygons.size ()))
            return polygons.get (index).getColor ();
        else return super.getColor (index);
    }

    @Override
    public Color getBackgroundColor (final int index)
    {
        if (checkIndex (index , polygons.size ()))
            return polygons.get (index).getBackgroundColor ();
        else return super.getBackgroundColor (index);
    }

    @Override
    public void setFill (final int index , final boolean fill)
    {
        if (checkIndex (index , polygons.size ()))
            polygons.get (index).setFill (fill);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , polygons.size ()))
            polygons.get (index).setThickness (thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , polygons.size ()))
            polygons.get (index).setColor (color);
    }

    @Override
    public void setBackgroundColor (final int index , final Color color)
    {
        if (checkIndex (index , polygons.size ()))
            polygons.get (index).setBackgroundColor (color);
    }

    @Override
    public void setSize (final Size size , final int index)
    {
        if (index >= 0 && index < polygons.size ())
            polygons.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mouseDbClick (final Point point)
    {
        polygons.get (polygons.size () - 1).setFinish (true);
        newPolygon = true;
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        if (newPolygon)
        {
            newPolygon = false;
            polygons.add (new Polygon ());
            setIndex (polygons.size () - 1);
        }

        polygons.get (polygons.size () - 1).setPolygon (point , WhiteBoard.GetColor () , whiteBoard.getPaintView ().thickness.getValue ());
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < polygons.size ())
        {
            polygons.get (index).paint (g);
            whiteBoard.setWHXY (Shape.size (0 , 0) , Shape.point (0 , 0));
        }
    }

    @bardiademon
    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < polygons.size ())
        {
            mouseDbClick (null);
            polygons.remove (index);
        }
    }
}
