package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;

public class ShapeTool implements Tools
{
    protected final WhiteBoard whiteBoard;

    protected ShapeTool (final WhiteBoard _WhiteBoard)
    {
        whiteBoard = _WhiteBoard;
    }

    protected void setCursor ()
    {
        whiteBoard.setCursor (Cursor.getPredefinedCursor (Cursor.CROSSHAIR_CURSOR));
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
    public void mousePressed (Point point)
    {

    }

    @Override
    public void mouseReleased (Point point)
    {

    }

    @Override
    public void paint (Graphics2D g)
    {

    }
}