package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Circle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class CircleTool extends ShapeTool implements Tools
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
        circles.get (circles.size () - 1).setSizeWithPoint (point);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final Circle circle = new Circle ();
        circle.setPoint (point);
        circle.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        circle.setColor (whiteBoard.getPaintView ().getColor ());
        circle.setFill (whiteBoard.getPaintView ().isFill.isSelected ());
        circles.add (circle);
    }

    @Override
    public void mouseReleased (final Point point)
    {

    }

    @Override
    public void paint (final Graphics2D g)
    {
        for (Circle circle : circles) circle.paint (g);
    }
}
