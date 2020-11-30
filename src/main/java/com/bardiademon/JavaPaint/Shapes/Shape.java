package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public class Shape extends Pen
{
    @bardiademon
    private Color backgroundColor;

    @bardiademon
    private boolean fill;

    @bardiademon
    private Point point;

    @bardiademon
    private Size size;

    @bardiademon
    public static Point point (final int x , final int y)
    {
        return new Point (x , y);
    }

    @bardiademon
    public static boolean PointComparison (Point point1 , Point point2)
    {
        return (point1.x == point2.x && point1.y == point2.y);
    }

    @bardiademon
    public void setSizeWithPoint (final Point point)
    {
        if (getPoint () != null)
            setSize (Shape.size (point.x - getPoint ().x , point.y - getPoint ().y));
    }

    @bardiademon
    public static Size sizeWithPoint (final Point point1 , Point point2)
    {
        return Shape.size (point1.x - point2.x , point1.y - point2.y);
    }

    @bardiademon
    public static Size size (final int width , final int height)
    {
        return new Size (width , height);
    }

    @bardiademon
    public boolean isFill ()
    {
        return fill;
    }

    @bardiademon
    public void setFill (boolean fill)
    {
        this.fill = fill;
    }

    @bardiademon
    public Point getPoint ()
    {
        return point;
    }

    @bardiademon
    public void setPoint (Point point)
    {
        this.point = point;
    }

    @bardiademon
    public Size getSize ()
    {
        return size;
    }

    @bardiademon
    public void setSize (Size size)
    {
        this.size = size;
    }

    @bardiademon
    public void shape (Shape shape)
    {
        setColor (shape.getColor ());
        setFill (shape.isFill ());
        setThickness (shape.getThickness ());
        setBackgroundColor (shape.getBackgroundColor ());
        setPoint (shape.getPoint ());
        setSize (shape.getSize ());
    }

    @bardiademon
    public Color getBackgroundColor ()
    {
        return backgroundColor;
    }

    @bardiademon
    public void setBackgroundColor (Color backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }

    @bardiademon
    public void paint (final Graphics2D g)
    {
        g.drawString ("Java Paint" , 0 , 0);
    }

    @bardiademon
    protected void draw (final Graphics2D g)
    {
        g.drawString ("Java Paint" , 0 , 0);
    }

    @bardiademon
    @Override
    public String toString ()
    {
        return "Shape{" +
                "color=" + getColor () +
                ", fill=" + fill +
                ", point=" + point +
                ", thickness=" + getThickness () +
                ", size=" + size +
                '}';
    }

    @bardiademon
    protected void fill (final Doing doing , final Size size , final Point point)
    {
//        if (size != null && point != null)
//        {
//            int counter = 0;
//
//            final int thickness = getThickness ();
//            final Color color = getColor ();
//            setColor (getBackgroundColor ());
//            setThickness (2);
//
//            while (true)
//            {
//                if (size.width <= 0 && size.height <= 0) break;
//
//                if (size.width > 0) --size.width;
//                if (size.height > 0) --size.height;
//
//                if (counter++ % 2 == 0)
//                {
//                    if (size.width > 0) point.x++;
//                    if (size.height > 0) point.y++;
//                }
//                doing.Draw (point (point.x , point.y) , size (size.width , size.height));
//            }
//            setThickness (thickness);
//            setColor (color);
//        }
    }

    @bardiademon
    public interface Doing
    {
        void Draw (final Point point , final Size size);
    }
}
