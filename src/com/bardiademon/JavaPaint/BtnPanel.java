package com.bardiademon.JavaPaint;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.Shapes.ShapeName;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class BtnPanel extends JPanel
{
    private final ShapeName shapeName;

    public BtnPanel ()
    {
        shapeName = null;
    }

    public BtnPanel (final ShapeName _ShapeName)
    {
        this.shapeName = _ShapeName;
        repaint ();
    }

    @Override
    public void paint (Graphics g)
    {
        super.paint (g);
        PaintView.BACKGROUND_PAINT.paint (((Graphics2D) g) , shapeName , Shape.point (getX () , getY ()) , Shape.size (getWidth () , getHeight ()));
    }
}
