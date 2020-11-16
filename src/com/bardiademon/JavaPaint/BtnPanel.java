package com.bardiademon.JavaPaint;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class BtnPanel extends JPanel
{
    private final SelectedTool selectedTool;

    public BtnPanel ()
    {
        selectedTool = null;
    }

    public BtnPanel (final SelectedTool _SelectedTool)
    {
        this.selectedTool = _SelectedTool;
        repaint ();

        setCursor (Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));

        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                WhiteBoard.selectedTool = selectedTool;
            }
        });
    }

    @Override
    public void paint (Graphics g)
    {
        super.paint (g);
        PaintView.BACKGROUND_PAINT.paint (((Graphics2D) g) , selectedTool , Shape.point (getX () , getY ()) , Shape.size (getWidth () , getHeight ()));
    }
}
