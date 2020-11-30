package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Arrow.UpDownArrow;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class UpDownArrowTool extends ShapeTool implements Tools
{

    @bardiademon
    private final List <UpDownArrow> upDownArrows = new ArrayList <> ();

    @bardiademon
    public UpDownArrowTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        upDownArrows.get (getIndex ()).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        upDownArrows.get (getIndex ()).setSize (size);
    }

    @bardiademon
    @Override
    public void mousePressed (final Point point)
    {
        final UpDownArrow upDownArrow = new UpDownArrow ();
        upDownArrow.setPoint (point);
        upDownArrow.shape (setShape (upDownArrow));
        upDownArrows.add (upDownArrow);
        setIndex (upDownArrows.size () - 1);
    }

    @bardiademon
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

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < upDownArrows.size ())
            upDownArrows.get (index).setPoint (point);
    }

    @bardiademon
    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < upDownArrows.size ())
            upDownArrows.remove (index);
    }

    @bardiademon
    @Override
    public Point getPoint (final int index)
    {
        if (index >= 0 && index < upDownArrows.size ())
            return upDownArrows.get (getIndex ()).getPoint ();
        else return super.getPoint (index);
    }

    @bardiademon
    @Override
    public Point getAllPoint (final int index)
    {
        if (index >= 0 && index < upDownArrows.size ())
            return upDownArrows.get (index).getAllPoint ();
        else return super.getAllPoint (index);
    }
}
