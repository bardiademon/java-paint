package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public class ShapeTool implements Tools
{
    @bardiademon
    protected int index;

    @bardiademon
    protected final WhiteBoard whiteBoard;

    @bardiademon
    protected ShapeTool (final WhiteBoard _WhiteBoard)
    {
        whiteBoard = _WhiteBoard;
    }

    @bardiademon
    public Shape setShape (final Shape shape)
    {
        shape.setColor (whiteBoard.getPaintView ().getColor ());
        shape.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        shape.setFill (whiteBoard.getPaintView ().isFill.isSelected ());
        shape.setBackgroundColor (Color.BLACK);
        return shape;
    }

    @bardiademon
    protected void setCursor ()
    {
        whiteBoard.setCursor (Cursor.getPredefinedCursor (Cursor.CROSSHAIR_CURSOR));
    }

    @bardiademon
    @Override
    public void select ()
    {
        setCursor ();
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

    }

    @bardiademon
    @Override
    public void mouseReleased (Point point)
    {

    }

    @bardiademon
    @Override
    public void paint (Graphics2D g , final int index)
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
    public void setIndex (final int index)
    {
        this.index = index;
    }

    @bardiademon
    @Override
    public void mouseDbClick (Point point)
    {

    }

    @bardiademon
    public int getIndex ()
    {
        return index;
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
}
