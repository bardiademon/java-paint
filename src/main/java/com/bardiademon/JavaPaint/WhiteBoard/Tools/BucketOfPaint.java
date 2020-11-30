package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public final class BucketOfPaint implements Tools
{
    @bardiademon
    private final WhiteBoard whiteBoard;

    @bardiademon
    public BucketOfPaint (final WhiteBoard _WhiteBoard)
    {
        this.whiteBoard = _WhiteBoard;
    }

    @bardiademon
    @Override
    public void select ()
    {

    }

    @bardiademon
    @Override
    public void mouseDragged (Point point)
    {

    }

    @bardiademon
    @Override
    public void mouseDragged (Size size)
    {

    }

    @bardiademon
    @Override
    public void mousePressed (Point point)
    {
        whiteBoard.setBackground (whiteBoard.getPaintView ().getColor ());
    }

    @bardiademon
    @Override
    public void mouseReleased (Point point)
    {

    }

    @bardiademon
    @Override
    public void paint (Graphics2D g , int index)
    {

    }

    @bardiademon
    @Override
    public void setPoint (Point point)
    {

    }

    @bardiademon
    @Override
    public void remove (int index)
    {

    }

    @bardiademon
    @Override
    public int getIndex ()
    {
        return 0;
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        return null;
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        return null;
    }

    @bardiademon
    @Override
    public void setIndex (int index)
    {

    }

    @bardiademon
    @Override
    public void mouseDbClick (Point point)
    {

    }
}
