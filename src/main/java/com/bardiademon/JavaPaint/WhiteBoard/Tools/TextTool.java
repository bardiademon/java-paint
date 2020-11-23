package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.Shapes.Text;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class TextTool extends ShapeTool implements Tools
{
    private final List <Text> texts = new ArrayList <> ();

    private boolean ultimate;

    public TextTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @Override
    public void mouseDragged (final Point point)
    {
        texts.get (getIndex ()).setSizeWithPoint (point);
    }

    @Override
    public void mouseDragged (final Size size)
    {
        texts.get (getIndex ()).setSize (size);
    }

    public void setUltimate ()
    {
        this.ultimate = true;
    }

    @Override
    public void mousePressed (final Point point)
    {
        if (!ultimate)
        {
            if (index >= 0 && index < texts.size ())
            {
                texts.get (getIndex ()).close ();
                remove (getIndex ());
                whiteBoard.repaint ();
            }
        }

        final Text text = new Text (this);
        text.setArc (Shape.size (10 , 10));
        text.setPoint (point);
        text.shape (setShape (text));
        texts.add (text);
        setIndex (texts.size () - 1);
    }

    public void repaint ()
    {
        whiteBoard.repaint ();
    }

    @Override
    public void mouseReleased (final Point point)
    {
        texts.get (getIndex ()).afterPaint ();
    }

    @Override
    public void paint (final Graphics2D g , final int index)
    {
        if (index >= 0 && index < texts.size ())
        {
            final Text text = texts.get (index);
            whiteBoard.setWHXY (text.getSize () , text.getPoint ());
            text.paint (g);
        }
    }

    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < texts.size ())
            texts.get (getIndex ()).setPoint (point);
    }

    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < texts.size ())
            texts.remove (index);
    }

    public WhiteBoard getWhiteBoard ()
    {
        return super.whiteBoard;
    }
}
