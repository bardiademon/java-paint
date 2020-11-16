package com.bardiademon.JavaPaint.Shapes;

import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Shape
{

    private Color color;
    private Color backgroundColor;

    private boolean fill;

    private Point point;

    private int thickness;

    private Size size;

    public static Point point (final int x , final int y)
    {
        return new Point (x , y);
    }

    public void setSizeWithPoint (final Point point)
    {
        if (getPoint () != null)
            setSize (Shape.size (point.x - getPoint ().x , point.y - getPoint ().y));
    }

    public static Size size (final int width , final int height)
    {
        return new Size (width , height);
    }

    public Color getColor ()
    {
        return color;
    }

    public void setColor (Color color)
    {
        this.color = color;
    }

    public boolean isFill ()
    {
        return fill;
    }

    public void setFill (boolean fill)
    {
        this.fill = fill;
    }

    public Point getPoint ()
    {
        return point;
    }

    public void setPoint (Point point)
    {
        this.point = point;
    }

    public int getThickness ()
    {
        return thickness;
    }

    public void setThickness (int thickness)
    {
        this.thickness = thickness;
    }

    public Size getSize ()
    {
        return size;
    }

    public void setSize (Size size)
    {
        this.size = size;
    }

    public void shape (Shape shape)
    {
        setColor (shape.getColor ());
        setFill (shape.isFill ());
        setThickness (shape.getThickness ());
        setBackgroundColor (shape.getBackgroundColor ());
        setPoint (shape.getPoint ());
        setSize (shape.getSize ());
    }

    public Color getBackgroundColor ()
    {
        return backgroundColor;
    }

    public void setBackgroundColor (Color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }

    public void paint (Graphics2D g)
    {
        g.drawString ("Java Paint" , 0 , 0);
    }

    @Override
    public String toString ()
    {
        return "Shape{" +
                "color=" + color +
                ", fill=" + fill +
                ", point=" + point +
                ", thickness=" + thickness +
                ", size=" + size +
                '}';
    }
}
