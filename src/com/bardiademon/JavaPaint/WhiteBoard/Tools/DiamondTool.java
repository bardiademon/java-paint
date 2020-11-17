package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Diamond;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class DiamondTool extends ShapeTool implements Tools
{
    private final List <Diamond> diamonds = new ArrayList <> ();

    public DiamondTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDragged (final Point point)
    {
        diamonds.get (index).setSizeWithPoint (point);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final Diamond diamond = new Diamond ();
        diamond.setColor (whiteBoard.getPaintView ().getColor ());
        diamond.setPoint (point);
        diamond.setBackgroundColor (Color.BLACK);
        diamond.setFill (whiteBoard.getPaintView ().isFill.isSelected ());
        diamond.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        diamonds.add (diamond);
        index = diamonds.size () - 1;
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < diamonds.size ())
        {
            Diamond diamond = diamonds.get (index);
            whiteBoard.setWHXY (diamond.getSize () , diamond.getPoint ());
            diamonds.get (index).paint (g);
        }
    }
}
