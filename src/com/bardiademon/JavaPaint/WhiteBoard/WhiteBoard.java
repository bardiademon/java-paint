package com.bardiademon.JavaPaint.WhiteBoard;

import com.bardiademon.JavaPaint.Main;
import com.bardiademon.JavaPaint.PaintView;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.CircleTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.DiamondTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.FivePointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.FourPointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.LineTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.Pen;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.RectTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.RoundRectangleTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.Tools;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.TriangleTool;
import com.sun.glass.ui.Size;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public final class WhiteBoard extends JPanel
{

    public static SelectedTool selectedTool = SelectedTool.pen;

    private final PaintView paintView;

    private final Map <String, Tools> tools = new LinkedHashMap <> ();

    private final List <ArrangePainting> arrangePaintings = new ArrayList <> ();

    private final Toolkit defaultToolkit = Toolkit.getDefaultToolkit ();

    private ArrangePainting selectedArrangePainting;

    public WhiteBoard (final PaintView _PaintView)
    {
        this.paintView = _PaintView;

        tools.put (SelectedTool.pen.name () , new Pen (this));
        tools.put (SelectedTool.four_point_star.name () , new FourPointStarTool (this));
        tools.put (SelectedTool.five_point_star.name () , new FivePointStarTool (this));
        tools.put (SelectedTool.circle.name () , new CircleTool (this));
        tools.put (SelectedTool.rect.name () , new RectTool (this));
        tools.put (SelectedTool.line.name () , new LineTool (this));
        tools.put (SelectedTool.round_rect.name () , new RoundRectangleTool (this));
        tools.put (SelectedTool.triangle.name () , new TriangleTool (this));
        tools.put (SelectedTool.diamond.name () , new DiamondTool (this));

        paintView.thickness.addChangeListener (e -> WhiteBoard.this.repaint ());

        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                final Tools tools = WhiteBoard.this.tools.get (selectedTool.name ());

                if (tools != null)
                {
                    tools.select ();
                    tools.mousePressed (e.getPoint ());
                    selectedArrangePainting = new ArrangePainting (selectedTool.name ());
                    selectedArrangePainting.setIndex (tools.getIndex ());
                    final ArrangePainting arrangePainting = selectedArrangePainting;
                    arrangePaintings.add (arrangePainting);
                    repaint ();
                }
            }

            @Override
            public void mouseReleased (MouseEvent e)
            {
                final Tools tools = WhiteBoard.this.tools.get (selectedTool.name ());
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
                paintView.setCursorPoint (e.getPoint ());

                final Tools tools = WhiteBoard.this.tools.get (selectedTool.name ());
                if (tools != null)
                {
                    tools.mouseDragged (e.getPoint ());
                    repaint ();
                }
            }

            @Override
            public void mouseMoved (MouseEvent e)
            {
                paintView.setCursorPoint (e.getPoint ());
            }
        });
    }

    @Override
    public void paint (Graphics g)
    {
        super.paint (g);
        final Graphics2D g2 = (Graphics2D) g;

        arrangePaintings.forEach ((ap) ->
                tools.get (ap.selectedTool).paint (g2 , ap.getIndex ()));
    }

    private static final class ArrangePainting
    {
        private final String selectedTool;
        private int index;

        public ArrangePainting (final String _SelectedTool)
        {
            this.selectedTool = _SelectedTool;
        }

        public int getIndex ()
        {
            return index;
        }

        public void setIndex (int index)
        {
            this.index = index;
        }
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

    public void setWHXY (final Size size , final Point point)
    {
        if (size != null)
        {
            paintView.txtWidth.setText (String.valueOf (size.width));
            paintView.txtHeight.setText (String.valueOf (size.height));
        }
        if (point != null)
        {
            paintView.txtX.setText (String.valueOf (point.x));
            paintView.txtY.setText (String.valueOf (point.y));
        }
    }

    public PaintView getPaintView ()
    {
        return paintView;
    }
}
