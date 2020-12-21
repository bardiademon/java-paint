package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.Shapes.Text;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class TextTool extends ShapeTool <Text> implements Tools <Text>
{
    @bardiademon
    private final List <Text> texts = new ArrayList <> ();

    @bardiademon
    private boolean ultimate;

    @bardiademon
    public TextTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Point point)
    {
        texts.get (getIndex ()).setSizeWithPoint (point);
    }

    @bardiademon
    @Override
    public void mouseDragged (final Size size)
    {
        texts.get (getIndex ()).setSize (size);
    }

    @bardiademon
    public void setUltimate ()
    {
        this.ultimate = true;
    }

    @bardiademon
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
        text.setBackgroundColor (null);
        text.setColor (Color.BLACK);
        texts.add (text);
        setIndex (texts.size () - 1);
    }

    @bardiademon
    public void repaint ()
    {
        whiteBoard.repaint ();
    }

    @bardiademon
    @Override
    public void mouseReleased (final Point point)
    {
        texts.get (getIndex ()).afterPaint ();
    }

    @Override
    public Size getSize (final int index)
    {
        if (checkIndex (index , texts.size ()))
            return texts.get (index).getSize ();
        else return null;
    }

    @Override
    public boolean isFill (final int index)
    {
        if (checkIndex (index , texts.size ()))
            return texts.get (index).isFill ();
        else return super.isFill (index);
    }

    @Override
    public int getThickness (final int index)
    {
        if (checkIndex (index , texts.size ()))
            return texts.get (index).getThickness ();
        else return super.getThickness (index);
    }

    @Override
    public Color getColor (final int index)
    {
        if (checkIndex (index , texts.size ()))
            return texts.get (index).getColor ();
        else return super.getColor (index);
    }

    @Override
    public Color getBackgroundColor (final int index)
    {
        if (checkIndex (index , texts.size ()))
            return texts.get (index).getBackgroundColor ();
        else return super.getBackgroundColor (index);
    }

    @Override
    public void setFill (final int index , final boolean fill)
    {
        if (checkIndex (index , texts.size ()))
            texts.get (index).setFill (fill);
    }

    @Override
    public void setThickness (final int index , final int thickness)
    {
        if (checkIndex (index , texts.size ()))
            texts.get (index).setThickness (thickness);
    }

    @Override
    public void setColor (final int index , final Color color)
    {
        if (checkIndex (index , texts.size ()))
            texts.get (index).setColor (color);
    }

    @Override
    public void setBackgroundColor (final int index , final Color color)
    {
        if (checkIndex (index , texts.size ()))
            texts.get (index).setBackgroundColor (color);
    }

    @Override
    public void setPoint (final Point point , final int index)
    {
        if (index >= 0 && index < texts.size ())
            texts.get (index).setPoint (point);
    }

    @Override
    public void setSize (final Size size , final int index)
    {
        if (index >= 0 && index < texts.size ())
            texts.get (index).setSize (size);
    }

    @bardiademon
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

    @bardiademon
    @Override
    public void setPoint (final Point point)
    {
        if (index >= 0 && index < texts.size ())
            texts.get (getIndex ()).setPoint (point);
    }

    @bardiademon
    @Override
    public void remove (final int index)
    {
        if (index >= 0 && index < texts.size ())
            texts.remove (index);
    }

    @bardiademon
    public WhiteBoard getWhiteBoard ()
    {
        return super.whiteBoard;
    }

    @Override
    public Text getShape (final int index)
    {
        if (checkIndex (index , texts.size ()))
            return texts.get (index);
        else return super.getShape (index);
    }
}
