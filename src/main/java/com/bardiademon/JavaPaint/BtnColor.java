package com.bardiademon.JavaPaint;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class BtnColor extends JPanel
{
    private final Listener listener;

    public BtnColor (final Listener _Listener)
    {
        super ();
        listener = _Listener;
        setCursor (Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                setColor (JColorChooser.showDialog (null , "Select color" , null));
            }
        });
    }

    public void setColor (Color color)
    {
        if (color == null) color = Color.BLACK;
        listener.OnClick (color);
        BtnColor.this.setBackground (color);
    }

    public interface Listener
    {
        void OnClick (final Color _Color);
    }
}
