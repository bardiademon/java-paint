package com.bardiademon.JavaPaint;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class BtnColor extends JPanel
{
    public BtnColor (final Listener _Listener)
    {
        super ();
        setCursor (Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                Color selectColor = JColorChooser.showDialog (null , "Select color" , null);
                if (selectColor == null) selectColor = Color.BLACK;
                _Listener.OnClick (selectColor);
                BtnColor.this.setBackground (selectColor);
            }
        });
    }

    public interface Listener
    {
        void OnClick (final Color _Color);
    }
}
