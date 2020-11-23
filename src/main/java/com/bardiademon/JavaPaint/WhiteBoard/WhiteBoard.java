package com.bardiademon.JavaPaint.WhiteBoard;

import com.bardiademon.JavaPaint.Main;
import com.bardiademon.JavaPaint.PaintView;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.BucketOfPaint;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.CircleTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.DiamondTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.FivePointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.FourPointStarTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.HexagonTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.LightningTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.LineTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.Pen;
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
import com.sun.glass.ui.Size;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Robot;
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


public final class WhiteBoard extends JPanel
{

    private Robot robot;

    public static SelectedTool selectedTool = SelectedTool.pen;

    private final PaintView paintView;

    private final Map <String, Tools> tools = new LinkedHashMap <> ();

    private final List <ArrangePainting> arrangePaintings = new ArrayList <> ();

    private final Toolkit defaultToolkit = Toolkit.getDefaultToolkit ();

    private ArrangePainting selectedArrangePainting;

    private boolean moving = false, resizing = false;

    private Color backgroundColor;

    private Point selectedMousePoint;

    private Tools tool;

    private boolean polygonFinish = true;

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

        tools.put (SelectedTool.pen.name () , new Pen (this));
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
        tools.put (SelectedTool.bucket_of_paint.name () , new BucketOfPaint (this));
        tools.put (SelectedTool.right_triangle.name () , new RightTriangleTool (this));
        tools.put (SelectedTool.text.name () , new TextTool (this));
        tools.put (SelectedTool.pentagon.name () , new PentagonTool (this));
        tools.put (SelectedTool.hexagon.name () , new HexagonTool (this));
        tools.put (SelectedTool.lightning.name () , new LightningTool (this));
        tools.put (SelectedTool.polygon.name () , new PolygonTool (this));

        paintView.thickness.addChangeListener (e -> WhiteBoard.this.repaint ());

        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                selectedMousePoint = e.getPoint ();

                if (!moving && !resizing)
                {
                    tool = WhiteBoard.this.tools.get (selectedTool.name ());
                    if (tool != null)
                    {
                        tool.select ();

                        if (polygonFinish)
                        {
                            if (selectedTool.equals (SelectedTool.polygon) && e.getClickCount () >= 2)
                                tool.mouseDbClick (e.getPoint ());
                            else
                                tool.mousePressed (e.getPoint ());

                            selectedArrangePainting = new ArrangePainting (selectedTool.name ());
                            selectedArrangePainting.setIndex (tool.getIndex ());

                            final ArrangePainting arrangePainting = selectedArrangePainting;
                            arrangePaintings.add (arrangePainting);
                        }
                        else tool.mousePressed (e.getPoint ());

                        if (selectedTool.equals (SelectedTool.polygon))
                            polygonFinish = e.getClickCount () >= 2;
                        else polygonFinish = true;

                        repaint ();
                    }
                }
            }

            @Override
            public void mouseReleased (MouseEvent e)
            {
                tool = WhiteBoard.this.tools.get (selectedTool.name ());
                if (tool != null)
                {
                    tool.mouseReleased (e.getPoint ());
                    repaint ();
                }
            }

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
            @Override
            public void mouseDragged (MouseEvent e)
            {
                if (selectedArrangePainting != null)
                {
                    tool = WhiteBoard.this.tools.get (selectedArrangePainting.selectedTool);
                    if (tool != null)
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

            @Override
            public void mouseMoved (MouseEvent e)
            {
                setFocus ();
                paintView.setCursorPoint (e.getPoint ());

                if (selectedArrangePainting != null)
                {
                    tool = WhiteBoard.this.tools.get (selectedArrangePainting.selectedTool);
                    if (tool != null)
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
                }
                moving = false;
            }
        });

        onKeyListener ();

    }


    private void setFocus ()
    {
        setFocusable (true);
        setRequestFocusEnabled (true);
        requestFocusInWindow ();
    }

    private void onKeyListener ()
    {
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

    public Robot getRobot ()
    {
        return robot;
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
