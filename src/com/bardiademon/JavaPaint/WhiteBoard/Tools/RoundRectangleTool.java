package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Graphics2D;
import java.awt.Point;

public final class RoundRectangleTool extends RectTool implements Tools
{
    public RoundRectangleTool (WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mousePressed (Point point)
    {
        super.mousePressed (point);
        rectangles.get (index).setArc (new Size (20 , 20));
    }

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
}
