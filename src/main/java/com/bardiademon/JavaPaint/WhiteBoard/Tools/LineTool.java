package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Line;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class LineTool extends ShapeTool <Line> implements Tools <Line>
{

    @bardiademon
    private final List <Line> lines = new ArrayList <> ();

    @bardiademon
    public LineTool (WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public Point getPoint (int index)
    {
        if (checkIndex (index , lines.size ()))
            return lines.get (index).getPoint1 ();
        else return null;
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , lines.size ()))
            return lines.get (index).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , lines.size ()))
            return lines.get (index).getColor ();
        else return super.getColor (index);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , lines.size ()))
            lines.get (index).setThickness (thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , lines.size ()))
            lines.get (index).setColor (color);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        lines.get (index).setPoint2 (point);
    }

    @Override
    public Size getSize (int index)
    {
        if (checkIndex (index , lines.size ()))
        {
            final Point line = lines.get (index).getPoint2 ();
            return Shape.size (line.x , line.y);
        }
        else return null;
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
