package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.Mth;
import com.bardiademon.JavaPaint.Shapes.Stars.FourPointStar;
import com.sun.glass.ui.Size;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public final class BackgroundPaint
{

    public void paint (final Graphics2D g , final ShapeName shapeName , final Point point , final Size size)
    {
        if (shapeName != null)
        {
            switch (shapeName)
            {
                case circle:
                    circle (g , getShape (size));
                    break;
                case rect:
                    rect (g , getShape (size));
                    break;
                case round_rect:
                    roundRect (g , getShape (size));
                    break;
                case polygon:
                    polygon (g , getShape (size));
                    break;
                case triangle:
                    triangle (g , size);
                    break;
                case heart:
                    heart (g , size);
                    break;
                case four_point_star:
                    fourStar (g , getShape (size));
                    break;
                default:
                    break;
            }
        }
    }

    private void circle (final Graphics2D g , final Shape shape)
    {
        Point point = shape.getPoint ();
        Size widthHeight = shape.getSize ();

        g.setStroke (new BasicStroke (shape.getThickness ()));
        g.fillOval (point.x , point.y , widthHeight.width , widthHeight.height);
    }

    private void rect (final Graphics2D g , final Shape shape)
    {
        Point point = shape.getPoint ();
        Size size = shape.getSize ();

        g.setStroke (new BasicStroke (shape.getThickness ()));
        g.fillRect (point.x , point.y , size.width , size.height);
    }

    private void roundRect (final Graphics2D g , final Shape shape)
    {
        Point point = shape.getPoint ();
        Size size = shape.getSize ();

        g.setStroke (new BasicStroke (shape.getThickness ()));
        g.fillRoundRect (point.x , point.y , size.width , size.height , 3 , 3);
    }

    private void polygon (final Graphics2D g , final Shape shape)
    {
        Point point = shape.getPoint ();
        Size size = shape.getSize ();
        g.setStroke (new BasicStroke (shape.getThickness ()));
        g.drawLine (point.x , point.y , size.width , point.y);
        g.drawLine (point.x , point.y , point.x , size.height);
        g.drawLine (point.x , size.height , size.width + 5 , size.height);
        g.drawLine (size.width + 5 , size.height - 5 , size.width + 5 , size.height);
    }

    private void triangle (final Graphics2D g , final Size size)
    {
        g.setStroke (new BasicStroke (3));

        Point point1 = Shape.point (size.width / 2 , Mth.percentageOfAValue (size.height , 20));
        Point point2 = Shape.point (Mth.percentageOfAValue (size.width , 20) , Mth.percentageOfAValue (size.height , 80));

        g.drawLine (point1.x , point1.y , point2.x , point2.y);

        Point point3 = Shape.point (Mth.percentageOfAValue (size.width , 80) , point2.y);

        g.drawLine (point1.x , point1.y , point3.x , point3.y);

        g.drawLine (point2.x , point2.y , point3.x , point3.y);
    }

    public void heart (final Graphics2D g , final Size size)
    {
    }

    private void fourStar (final Graphics2D g , final Shape shape)
    {
        final FourPointStar fourPointStar = new FourPointStar ();
        fourPointStar.shape (shape);
        fourPointStar.paint (g);
    }

    private Shape getShape (final Size size)
    {
        int width = size.width / 2;
        int height = size.height / 2;

        int x = (width / 2);
        int y = (height / 2);

        Shape shape = new Shape ();
        shape.setPoint (Shape.point (x , y));
        shape.setSize (Shape.size (width , height));
        shape.setThickness (2);
        shape.setColor (Color.BLACK);

        return shape;
    }
}
