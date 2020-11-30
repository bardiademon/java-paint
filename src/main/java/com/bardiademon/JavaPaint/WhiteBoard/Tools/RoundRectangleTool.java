package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public final class RoundRectangleTool extends RectTool implements Tools
{
    @bardiademon
    public RoundRectangleTool (WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mousePressed (Point point)
    {
        super.mousePressed (point);
        rectangles.get (getIndex ()).setArc (new Size (20 , 20));
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
            final Rectangle rectangle = rectangles.get (index);
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
