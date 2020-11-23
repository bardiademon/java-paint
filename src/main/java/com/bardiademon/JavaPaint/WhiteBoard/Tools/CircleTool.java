package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Circle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class CircleTool extends ShapeTool implements Tools
{

    private final List <Circle> circles = new ArrayList <> ();

    public CircleTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void select ()
    {
        setCursor ();
    }

    @Override
    public void mouseDragged (final Point point)
    {
        circles.get (index).setSizeWithPoint (point);
    }

    @Override
    public void mouseDragged (final Size size)
    {
        circles.get (index).setSize (size);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final Circle circle = new Circle ();
        circle.setPoint (point);
        circle.shape (setShape (circle));
        circles.add (circle);
        setIndex (circles.size () - 1);
    }

    @Override
    public void setPoint (final Point point)
    {
        circles.get (index).setPoint (point);
    }

    @Override
    public void mouseReleased (final Point point)
    {
        index = circles.size () - 1;
    }

    @Override
    public void remove (int index)
    {
        if (index >= 0 && index < circles.size ())
            circles.remove (index);
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < circles.size ())
        {
            Circle circle = circles.get (index);
            whiteBoard.setWHXY (circle.getSize () , circle.getPoint ());
            circle.paint (g);
        }
    }

    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < circles.size ())
            return circles.get (getIndex ()).getPoint ();
        else return super.getPoint (index);
    }

    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < circles.size ())
            return circles.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
