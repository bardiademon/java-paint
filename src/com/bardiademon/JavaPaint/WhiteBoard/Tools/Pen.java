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
    private final List <List <Rectangle>> rec = new ArrayList <> ();
    private final List <Rectangle> rectangles = new ArrayList <> ();

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
    public void mouseDragged (final Point point)
    {
        rec.get (rec.size () - 1).add (pen (point));
    }

    @Override
    public void mousePressed (final Point point)
    {
        rectangles.add (pen (point));
        rec.add (rectangles);
    }

    @Override
    public void mouseReleased (Point point)
    {
        rec.add (rectangles);
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
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < rec.size ())
        {
            final List <Rectangle> rectangle = this.rec.get (index);
            for (Rectangle rec : rectangle)
            {
                g.setColor (rec.getColor ());
                if (rec.getBackgroundColor () != null)
                    g.setBackground (rec.getBackgroundColor ());

                g.setStroke (new BasicStroke (rec.getThickness ()));

                g.drawRect (rec.getPoint ().x , rec.getPoint ().y , rec.getSize ().width , rec.getSize ().height);
            }
        }
    }

    @Override
    public int getIndex ()
    {
        return rec.size () - 1;
    }
}
