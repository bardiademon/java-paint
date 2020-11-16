package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class RectTool extends ShapeTool implements Tools
{
    private final List <Rectangle> rectangles = new ArrayList <> ();

    public RectTool (final WhiteBoard _WhiteBoard)
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
        rectangles.get (rectangles.size () - 1).setSizeWithPoint (point);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final Rectangle rectangle = new Rectangle ();
        rectangle.setColor (whiteBoard.getPaintView ().getColor ());
        rectangle.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        rectangle.setPoint (point);
        rectangle.setFill (whiteBoard.getPaintView ().isFill.isSelected ());
        rectangle.setBackgroundColor (Color.BLACK);
        rectangles.add (rectangle);
    }

    @Override
    public void mouseReleased (final Point point)
    {
        super.mouseReleased (point);
    }

    @Override
    public void paint (final Graphics2D g)
    {
        for (Rectangle rectangle : rectangles) rectangle.paint (g);
    }
}
