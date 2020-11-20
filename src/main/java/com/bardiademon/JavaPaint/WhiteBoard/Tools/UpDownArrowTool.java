package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Arrow.UpDownArrow;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class UpDownArrowTool extends ShapeTool implements Tools
{
    private final List <UpDownArrow> upDownArrows = new ArrayList <> ();

    public UpDownArrowTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDragged (final Point point)
    {
        upDownArrows.get (getIndex ()).setSizeWithPoint (point);
    }

    @Override
    public void mouseDragged (final Size size)
    {
        upDownArrows.get (getIndex ()).setSize (size);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final UpDownArrow upDownArrow = new UpDownArrow ();
        upDownArrow.setPoint (point);
        upDownArrow.setColor (whiteBoard.getPaintView ().getColor ());
        upDownArrow.setBackgroundColor (Color.BLACK);
        upDownArrow.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        upDownArrow.setFill (whiteBoard.getPaintView ().isFill.isSelected ());
        upDownArrows.add (upDownArrow);
        setIndex (upDownArrows.size () - 1);
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < upDownArrows.size ())
        {
            final UpDownArrow upDownArrow = upDownArrows.get (index);
            whiteBoard.setWHXY (upDownArrow.getSize () , upDownArrow.getPoint ());
            upDownArrow.paint (g);
        }
    }

    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < upDownArrows.size ())
            upDownArrows.get (index).setPoint (point);
    }

    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < upDownArrows.size ())
            upDownArrows.remove (index);
    }
}
