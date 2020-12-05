package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Polygon;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class PolygonTool extends ShapeTool implements Tools
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
