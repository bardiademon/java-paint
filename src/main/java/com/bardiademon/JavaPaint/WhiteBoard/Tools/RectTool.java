package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public class RectTool <T> extends ShapeTool <T> implements Tools <T>
{
    @bardiademon
    protected final List <Rectangle> rectangles = new ArrayList <> ();

    @bardiademon
    public RectTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void select ()
    {
        setCursor ();
    }

    @Override
    public Size getSize (final int index)
    {
        if (checkIndex (index , rectangles.size ()))
            return rectangles.get (index).getSize ();
        else return null;
    }

    @Override
    public boolean isFill (final int index)
    {
        if (checkIndex (index , rectangles.size ()))
            return rectangles.get (index).isFill ();
        else return super.isFill (index);
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , rectangles.size ()))
            return rectangles.get (index).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , rectangles.size ()))
            return rectangles.get (index).getColor ();
        else return super.getColor (index);
    }

    @Override
    public Color getBackgroundColor (final int index)
    {
        if (checkIndex (index , rectangles.size ()))
            return rectangles.get (index).getBackgroundColor ();
        else return super.getBackgroundColor (index);
    }

    @Override
    public void setFill (final int index , final boolean fill)
    {
        if (checkIndex (index , rectangles.size ()))
            rectangles.get (index).setFill (fill);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , rectangles.size ()))
            rectangles.get (index).setThickness (thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , rectangles.size ()))
            rectangles.get (index).setColor (color);
    }

    @Override
    public void setBackgroundColor (final int index , final Color color)
    {
        if (checkIndex (index , rectangles.size ()))
            rectangles.get (index).setBackgroundColor (color);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        rectangles.get (rectangles.size () - 1).setSizeWithPoint (point);
        rectangles.get (rectangles.size () - 1).apply ();
    }

    @Override
    public void setPoint (final Point point , final int index)
    {
        if (index >= 0 && index < rectangles.size ())
            rectangles.get (index).setPoint (point);
    }

    @Override
    public void setSize (final Size size , final int index)
    {
        if (index >= 0 && index < rectangles.size ())
            rectangles.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        rectangles.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final Rectangle rectangle = new Rectangle ();
        rectangle.setPoint (point);
        rectangle.shape (setShape (rectangle));
        rectangles.add (rectangle);
        index = rectangles.size () - 1;
    }

    @bardiademon
    @Override
    public void mouseReleased (final Point point)
    {
        index = rectangles.size () - 1;
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        rectangles.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void remove (int index)
    {
        if (index >= 0 && index < rectangles.size ())
            rectangles.remove (index);
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < rectangles.size ())
        {
            Rectangle rectangle = rectangles.get (index);
            whiteBoard.setWHXY (rectangle.getSize () , rectangle.getPoint ());
            rectangle.paint (g);
        }
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < rectangles.size ())
            return rectangles.get (index).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < rectangles.size ())
            return rectangles.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
