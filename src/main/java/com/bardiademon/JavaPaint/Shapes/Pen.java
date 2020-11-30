package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.bardiademon;

import java.awt.Color;

@bardiademon
public class Pen
{
    @bardiademon
    private Color color;

    @bardiademon
    private int thickness;

    @bardiademon
    public Color getColor ()
    {
        return color;
    }

    @bardiademon
    public void setColor (Color color)
    {
        this.color = color;
    }

    @bardiademon
    public int getThickness ()
    {
        return thickness;
    }

    @bardiademon
    public void setThickness (int thickness)
    {
        this.thickness = thickness;
    }
}
