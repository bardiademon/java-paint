package com.bardiademon.JavaPaint.WhiteBoard;

import com.bardiademon.JavaPaint.PaintView;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.FourPointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.Pen;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public final class WhiteBoard extends JPanel
{

    private SelectedTool selectedTool = SelectedTool.four_point_star;

    private final PaintView paintView;

    private final Pen pen;
    private final FourPointStarTool fourPointStarTool;

    public WhiteBoard (final PaintView _PaintView)
    {
        this.paintView = _PaintView;

        pen = new Pen (this);
        fourPointStarTool = new FourPointStarTool ();

        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                switch (selectedTool)
                {
                    case pen:
                        pen.mousePressed (e.getPoint ());
                        break;
                    case four_point_star:
                        fourPointStarTool.mousePressed (e.getPoint ());
                        break;
                }
                repaint ();
            }

            @Override
            public void mouseReleased (MouseEvent e)
            {
                switch (selectedTool)
                {
                    case pen:
                        pen.mouseReleased (e.getPoint ());
                        break;
                    case four_point_star:
                        fourPointStarTool.mouseReleased (e.getPoint ());
                        break;
                }
                repaint ();
            }
        });

        addMouseMotionListener (new MouseMotionListener ()
        {
            @Override
            public void mouseDragged (MouseEvent e)
            {
                switch (selectedTool)
                {
                    case pen:
                        pen.mouseDragged (e.getPoint ());
                        break;
                    case four_point_star:
                        fourPointStarTool.mouseDragged (e.getPoint ());
                        break;
                }
                repaint ();
            }

            @Override
            public void mouseMoved (MouseEvent e)
            {

            }
        });
    }

    @Override
    public void paint (Graphics g)
    {
        super.paint (g);
        Graphics2D g2 = (Graphics2D) g;

        pen.paint (g2);
        fourPointStarTool.paint (g2);
    }

}
