package com.bardiademon.JavaPaint.WhiteBoard;

import com.bardiademon.JavaPaint.Main;
import com.bardiademon.JavaPaint.PaintView;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.BucketOfPaintTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.CircleTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.ColorPickerTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.DiamondTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.EraserTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.FivePointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.FourPointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.HexagonTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.LightningTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.LineTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.PenTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.PentagonTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.PolygonTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.RectTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.RightLeftArrowTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.RightTriangleTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.RoundRectangleTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SixPointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.TextTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.Tools;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.TriangleTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.UpDownArrowTool;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;


import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Point;

import java.awt.Robot;
import java.awt.Toolkit;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

@bardiademon
public final class WhiteBoard extends JLabel
{

    @bardiademon
    private Robot robot;

    @bardiademon
    public static SelectedTool selectedTool = SelectedTool.pen;

    @bardiademon
    private final PaintView paintView;

    @bardiademon
    private final Map <String, Tools> tools = new LinkedHashMap <> ();

    @bardiademon
    private final List <ArrangePainting> arrangePaintings = new ArrayList <> ();

    @bardiademon
    private final Toolkit defaultToolkit = Toolkit.getDefaultToolkit ();

    @bardiademon
    private ArrangePainting selectedArrangePainting;

    @bardiademon
    private boolean moving = false, resizing = false;

    @bardiademon
    private Point selectedMousePoint;

    @bardiademon
    private Tools tool;

    @bardiademon
    private boolean polygonFinish = true;

    private final static SelectedColor SELECTED_COLOR = new SelectedColor ();

    private static class SelectedColor
    {
        private Color color, backgroundColor;

        private SelectedColor ()
        {
            color = Color.BLACK;
            backgroundColor = Color.WHITE;
        }
    }

    public static void SetColor (final Color color)
    {
        SELECTED_COLOR.color = color;
    }

    public static void SetBackgroundColor (final Color backgroundColor)
    {
        SELECTED_COLOR.backgroundColor = backgroundColor;
    }

    public static Color GetColor ()
    {
        return SELECTED_COLOR.color;
    }

    public static Color GetBackgroundColor ()
    {
        return SELECTED_COLOR.backgroundColor;
    }

    @bardiademon
    public WhiteBoard (final PaintView _PaintView)
    {
        this.paintView = _PaintView;
        try
        {
            this.robot = new Robot ();
        }
        catch (AWTException ignored)
        {
        }

        tools.put (SelectedTool.pen.name () , new PenTool (this));
        tools.put (SelectedTool.four_point_star.name () , new FourPointStarTool (this));
        tools.put (SelectedTool.five_point_star.name () , new FivePointStarTool (this));
        tools.put (SelectedTool.circle.name () , new CircleTool (this));
        tools.put (SelectedTool.rect.name () , new RectTool (this));
        tools.put (SelectedTool.line.name () , new LineTool (this));
        tools.put (SelectedTool.round_rect.name () , new RoundRectangleTool (this));
        tools.put (SelectedTool.triangle.name () , new TriangleTool (this));
        tools.put (SelectedTool.diamond.name () , new DiamondTool (this));
        tools.put (SelectedTool.six_point_star.name () , new SixPointStarTool (this));
        tools.put (SelectedTool.right_arrow.name () , new RightLeftArrowTool (this));
        tools.put (SelectedTool.up_arrow.name () , new UpDownArrowTool (this));
        tools.put (SelectedTool.bucket_of_paint.name () , new BucketOfPaintTool (this));
        tools.put (SelectedTool.right_triangle.name () , new RightTriangleTool (this));
        tools.put (SelectedTool.text.name () , new TextTool (this));
        tools.put (SelectedTool.pentagon.name () , new PentagonTool (this));
        tools.put (SelectedTool.hexagon.name () , new HexagonTool (this));
        tools.put (SelectedTool.lightning.name () , new LightningTool (this));
        tools.put (SelectedTool.polygon.name () , new PolygonTool (this));
        tools.put (SelectedTool.eraser.name () , new EraserTool (this));
        tools.put (SelectedTool.color_picker.name () , new ColorPickerTool (this));

        paintView.thickness.addChangeListener (e ->
        {
            paintView.txtThickness.setText (String.valueOf (paintView.thickness.getValue ()));
            WhiteBoard.this.repaint ();
        });


        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                paintView.saved = false;

                selectedMousePoint = e.getPoint ();

                if (!moving && !resizing)
                {
                    tool = WhiteBoard.this.tools.get (selectedTool.name ());
                    if (tool != null)
                    {
                        tool.select ();

                        if (!tool.isPaint ())
                        {
                            tool.mousePressed (e.getPoint ());
                            tool.mousePressed (e.getPoint () , e.getButton ());
                            selectedArrangePainting = null;
                            return;
                        }

                        if (polygonFinish)
                        {
                            if (selectedTool.equals (SelectedTool.polygon) && e.getClickCount () >= 2)
                                tool.mouseDbClick (e.getPoint ());
                            else
                            {
                                tool.mousePressed (e.getPoint ());
                                tool.mousePressed (e.getPoint () , e.getButton ());
                            }

                            selectedArrangePainting = new ArrangePainting (selectedTool.name ());
                            selectedArrangePainting.setIndex (tool.getIndex ());

                            final ArrangePainting arrangePainting = selectedArrangePainting;
                            arrangePaintings.add (arrangePainting);
                        }
                        else
                        {
                            tool.mousePressed (e.getPoint ());
                            tool.mousePressed (e.getPoint () , e.getButton ());
                        }

                        if (selectedTool.equals (SelectedTool.polygon))
                            polygonFinish = e.getClickCount () >= 2;
                        else polygonFinish = true;

                        repaint ();
                    }
                }
            }

            @bardiademon
            @Override
            public void mouseReleased (MouseEvent e)
            {
                tool = WhiteBoard.this.tools.get (selectedTool.name ());
                if (tool != null && tool.isPaint ())
                {
                    tool.mouseReleased (e.getPoint ());
                    repaint ();
                }
                else selectedArrangePainting = null;
            }

            @bardiademon
            @Override
            public void mouseClicked (MouseEvent e)
            {
                setFocus ();

                WhiteBoard.this.setFocusable (true);
                WhiteBoard.this.setRequestFocusEnabled (true);
            }
        });

        addMouseMotionListener (new MouseMotionListener ()
        {
            @bardiademon
            @Override
            public void mouseDragged (MouseEvent e)
            {
                paintView.setMousePosition (e.getPoint ());
                if (selectedArrangePainting != null)
                {
                    tool = WhiteBoard.this.tools.get (selectedArrangePainting.selectedTool);
                    if (tool != null && tool.isPaint ())
                    {
                        if (moving || resizing)
                        {
                            final Point point = tool.getPoint (selectedArrangePainting.getIndex ());
                            if (point != null)
                            {
                                int x = point.x, y = point.y;

                                final int xM = Math.abs (selectedMousePoint.x - e.getX ());
                                if (xM != 0)
                                {
                                    if (selectedMousePoint.x > e.getX ())
                                        x = point.x - xM;
                                    else x = point.x + xM;
                                }

                                final int yM = Math.abs (selectedMousePoint.y - e.getY ());
                                if (yM != 0)
                                {
                                    if (selectedMousePoint.y > e.getY ())
                                        y = point.y - yM;
                                    else y = point.y + yM;
                                }

                                selectedMousePoint = e.getPoint ();

                                tool.setIndex (selectedArrangePainting.getIndex ());

                                if (moving)
                                    tool.setPoint (Shape.point (x , y));
                                else if (resizing)
                                    tool.mouseDragged (Shape.sizeWithPoint (e.getPoint () , Shape.point (x , y)));

                                setWHXY (null , tool.getPoint (selectedArrangePainting.getIndex ()));
                                repaint ();

                                resizing = false;

                                return;
                            }
                        }

                        tool.mouseDragged (e.getPoint ());
                        repaint ();
                    }
                }
            }

            @bardiademon
            @Override
            public void mouseMoved (MouseEvent e)
            {
                setFocus ();
                paintView.setMousePosition (e.getPoint ());
                if (selectedTool != null)
                {
                    tool = WhiteBoard.this.tools.get (selectedTool.name ());
                    tool.select ();
                    if (!tool.isPaint ()) return;

                    if (selectedArrangePainting != null)
                    {
                        tool = WhiteBoard.this.tools.get (selectedArrangePainting.selectedTool);
                        if (tool != null && tool.isPaint ())
                        {
                            final Point point = tool.getPoint (selectedArrangePainting.getIndex ());
                            final Point allPoint = tool.getAllPoint (selectedArrangePainting.getIndex ());
                            if (point != null && allPoint != null)
                            {
                                if (moving = ((e.getX () > point.x && e.getY () > point.y) && (e.getX () < allPoint.x && e.getY () < allPoint.y)))
                                {
                                    setCursor (Cursor.getPredefinedCursor (Cursor.MOVE_CURSOR));
                                    return;
                                }
                                else
                                {
                                    final Point leftUp = Shape.point (point.x , point.y);
                                    final Point rightUp = Shape.point (allPoint.x , point.y);
                                    final Point leftDown = Shape.point (point.x , allPoint.y);
                                    final Point rightDown = Shape.point (allPoint.x , allPoint.y);

                                    if (Shape.PointComparison (e.getPoint () , leftUp)
                                            || Shape.PointComparison (e.getPoint () , rightUp)
                                            || Shape.PointComparison (e.getPoint () , leftDown)
                                            || Shape.PointComparison (e.getPoint () , rightDown))
                                    {
                                        moving = false;
                                        resizing = true;
                                        setCursor (Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
                                    }
                                    else tool.select ();
                                }
                            }
                        }
                        else selectedArrangePainting = null;
                    }
                    moving = false;
                }
            }
        });

        onKeyListener ();

        addComponentListener (new ComponentAdapter ()
        {
            @Override
            public void componentResized (ComponentEvent e)
            {
                setBackgroundImage ();
            }
        });
    }

    @bardiademon
    private void setFocus ()
    {
        setFocusable (true);
        setRequestFocusEnabled (true);
        requestFocusInWindow ();
    }

    @bardiademon
    private void onKeyListener ()
    {
        super.addKeyListener (new KeyListener ()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
            }

            @bardiademon
            @Override
            public void keyPressed (KeyEvent e)
            {
                if (e.getKeyCode () == 90)
                {
                    if (arrangePaintings.size () > 0)
                        ctrlZ ();
                }
            }

            @bardiademon
            @Override
            public void keyReleased (KeyEvent e)
            {
            }
        });

        final KeyListener wListener = new KeyListener ()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
            }

            @bardiademon
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

            @bardiademon
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

            @bardiademon
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

            @bardiademon
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

            @bardiademon
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

            @bardiademon
            @Override
            public void keyReleased (KeyEvent e)
            {
                if (invokeKeyReleased) changeWHXY (e , WitchWHXY.x);
            }
        };
        final KeyListener yListener = new KeyListener ()
        {
            @bardiademon
            @Override
            public void keyTyped (KeyEvent e)
            {
            }

            @bardiademon
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

            @bardiademon
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

    @bardiademon
    private boolean invokeKeyReleased = true;

    @bardiademon
    private File fileBackground;

    @bardiademon
    private BufferedImage read;

    @bardiademon
    public void setBackground ()
    {
        final JFileChooser chooser = new JFileChooser (fileBackground);
        if (chooser.showOpenDialog (null) == JFileChooser.OPEN_DIALOG)
        {
            try
            {
                read = ImageIO.read (chooser.getSelectedFile ());
                fileBackground = chooser.getSelectedFile ().getParentFile ();
                setBackgroundImage ();
            }
            catch (IOException e)
            {
                setIcon (null);
            }
        }
        else setIcon (null);
    }

    @bardiademon
    private void setBackgroundImage ()
    {
        if (read != null)
            setIcon (new ImageIcon (read.getScaledInstance (getWidth () , getHeight () , BufferedImage.TYPE_4BYTE_ABGR)));
        else setIcon (null);
    }


    public Color getBackgroundColor ()
    {
        return getBackground ();
    }

    @bardiademon
    private enum WitchWHXY
    {
        w, h, x, y
    }

    @bardiademon
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

    @bardiademon
    public void ctrlZ ()
    {
        final int size = arrangePaintings.size ();
        if (size > 0)
        {
            final ArrangePainting arrangePainting = arrangePaintings.get (size - 1);
            tools.get (arrangePainting.selectedTool).remove (arrangePainting.index);
            arrangePaintings.remove (size - 1);
            polygonFinish = true;
            repaint ();
        }
    }

    public void clear ()
    {
        selectedArrangePainting = null;
        selectedTool = SelectedTool.pen;
        arrangePaintings.clear ();
        repaint ();
    }

    @bardiademon
    @Override
    public void paint (Graphics g)
    {
        super.paint (g);
        final Graphics2D g2 = (Graphics2D) g;
        arrangePaintings.forEach ((ap) ->
                tools.get (ap.selectedTool).paint (g2 , ap.getIndex ()));
    }

    @bardiademon
    public static final class ArrangePainting
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

        public String getSelectedTool ()
        {
            return selectedTool;
        }
    }

    @bardiademon
    public void setCursor (final String name , final Point hotspot)
    {
        try
        {
            final File icPen = Main.getFile (name);
            if (icPen != null)
            {
                BufferedImage read = ImageIO.read (icPen);
                setCursor (defaultToolkit.createCustomCursor ((read.getScaledInstance (read.getWidth () , read.getHeight () , BufferedImage.TYPE_INT_ARGB)) , hotspot , "pen"));
            }
        }
        catch (IOException ignored)
        {
        }
    }

    @bardiademon
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

    public Robot getRobot ()
    {
        return robot;
    }

    public Map <String, Tools> getTools ()
    {
        return tools;
    }

    @bardiademon
    public PaintView getPaintView ()
    {
        return paintView;
    }
}
