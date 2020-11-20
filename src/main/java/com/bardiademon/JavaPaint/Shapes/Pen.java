package com.bardiademon.JavaPaint.Shapes;

import java.awt.Color;

public class Pen
{
    private Color color;
    private int thickness;

    public Color getColor ()
    {
        return color;
    }

    public void setColor (Color color)
    {
        this.color = color;
    }

    public int getThickness ()
    {
        return thickness;
    }

    public void setThickness (int thickness)
    {
        this.thickness = thickness;
    }
}
