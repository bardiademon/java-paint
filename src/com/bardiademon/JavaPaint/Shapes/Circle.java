package com.bardiademon.JavaPaint.Shapes;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public final class Circle extends Shape
{
    public void paint (final Graphics2D g)
    {
        if (getSize () != null && getPoint () != null)
        {
            g.setStroke (new BasicStroke (getThickness ()));
            g.setColor (getColor ());
            g.setBackground (getBackgroundColor ());
            if (isFill ())
                g.fillOval (getPoint ().x , getPoint ().y , getSize ().width , getSize ().height);
            else
                g.drawOval (getPoint ().x , getPoint ().y , getSize ().width , getSize ().height);
        }
    }
}
