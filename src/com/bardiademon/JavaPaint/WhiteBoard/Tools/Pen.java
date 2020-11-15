package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Main;
import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public final class Pen implements Tools
{

    private List <Rectangle> rec = new ArrayList <> ();

    public Pen (final WhiteBoard whiteBoard)
    {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit ();
        try
        {
            File icPen = Main.getFile ("ic_pen");
            if (icPen != null)
                whiteBoard.setCursor ((defaultToolkit.createCustomCursor ((ImageIO.read (icPen).getScaledInstance (20 , 20 , BufferedImage.TYPE_INT_ARGB)) , Shape.point (0 , 0) , "pen")));
        }
        catch (IOException ignored)
        {
        }
    }

    @Override
    public void mouseDragged (Point point)
    {
        mousePressed (point);
    }

    @Override
    public void mousePressed (Point point)
    {
        rec.add (pen (point));
    }

    @Override
    public void mouseReleased (Point point)
    {

    }

    private Rectangle pen (Point point)
    {
        Rectangle rectangle = new Rectangle ();
        rectangle.setSize (Shape.size (1 , 1));
        rectangle.setPoint (point);
        return rectangle;
    }

    @Override
    public void paint (final Graphics2D g)
    {
        for (Rectangle rectangle : rec)
            g.drawRect (rectangle.getPoint ().x , rectangle.getPoint ().y , rectangle.getSize ().width , rectangle.getSize ().height);
    }
}
