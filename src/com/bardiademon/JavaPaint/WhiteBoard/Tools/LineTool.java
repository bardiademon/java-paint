package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Line;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class LineTool extends ShapeTool implements Tools
{
    private final List <Line> lines = new ArrayList <> ();

    public LineTool (WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDragged (final Point point)
    {
        lines.get (lines.size () - 1).setPoint2 (point);
    }

    @Override
    public void mousePressed (final Point point)
    {
        final Line line = new Line ();
        line.setPoint1 (point);
        line.setColor (whiteBoard.getPaintView ().getColor ());
        line.setThickness (whiteBoard.getPaintView ().thickness.getValue ());
        lines.add (line);
    }

    @Override
    public void paint (Graphics2D g)
    {
        for (Line line : lines) line.paint (g);
    }
}
