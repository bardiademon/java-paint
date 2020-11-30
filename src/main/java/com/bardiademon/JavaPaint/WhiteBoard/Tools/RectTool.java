package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public class RectTool extends ShapeTool implements Tools
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

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        rectangles.get (rectangles.size () - 1).setSizeWithPoint (point);
        rectangles.get (rectangles.size () - 1).apply ();
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
            return rectangles.get (getIndex ()).getPoint ();
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
