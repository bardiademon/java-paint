package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Arrow.RightLeftArrow;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class RightLeftArrowTool extends ShapeTool implements Tools
{
    private final List <RightLeftArrow> rightLeftArrows = new ArrayList <> ();

    public RightLeftArrowTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDragged (final Point point)
    {
        rightLeftArrows.get (index).setSizeWithPoint (point);
    }

    @Override
    public void mouseDragged (final Size size)
    {
        rightLeftArrows.get (index).setSize (size);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final RightLeftArrow rightLeftArrow = new RightLeftArrow ();
        rightLeftArrow.setPoint (point);
        rightLeftArrow.setColor (whiteBoard.getPaintView ().getColor ());
        rightLeftArrow.setBackgroundColor (Color.BLACK);
        rightLeftArrow.setFill (whiteBoard.getPaintView ().isFill.isSelected ());
        rightLeftArrow.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        rightLeftArrows.add (rightLeftArrow);
        setIndex (rightLeftArrows.size () - 1);
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < rightLeftArrows.size ())
        {
            final RightLeftArrow rightLeftArrow = rightLeftArrows.get (index);
            whiteBoard.setWHXY (rightLeftArrow.getSize () , rightLeftArrow.getPoint ());
            rightLeftArrow.paint (g);
        }
    }

    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < rightLeftArrows.size ())
            rightLeftArrows.get (getIndex ()).setPoint (point);
    }

    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < rightLeftArrows.size ())
            rightLeftArrows.remove (index);
    }

    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < rightLeftArrows.size ())
            return rightLeftArrows.get (getIndex ()).getPoint ();
        else return super.getPoint (index);
    }

    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < rightLeftArrows.size ())
            return rightLeftArrows.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
