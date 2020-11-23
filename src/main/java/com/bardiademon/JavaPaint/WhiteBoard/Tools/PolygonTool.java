package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Polygon;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class PolygonTool extends ShapeTool implements Tools
{

    private final List <Polygon> polygons = new ArrayList <> ();

    private boolean newPolygon = true;

    public PolygonTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDbClick (final Point point)
    {
        polygons.get (getIndex ()).setFinish (true);
        newPolygon = true;
    }

    @Override
    public void mousePressed (final Point point)
    {
        if (newPolygon)
        {
            newPolygon = false;
            polygons.add (new Polygon ());
            setIndex (polygons.size () - 1);
        }

        polygons.get (getIndex ()).setPolygon (point , whiteBoard.getPaintView ().getColor () , whiteBoard.getPaintView ().thickness.getValue ());
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < polygons.size ())
        {
            polygons.get (index).paint (g);
            whiteBoard.setWHXY (Shape.size (0 , 0) , Shape.point (0 , 0));
        }
    }

    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < polygons.size ())
            polygons.remove (index);
    }
}
