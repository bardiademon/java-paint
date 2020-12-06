package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

import java.util.ArrayList;
import java.util.List;

@bardiademon
public class PenTool extends ShapeTool implements Tools
{

    @bardiademon
    protected final List <List <Rectangle>> rec = new ArrayList <> ();

    @bardiademon
    private List <Rectangle> rectangles;

    protected boolean isEraser;

    @bardiademon
    public PenTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
        select ();
    }

    @bardiademon
    @Override
    public void select ()
    {
        whiteBoard.setCursor ("ic_pen");
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        List <Rectangle> rectangles = rec.get (rec.size () - 1);
        rectangles.add (pen (point));
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        List <Rectangle> rectangles = rec.get (rec.size () - 1);
        rectangles.add (pen (Shape.point (size.width , size.height)));
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        rectangles = new ArrayList <> ();
        rectangles.add (pen (point));
        whiteBoard.setWHXY (null , point);
        rec.add (rectangles);
        setIndex (rec.size () - 1);
    }

    @bardiademon
    @Override
    public void mouseReleased (Point point)
    {
        rec.add (rectangles);
    }

    @bardiademon
    private Rectangle pen (Point point)
    {
        final Rectangle rectangle = new Rectangle ();
        rectangle.setSize (Shape.size (1 , 1));
        rectangle.setPoint (point);
        rectangle.shape (setShape (rectangle));
        return rectangle;
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < rec.size ())
        {
            final List <Rectangle> rectangle = this.rec.get (index);

            Point pre = null;
            for (Rectangle rec : rectangle)
            {
                if (isEraser)
                {
                    g.setColor (whiteBoard.getBackgroundColor ());
                    g.setBackground (whiteBoard.getBackgroundColor ());
                }
                else
                {
                    g.setColor (rec.getColor ());
                    if (rec.getBackgroundColor () != null)
                        g.setBackground (rec.getBackgroundColor ());
                }

                g.setStroke (new BasicStroke (rec.getThickness ()));

                g.drawLine (rec.getPoint ().x , rec.getPoint ().y , rec.getPoint ().x , rec.getPoint ().y);

                if (pre != null)
                    g.drawLine (pre.x , pre.y , rec.getPoint ().x , rec.getPoint ().y);

                pre = rec.getPoint ();
            }
        }
    }

    @bardiademon
    @Override
    public void remove (int index)
    {
        if (index >= 0 && index < rec.size ())
            rec.remove (index);
    }

    @bardiademon
    @Override
    public int getIndex ()
    {
        return index;
    }
}
