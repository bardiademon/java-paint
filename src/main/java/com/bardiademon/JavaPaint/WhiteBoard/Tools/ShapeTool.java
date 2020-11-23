package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;

public class ShapeTool implements Tools
{
    protected int index;

    protected final WhiteBoard whiteBoard;

    protected ShapeTool (final WhiteBoard _WhiteBoard)
    {
        whiteBoard = _WhiteBoard;
    }

    public Shape setShape (final Shape shape)
    {
        shape.setColor (whiteBoard.getPaintView ().getColor ());
        shape.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        shape.setFill (whiteBoard.getPaintView ().isFill.isSelected ());
        shape.setBackgroundColor (Color.BLACK);
        return shape;
    }

    protected void setCursor ()
    {
        whiteBoard.setCursor (Cursor.getPredefinedCursor (Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    public void select ()
    {
        setCursor ();
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

    }

    @Override
    public void mouseReleased (Point point)
    {

    }

    @Override
    public void paint (Graphics2D g , final int index)
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
    public void setIndex (final int index)
    {
        this.index = index;
    }

    public int getIndex ()
    {
        return index;
    }

    @Override
    public Point getPoint (final int index)
    {
        return null;
    }

    @Override
    public Point getAllPoint (final int index)
    {
        return null;
    }
}
