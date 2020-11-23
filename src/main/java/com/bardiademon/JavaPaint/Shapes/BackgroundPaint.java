package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.Main;
import com.bardiademon.JavaPaint.Mth;
import com.bardiademon.JavaPaint.Shapes.Arrow.RightLeftArrow;
import com.bardiademon.JavaPaint.Shapes.Arrow.UpDownArrow;
import com.bardiademon.JavaPaint.Shapes.Stars.FivePointStar;
import com.bardiademon.JavaPaint.Shapes.Stars.FourPointStar;
import com.bardiademon.JavaPaint.Shapes.Stars.SixPointStar;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import com.sun.glass.ui.Size;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class BackgroundPaint
{

    public void paint (final Graphics2D g , final SelectedTool selectedTool , final Point point , final Size size)
    {
        if (selectedTool != null)
        {
            switch (selectedTool)
            {
                case circle:
                    circle (g , getShape (size));
                    break;
                case rect:
                    rect (g , getShape (size));
                    break;
                case round_rect:
                    roundRect (g , getShape (size));
                    break;
                case polygon:
                    polygon (g , getShape (size));
                    break;
                case triangle:
                    triangle (g , size);
                    break;
                case heart:
                    heart (g , size);
                    break;
                case four_point_star:
                    fourStar (g , getShape (size));
                    break;
                case five_point_star:
                    fiveStar (g , getShape (size));
                    break;
                case pen:
                    pen (g , getShape (size));
                    break;
                case line:
                    line (g , getShape (size));
                    break;
                case diamond:
                    diamond (g , getShape (size));
                    break;
                case six_point_star:
                    sixStar (g , getShape (size));
                    break;
                case right_arrow:
                    rightArrow (g , getShape (size));
                    break;
                case up_arrow:
                    upArrow (g , getShape (size));
                    break;
                case bucket_of_paint:
                    bucketOfPaint (g , getShape (size));
                    break;
                case right_triangle:
                    rightTriangle (g , getShape (size));
                    break;
                case text:
                    text (g , getShape (size));
                    break;
                case pentagon:
                    pentagon (g , getShape (size));
                    break;
                case hexagon:
                    hexagon (g , getShape (size));
                    break;
                case lightning:
                    lightning (g , getShape (size));
                    break;
                default:
                    break;
            }
        }
    }

    private void hexagon (Graphics2D g , Shape shape)
    {
        final Hexagon hexagon = new Hexagon ();
        hexagon.shape (shape);
        hexagon.paint (g);
    }

    private void circle (final Graphics2D g , final Shape shape)
    {
        Point point = shape.getPoint ();
        Size widthHeight = shape.getSize ();

        g.setStroke (new BasicStroke (shape.getThickness ()));
        g.fillOval (point.x , point.y , widthHeight.width , widthHeight.height);
    }

    private void lightning (final Graphics2D g , final Shape shape)
    {
        final Lightning lightning = new Lightning ();
        lightning.shape (shape);
        lightning.paint (g);
    }

    private void rightArrow (final Graphics2D g , final Shape shape)
    {
        final RightLeftArrow rightLeftArrow = new RightLeftArrow ();
        rightLeftArrow.shape (shape);
        rightLeftArrow.paint (g);
    }

    private void upArrow (final Graphics2D g , final Shape shape)
    {
        final UpDownArrow upDownArrow = new UpDownArrow ();
        upDownArrow.shape (shape);
        upDownArrow.paint (g);
    }

    private void bucketOfPaint (final Graphics2D g , final Shape shape)
    {
        final File file = Main.getFile ("ic_paint_bucket");
        if (file != null)
        {
            try
            {
                Image imgBucketOfPaint = ImageIO.read (file).getScaledInstance (shape.getSize ().width , shape.getSize ().height , BufferedImage.TYPE_4BYTE_ABGR);
                g.drawImage (imgBucketOfPaint , shape.getPoint ().x , shape.getSize ().height , null);
            }
            catch (IOException ignored)
            {
            }
        }
    }

    private void rect (final Graphics2D g , final Shape shape)
    {
        Point point = shape.getPoint ();
        Size size = shape.getSize ();

        g.setStroke (new BasicStroke (shape.getThickness ()));
        g.fillRect (point.x , point.y , size.width , size.height);
    }

    private void roundRect (final Graphics2D g , final Shape shape)
    {
        Point point = shape.getPoint ();
        Size size = shape.getSize ();

        g.setStroke (new BasicStroke (shape.getThickness ()));
        g.fillRoundRect (point.x , point.y , size.width , size.height , 3 , 3);
    }

    private void rightTriangle (final Graphics2D g , final Shape shape)
    {
        final RightTriangle rightTriangle = new RightTriangle ();
        rightTriangle.shape (shape);
        rightTriangle.paint (g);
    }

    private void text (final Graphics2D g , final Shape shape)
    {
        File icA = Main.getFile ("ic_a");
        if (icA != null)
        {
            try
            {
                g.drawImage (ImageIO.read (icA).getScaledInstance (shape.getSize ().width , shape.getSize ().height , BufferedImage.TYPE_4BYTE_ABGR) , shape.getPoint ().x , shape.getPoint ().y , null);
            }
            catch (IOException ignored)
            {
            }
        }
    }

    private void polygon (final Graphics2D g , final Shape shape)
    {
        Point point = shape.getPoint ();
        Size size = shape.getSize ();
        g.setStroke (new BasicStroke (shape.getThickness ()));
        g.drawLine (point.x , point.y , size.width , point.y);
        g.drawLine (point.x , point.y , point.x , size.height);
        g.drawLine (point.x , size.height , size.width + 5 , size.height);
        g.drawLine (size.width + 5 , size.height - 5 , size.width + 5 , size.height);
    }

    private void triangle (final Graphics2D g , final Size size)
    {
        g.setStroke (new BasicStroke (3));

        Point point1 = Shape.point (size.width / 2 , Mth.percentageOfAValue (size.height , 20));
        Point point2 = Shape.point (Mth.percentageOfAValue (size.width , 20) , Mth.percentageOfAValue (size.height , 80));

        g.drawLine (point1.x , point1.y , point2.x , point2.y);

        Point point3 = Shape.point (Mth.percentageOfAValue (size.width , 80) , point2.y);

        g.drawLine (point1.x , point1.y , point3.x , point3.y);

        g.drawLine (point2.x , point2.y , point3.x , point3.y);
    }

    public void heart (final Graphics2D g , final Size size)
    {
    }

    private void diamond (final Graphics2D g , final Shape shape)
    {
        final Diamond diamond = new Diamond ();
        diamond.shape (shape);
        diamond.paint (g);
    }

    private void line (final Graphics2D g , final Shape shape)
    {
        final Line line = new Line ();
        line.setPoint1 (Shape.point (0 , 0));
        line.setPoint2 (Shape.point (shape.getSize ().width , shape.getSize ().height));
        line.setColor (Color.BLACK);
        line.setThickness (2);
        line.paint (g);
    }

    private void fourStar (final Graphics2D g , final Shape shape)
    {
        final FourPointStar fourPointStar = new FourPointStar ();
        fourPointStar.shape (shape);
        fourPointStar.paint (g);
    }

    private void sixStar (final Graphics2D g , final Shape shape)
    {
        final SixPointStar fourPointStar = new SixPointStar ();
        fourPointStar.shape (shape);
        fourPointStar.paint (g);
    }

    private void fiveStar (final Graphics2D g , final Shape shape)
    {
        final FivePointStar fourPointStar = new FivePointStar ();
        fourPointStar.shape (shape);
        fourPointStar.paint (g);
    }

    private void pentagon (final Graphics2D g , final Shape shape)
    {
        final Pentagon pentagon = new Pentagon ();
        pentagon.shape (shape);
        pentagon.paint (g);
    }

    private void pen (final Graphics2D g , final Shape shape)
    {
        File icPen = Main.getFile ("ic_pen");
        if (icPen != null)
        {
            try
            {
                g.drawImage (ImageIO.read (icPen).getScaledInstance (shape.getSize ().width , shape.getSize ().height , BufferedImage.TYPE_4BYTE_ABGR) , shape.getPoint ().x , shape.getPoint ().y , null);
            }
            catch (IOException ignored)
            {
            }
        }
    }

    private Shape getShape (final Size size)
    {
        int width = size.width / 2;
        int height = size.height / 2;

        int x = (width / 2);
        int y = (height / 2);

        Shape shape = new Shape ();
        shape.setPoint (Shape.point (x , y));
        shape.setSize (Shape.size (width , height));
        shape.setThickness (2);
        shape.setColor (Color.BLACK);

        return shape;
    }
}
