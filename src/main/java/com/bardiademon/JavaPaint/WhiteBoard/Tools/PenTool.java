package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import java.util.ArrayList;
import java.util.List;

@bardiademon
public class PenTool <T> extends ShapeTool <T> implements Tools <T>
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
        whiteBoard.setCursor ("ic_pen" , Shape.point (5 , 30));
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
                    g.setStroke (new BasicStroke (20));
                }
                else
                {
                    g.setColor (rec.getColor ());
                    if (rec.getBackgroundColor () != null)
                        g.setBackground (rec.getBackgroundColor ());

                    g.setStroke (new BasicStroke (rec.getThickness ()));
                }


                g.drawLine (rec.getPoint ().x , rec.getPoint ().y , rec.getPoint ().x , rec.getPoint ().y);

                if (pre != null)
                    g.drawLine (pre.x , pre.y , rec.getPoint ().x , rec.getPoint ().y);

                pre = rec.getPoint ();
            }
        }
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , rec.size ()))
            return rec.get (index).get (0).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , rec.size ()))
            return rec.get (index).get (0).getColor ();
        else return super.getColor (index);
    }


    @Override
    public void setFill (final int index , final boolean fill)
    {
        if (checkIndex (index , rec.size ()))
            for (Rectangle rectangle : rec.get (index))
                rectangle.setFill (fill);
        else super.setFill (index , fill);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , rec.size ()))
            for (Rectangle rectangle : rec.get (index))
                rectangle.setThickness (thickness);
        else super.setThickness (index , thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , rec.size ()))
            for (Rectangle rectangle : rec.get (index))
                rectangle.setColor (color);
        else super.setColor (index , color);
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
