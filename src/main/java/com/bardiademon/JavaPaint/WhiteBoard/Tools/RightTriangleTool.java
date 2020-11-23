package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.RightTriangle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class RightTriangleTool extends ShapeTool implements Tools
{
    private final List <RightTriangle> rightTriangles = new ArrayList <> ();

    public RightTriangleTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDragged (final Point point)
    {
        rightTriangles.get (getIndex ()).setSizeWithPoint (point);
    }

    @Override
    public void mouseDragged (final Size size)
    {
        rightTriangles.get (getIndex ()).setSize (size);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final RightTriangle rightTriangle = new RightTriangle ();
        rightTriangle.setPoint (point);
        rightTriangle.shape (setShape (rightTriangle));
        rightTriangles.add (rightTriangle);
        setIndex (rightTriangles.size () - 1);
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < rightTriangles.size ())
        {
            final RightTriangle rightTriangle = rightTriangles.get (index);
            whiteBoard.setWHXY (rightTriangle.getSize () , rightTriangle.getPoint ());
            rightTriangle.paint (g);
        }

    }

    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < rightTriangles.size ())
            rightTriangles.get (getIndex ()).setPoint (point);

    }

    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < rightTriangles.size ())
            rightTriangles.remove (index);
    }

    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < rightTriangles.size ())
            return rightTriangles.get (getIndex ()).getPoint ();
        else return super.getPoint (index);
    }

    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < rightTriangles.size ())
            return rightTriangles.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
