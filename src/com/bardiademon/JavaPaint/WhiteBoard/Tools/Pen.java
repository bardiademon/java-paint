package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

import java.util.ArrayList;
import java.util.List;


public final class Pen implements Tools
{

    private final WhiteBoard whiteBoard;
    private final List <Rectangle> rec = new ArrayList <> ();

    public Pen (final WhiteBoard _WhiteBoard)
    {
        this.whiteBoard = _WhiteBoard;
        select ();
    }

    @Override
    public void select ()
    {
        whiteBoard.setCursor ("ic_pen");
    }

    @Override
    public void mouseDragged (Point point)
    {
        mousePressed (point);
    }

    @Override
    public void mousePressed (Point point)
    {
        rec.add (pen (point));
    }

    @Override
    public void mouseReleased (Point point)
    {

    }

    private Rectangle pen (Point point)
    {
        final Rectangle rectangle = new Rectangle ();
        rectangle.setSize (Shape.size (1 , 1));
        rectangle.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        rectangle.setPoint (point);
        rectangle.setColor (whiteBoard.getPaintView ().getColor ());
        return rectangle;
    }

    @Override
    public void paint (final Graphics2D g)
    {
        for (Rectangle rectangle : rec)
        {
            g.setColor (rectangle.getColor ());
            if (rectangle.getBackgroundColor () != null)
                g.setBackground (rectangle.getBackgroundColor ());

            g.setStroke (new BasicStroke (rectangle.getThickness ()));

            g.drawRect (rectangle.getPoint ().x , rectangle.getPoint ().y , rectangle.getSize ().width , rectangle.getSize ().height);
        }
    }
}
