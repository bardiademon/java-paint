package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public final class BucketOfPaint extends ShapeTool implements Tools
{
    @bardiademon
    public BucketOfPaint (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
        setPaint (false);
    }

    @bardiademon
    @Override
    public void mousePressed (Point point)
    {
        whiteBoard.setBackground (WhiteBoard.GetColor ());
    }
}
