package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Graphics2D;
import java.awt.Point;

public final class BucketOfPaint implements Tools
{
    private final WhiteBoard whiteBoard;

    public BucketOfPaint (final WhiteBoard _WhiteBoard)
    {
        this.whiteBoard = _WhiteBoard;
    }

    @Override
    public void select ()
    {

    }

    @Override
    public void mouseDragged (Point point)
    {

    }

    @Override
    public void mouseDragged (Size size)
    {

    }

    @Override
    public void mousePressed (Point point)
    {
        whiteBoard.setBackground (whiteBoard.getPaintView ().getColor ());
    }

    @Override
    public void mouseReleased (Point point)
    {

    }

    @Override
    public void paint (Graphics2D g , int index)
    {

    }

    @Override
    public void setPoint (Point point)
    {

    }

    @Override
    public void remove (int index)
    {

    }

    @Override
    public int getIndex ()
    {
        return 0;
    }

    @Override
    public void setIndex (int index)
    {

    }
}
