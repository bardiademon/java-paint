package com.bardiademon.JavaPaint.Shapes.Stars;

import com.bardiademon.JavaPaint.Shapes.Line;
import com.bardiademon.JavaPaint.Shapes.Rectangle;
import java.util.List;

public class Stars extends Rectangle implements Star
{
    protected List <Line> lines;

    @Override
    public List <Line> getLines ()
    {
        return lines;
    }
}
