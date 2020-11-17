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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JTextField;


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

            @Override
            public void mouseClicked (MouseEvent e)
            {
                WhiteBoard.this.setFocusable (true);
                WhiteBoard.this.setRequestFocusEnabled (true);
                System.out.println (WhiteBoard.this.requestFocusInWindow ());
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

        super.addKeyListener (new KeyListener ()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
            }

            @Override
            public void keyPressed (KeyEvent e)
            {
                if (e.getKeyCode () == 90)
                {
                    if (arrangePaintings.size () > 0)
                        ctrlZ ();
                }
            }

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (e.getKeyCode () == 90)
                {
                    if (arrangePaintings.size () > 0)
                        ctrlZ ();
                }
            }
        });

        final KeyListener wListener = new KeyListener ()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
            }

            @Override
            public void keyPressed (KeyEvent e)
            {
                if (e.getKeyCode () == 38 || e.getKeyCode () == 40)
                {
                    changeWHXY (e , WitchWHXY.w);
                    invokeKeyReleased = false;
                }
                else invokeKeyReleased = true;
            }

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (invokeKeyReleased) changeWHXY (e , WitchWHXY.w);
            }
        };
        final KeyListener hListener = new KeyListener ()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
            }

            @Override
            public void keyPressed (KeyEvent e)
            {
                if (e.getKeyCode () == 38 || e.getKeyCode () == 40)
                {
                    changeWHXY (e , WitchWHXY.h);
                    invokeKeyReleased = false;
                }
                else invokeKeyReleased = true;
            }

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (invokeKeyReleased) changeWHXY (e , WitchWHXY.h);
            }
        };
        final KeyListener xListener = new KeyListener ()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
            }

            @Override
            public void keyPressed (KeyEvent e)
            {
                if (e.getKeyCode () == 38 || e.getKeyCode () == 40)
                {
                    changeWHXY (e , WitchWHXY.x);
                    invokeKeyReleased = false;
                }
                else invokeKeyReleased = true;
            }

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (invokeKeyReleased) changeWHXY (e , WitchWHXY.x);
            }
        };
        final KeyListener yListener = new KeyListener ()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
            }

            @Override
            public void keyPressed (KeyEvent e)
            {
                if (e.getKeyCode () == 38 || e.getKeyCode () == 40)
                {
                    changeWHXY (e , WitchWHXY.y);
                    invokeKeyReleased = false;
                }
                else invokeKeyReleased = true;
            }

            @Override
            public void keyReleased (KeyEvent e)
            {
                if (invokeKeyReleased) changeWHXY (e , WitchWHXY.y);
            }
        };
        paintView.txtWidth.addKeyListener (wListener);
        paintView.txtHeight.addKeyListener (hListener);
        paintView.txtX.addKeyListener (xListener);
        paintView.txtY.addKeyListener (yListener);
    }

    private boolean invokeKeyReleased = true;

    private enum WitchWHXY
    {
        w, h, x, y
    }

    private void changeWHXY (final KeyEvent e , final WitchWHXY witchWHXY)
    {
        final String txtWidth = paintView.txtWidth.getText ();
        final String txtHeight = paintView.txtHeight.getText ();
        final String txtX = paintView.txtX.getText ();
        final String txtY = paintView.txtY.getText ();

        if ((txtWidth != null && !txtWidth.equals ("")) && (txtHeight != null && !txtHeight.equals ("")) && (txtX != null && !txtX.equals ("")) && (txtY != null && !txtY.equals ("")))
        {
            try
            {
                int width = Integer.parseInt (txtWidth);
                int height = Integer.parseInt (txtHeight);
                int x = Integer.parseInt (txtX);
                int y = Integer.parseInt (txtY);

                if (e.getKeyCode () == 38)
                {
                    switch (witchWHXY)
                    {
                        case w:
                            paintView.txtWidth.setText (String.valueOf (++width));
                            break;
                        case h:
                            paintView.txtHeight.setText (String.valueOf (++height));
                            break;
                        case x:
                            paintView.txtX.setText (String.valueOf (++x));
                            break;
                        case y:
                            paintView.txtY.setText (String.valueOf (++y));
                            break;
                    }
                }
                else if (e.getKeyCode () == 40)
                {
                    switch (witchWHXY)
                    {
                        case w:
                            paintView.txtWidth.setText (String.valueOf (--width));
                            break;
                        case h:
                            paintView.txtHeight.setText (String.valueOf (--height));
                            break;
                        case x:
                            paintView.txtX.setText (String.valueOf (--x));
                            break;
                        case y:
                            paintView.txtY.setText (String.valueOf (--y));
                            break;
                    }
                }

                final Point point = Shape.point (x , y);
                final Size size = Shape.size (width , height);

                if (selectedArrangePainting != null)
                {
                    Tools tools = this.tools.get (selectedArrangePainting.selectedTool);
                    tools.setIndex (selectedArrangePainting.getIndex ());
                    tools.setPoint (point);
                    tools.mouseDragged (size);
                    repaint ();
                }
            }
            catch (Exception ignored)
            {
            }
        }
    }

    private void ctrlZ ()
    {
        int size = arrangePaintings.size ();
        if (size > 0)
        {
            ArrangePainting arrangePainting = arrangePaintings.get (size - 1);
            tools.get (arrangePainting.selectedTool).remove (arrangePainting.index);
            arrangePaintings.remove (size - 1);
            repaint ();
        }
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
