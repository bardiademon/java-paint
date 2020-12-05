package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Line;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class LineTool extends ShapeTool implements Tools
{

    @bardiademon
    private final List <Line> lines = new ArrayList <> ();

    @bardiademon
    public LineTool (WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        lines.get (index).setPoint2 (point);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final Line line = new Line ();
        line.setPoint1 (point);
        line.setColor (WhiteBoard.GetColor ());
        line.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        lines.add (line);
        index = lines.size () - 1;
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        lines.get (index).setPoint2 (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        lines.get (index).setPoint1 (Shape.point (size.width , size.height));
    }

    @bardiademon
    @Override
    public void remove (int index)
    {
        if (index >= 0 && index < lines.size ())
            lines.remove (index);
    }

    @bardiademon
    @Override
    public void mouseReleased (final Point point)
    {
        index = lines.size () - 1;
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < lines.size ())
        {
            Line line = lines.get (index);
            whiteBoard.setWHXY (Shape.size (line.getPoint1 ().x , line.getPoint1 ().y) , line.getPoint2 ());
            line.paint (g);
        }
    }
}
