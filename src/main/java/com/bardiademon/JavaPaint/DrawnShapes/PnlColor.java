package com.bardiademon.JavaPaint.DrawnShapes;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.Shapes.Text;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PnlColor extends JPanel
{
    private final Text text;

    public PnlColor (final String name)
    {
        text = new Text (null);
        text.setText (name);
        text.setSize (Shape.size (getWidth () , getHeight ()));
        text.setUltimate (true);
        text.setPoint (Shape.point (0 , 0));
        text.setFont (new Font (Font.SANS_SERIF , Font.PLAIN , 2));
        text.apply ();
        text.setPoint (Shape.point (text.ctpX (5) , text.ctpY (50)));
    }

    @Override
    public void paint (Graphics g)
    {
        super.paint (g);
        text.paint ((Graphics2D) g);
    }
}
