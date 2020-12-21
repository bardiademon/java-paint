package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.RightTriangle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class RightTriangleTool extends ShapeTool <RightTriangle> implements Tools <RightTriangle>
{
    @bardiademon
    private final List <RightTriangle> rightTriangles = new ArrayList <> ();

    @bardiademon
    public RightTriangleTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        rightTriangles.get (getIndex ()).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        rightTriangles.get (getIndex ()).setSize (size);
    }

    @Override
    public Size getSize (final int index)
    {
        if (checkIndex (index , rightTriangles.size ()))
            return rightTriangles.get (index).getSize ();
        else return null;
    }

    @Override
    public boolean isFill (final int index)
    {
        if (checkIndex (index , rightTriangles.size ()))
            return rightTriangles.get (index).isFill ();
        else return super.isFill (index);
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , rightTriangles.size ()))
            return rightTriangles.get (index).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , rightTriangles.size ()))
            return rightTriangles.get (index).getColor ();
        else return super.getColor (index);
    }

    @Override
    public Color getBackgroundColor (final int index)
    {
        if (checkIndex (index , rightTriangles.size ()))
            return rightTriangles.get (index).getBackgroundColor ();
        else return super.getBackgroundColor (index);
    }

    @Override
    public void setFill (final int index , final boolean fill)
    {
        if (checkIndex (index , rightTriangles.size ()))
            rightTriangles.get (index).setFill (fill);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , rightTriangles.size ()))
            rightTriangles.get (index).setThickness (thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , rightTriangles.size ()))
            rightTriangles.get (index).setColor (color);
    }

    @Override
    public void setBackgroundColor (final int index , final Color color)
    {
        if (checkIndex (index , rightTriangles.size ()))
            rightTriangles.get (index).setBackgroundColor (color);
    }

    @Override
    public void setPoint (final Point point , final int index)
    {
        if (index >= 0 && index < rightTriangles.size ())
            rightTriangles.get (index).setPoint (point);
    }

    @Override
    public void setSize (final Size size , final int index)
    {
        if (index >= 0 && index < rightTriangles.size ())
            rightTriangles.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final RightTriangle rightTriangle = new RightTriangle ();
        rightTriangle.setPoint (point);
        rightTriangle.shape (setShape (rightTriangle));
        rightTriangles.add (rightTriangle);
        setIndex (rightTriangles.size () - 1);
    }

    @bardiademon
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

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < rightTriangles.size ())
            rightTriangles.get (getIndex ()).setPoint (point);

    }

    @bardiademon
    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < rightTriangles.size ())
            rightTriangles.remove (index);
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < rightTriangles.size ())
            return rightTriangles.get (index).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < rightTriangles.size ())
            return rightTriangles.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
