package com.bardiademon.JavaPaint.WhiteBoard;

import com.bardiademon.JavaPaint.Main;
import com.bardiademon.JavaPaint.PaintView;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.CircleTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.FivePointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.FourPointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.Pen;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.RectTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.Tools;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public final class WhiteBoard extends JPanel
{

    public static SelectedTool selectedTool = SelectedTool.pen;

    private final PaintView paintView;

    private final Map <String, Tools> tools = new LinkedHashMap <> ();

    private final Toolkit defaultToolkit = Toolkit.getDefaultToolkit ();

    public WhiteBoard (final PaintView _PaintView)
    {
        this.paintView = _PaintView;

        tools.put (SelectedTool.pen.name () , new Pen (this));
        tools.put (SelectedTool.four_point_star.name () , new FourPointStarTool (this));
        tools.put (SelectedTool.five_point_star.name () , new FivePointStarTool (this));
        tools.put (SelectedTool.circle.name () , new CircleTool (this));
        tools.put (SelectedTool.rect.name () , new RectTool (this));

        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                Tools tools = WhiteBoard.this.tools.get (selectedTool.name ());
                if (tools != null)
                {
                    tools.select ();
                    tools.mousePressed (e.getPoint ());
                    repaint ();
                }
            }

            @Override
            public void mouseReleased (MouseEvent e)
            {
                Tools tools = WhiteBoard.this.tools.get (selectedTool.name ());
                if (tools != null)
                {
                    tools.mouseReleased (e.getPoint ());
                    repaint ();
                }
            }
        });

        addMouseMotionListener (new MouseMotionListener ()
        {
            @Override
            public void mouseDragged (MouseEvent e)
            {
                Tools tools = WhiteBoard.this.tools.get (selectedTool.name ());
                if (tools != null)
                {
                    tools.mouseDragged (e.getPoint ());
                    repaint ();
                }
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
        tools.forEach ((s , tools) -> tools.paint (g2));
    }

    public void setCursor (final String name)
    {
        try
        {
            final File icPen = Main.getFile (name);
            if (icPen != null)
            {
                BufferedImage read = ImageIO.read (icPen);
                setCursor (defaultToolkit.createCustomCursor ((read.getScaledInstance (read.getWidth () , read.getHeight () , BufferedImage.TYPE_INT_ARGB)) , Shape.point (10 , 10) , "pen"));
            }
        }
        catch (IOException ignored)
        {
        }
    }

    public PaintView getPaintView ()
    {
        return paintView;
    }
}
