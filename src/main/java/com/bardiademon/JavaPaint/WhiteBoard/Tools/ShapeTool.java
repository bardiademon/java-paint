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
public class ShapeTool <T> implements Tools <T>
{
    @bardiademon
    protected int index;

    private boolean paint;

    @bardiademon
    protected final WhiteBoard whiteBoard;

    @bardiademon
    protected ShapeTool (final WhiteBoard _WhiteBoard)
    {
        whiteBoard = _WhiteBoard;
        setPaint (true);
    }

    @bardiademon
    public Shape setShape (final Shape shape)
    {
        shape.setColor (WhiteBoard.GetColor ());
        shape.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        shape.setFill (whiteBoard.getPaintView ().isFill.isSelected ());
        shape.setBackgroundColor (WhiteBoard.GetBackgroundColor ());
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
    public void mouseDragged (final Point point)
    {

    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {

    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {

    }

    @Override
    public void mousePressed (final Point point , final int button)
    {

    }

    @bardiademon
    @Override
    public void mouseReleased (final Point point)
    {

    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g , final int index)
    {

    }

    @Override
    public void paint (final Graphics2D g , final int index , final Point point , final Size size)
    {
        System.out.println ("Not supported!");
    }

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {

    }

    @Override
    public void setPoint (final Point point , final int index)
    {

    }

    @Override
    public void setSize (final Size size , final int index)
    {

    }

    @Override
    public boolean isFill (final int index)
    {
        return false;
    }

    @Override
    public int getThickness (final int index)
    {
        return 0;
    }

    @Override
    public Color getColor (final int index)
    {
        return null;
    }

    @Override
    public Color getBackgroundColor (final int index)
    {
        return null;
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

    @bardiademon
    @Override
    public boolean isPaint ()
    {
        return paint;
    }

    @bardiademon
    @Override
    public void setPaint (boolean paint)
    {
        this.paint = paint;
    }

    protected boolean checkIndex (final int index , final int max)
    {
        return (index >= 0 && index < max);
    }

    @Override
    public String shapeName ()
    {
        return this.getClass ().getSimpleName ();
    }

    @Override
    public Size getSize (int index)
    {
        return null;
    }

    @Override
    public void setFill (int index , boolean fill)
    {

    }

    @Override
    public void setThickness (int index , int thickness)
    {

    }

    @Override
    public void setColor (int index , Color color)
    {

    }

    @Override
    public void setBackgroundColor (int index , Color color)
    {

    }

    @Override
    public String toString (final int index)
    {
        return "ShapeTool{" +
                "index=" + index +
                ", paint=" + paint +
                '}';
    }

    @Override
    public T getShape (int index)
    {
        return null;
    }
}
