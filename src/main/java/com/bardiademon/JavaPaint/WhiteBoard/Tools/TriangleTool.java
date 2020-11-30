package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Triangle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class TriangleTool extends ShapeTool implements Tools
{
    @bardiademon
    private final List <Triangle> triangles = new ArrayList <> ();

    @bardiademon
    public TriangleTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        triangles.get (index).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        triangles.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        triangles.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final Triangle triangle = new Triangle ();
        triangle.setPoint (point);
        triangle.shape (setShape (triangle));
        triangles.add (triangle);
        index = triangles.size () - 1;
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < triangles.size ())
        {
            final Triangle triangle = triangles.get (index);
            whiteBoard.setWHXY (triangle.getSize () , triangle.getPoint ());
            triangle.paint (g);
        }
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < triangles.size ())
            return triangles.get (getIndex ()).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < triangles.size ())
            return triangles.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
