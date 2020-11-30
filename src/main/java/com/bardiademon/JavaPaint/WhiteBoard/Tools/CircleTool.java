package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Circle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class CircleTool extends ShapeTool implements Tools
{

    @bardiademon
    private final List <Circle> circles = new ArrayList <> ();

    @bardiademon
    public CircleTool (final WhiteBoard _WhiteBoard)
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
        circles.get (index).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        circles.get (index).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final Circle circle = new Circle ();
        circle.setPoint (point);
        circle.shape (setShape (circle));
        circles.add (circle);
        setIndex (circles.size () - 1);
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        circles.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void mouseReleased (final Point point)
    {
        index = circles.size () - 1;
    }

    @bardiademon
    @Override
    public void remove (int index)
    {
        if (index >= 0 && index < circles.size ())
            circles.remove (index);
    }

    @bardiademon
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

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < circles.size ())
            return circles.get (getIndex ()).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < circles.size ())
            return circles.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
