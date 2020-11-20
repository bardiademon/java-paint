package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.Mth;
import com.sun.glass.ui.Size;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

public class Rectangle extends Shape
{
    private Point allPoint, allPoint2, halfPoint, halfPoint2;
    private Size arc;

    public Rectangle ()
    {
        arc = new Size (0 , 0);
    }

    public Size getArc ()
    {
        return arc;
    }

    public void setArc (Size arc)
    {
        this.arc = arc;
    }

    public void apply ()
    {
        final Point point = getPoint ();
        final Size size = getSize ();

        if (point != null && size != null)
        {
            allPoint = Shape.point ((size.width + point.x) , (size.height + point.y));
            halfPoint = Shape.point (((size.width / 2) + point.x) , ((size.height / 2) + point.y));
            allPoint2 = Shape.point (allPoint.x - getPoint ().x , allPoint.y - getPoint ().y);
            halfPoint2 = Shape.point (allPoint2.x / 2 , allPoint2.y / 2);
        }
    }

    public int allX (int width , int x)
    {
        return (width + x);
    }

    public int allX2 (int width , int x)
    {
        return allX (width , x) - getAllPoint ().x;
    }

    // CTP => calculateThePercentage
    public int CTPX (int percentage)
    {
        return getPoint ().x + (Mth.percentageOfAValue (getAllPoint2 ().x , percentage));
    }

    // CTP => calculateThePercentage
    public int ctpY (int percentage)
    {
        return getPoint ().y + (Mth.percentageOfAValue (getAllPoint2 ().y , percentage));
    }

    // CTP => calculateThePercentage
    public int ctpX (int percentage)
    {
        return getPoint ().x + (Mth.percentageOfAValue (getAllPoint2 ().x , percentage));
    }

    // CTP => calculateThePercentage
    public int ctpFirstHalfX (int percentage)
    {
        return getPoint ().x + (Mth.percentageOfAValue (getHalfPoint2 ().x , percentage));
    }

    // CTP => calculateThePercentage
    public int ctpFirstHalfY (int percentage)
    {
        return getPoint ().y + (Mth.percentageOfAValue (getHalfPoint2 ().y , percentage));
    }

    // CTP => calculateThePercentage
    public int ctpSecondHalfX (int percentage)
    {
        return getPoint ().x + ((Mth.percentageOfAValue (getHalfPoint2 ().x , percentage)) + getHalfPoint2 ().x);
    }

    // CTP => calculateThePercentage
    public int ctpSecondHalfY (int percentage)
    {
        return getPoint ().y + ((Mth.percentageOfAValue (getHalfPoint2 ().y , percentage)) + getHalfPoint2 ().y);
    }

    public Point getAllPoint ()
    {
        return allPoint;
    }

    public Point getHalfPoint ()
    {
        return halfPoint;
    }

    public Point getAllPoint2 ()
    {
        return allPoint2;
    }

    public Point getHalfPoint2 ()
    {
        return halfPoint2;
    }

    @Override
    public void paint (Graphics2D g)
    {
        if (getSize () != null && getPoint () != null)
        {
            apply ();

            g.setColor (getColor ());
            g.setBackground (getBackgroundColor ());
            g.setStroke (new BasicStroke (getThickness ()));

            if (isFill ())
                g.fillRoundRect (getPoint ().x , getPoint ().y , getSize ().width , getSize ().height , getArc ().width , getArc ().height);
            else
                g.drawRoundRect (getPoint ().x , getPoint ().y , getSize ().width , getSize ().height , getArc ().width , getArc ().height);
        }
    }
}
