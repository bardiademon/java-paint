package com.bardiademon.JavaPaint;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.Shapes.Stars.FivePointStar;
import com.bardiademon.JavaPaint.Shapes.Stars.FourPointStar;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class WhiteBoard extends JPanel
{

    private FivePointStar fivePointStar;

    private final PaintView paintView;

    private Paint paint = graphics2D -> fivePointStar.paint (graphics2D);
    private final List <Paint> paints = new ArrayList <> ();

    public WhiteBoard (final PaintView _PaintView)
    {

        this.paintView = _PaintView;
        fivePointStar = new FivePointStar ();
        fivePointStar.setThickness (paintView.thickness.getValue ());
        addPaint (paint);
        repaint ();

        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                fivePointStar.setPoint (e.getPoint ());
            }

            @Override
            public void mouseReleased (MouseEvent e)
            {
                fivePointStar = new FivePointStar ();
                fivePointStar.setThickness (paintView.thickness.getValue ());
                FivePointStar fivePointStar1 = fivePointStar;
                addPaint (fivePointStar1::paint);
            }
        });

        addMouseMotionListener (new MouseMotionListener ()
        {

            @Override
            public void mouseDragged (MouseEvent e)
            {
                if (fivePointStar.getPoint () != null)
                    fivePointStar.setSize (Shape.size (Math.abs (e.getX () - fivePointStar.getPoint ().x) , Math.abs (e.getY () - fivePointStar.getPoint ().y)));

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

//        FivePointStar fivePointStar = new FivePointStar ();
//        fivePointStar.setSize (Shape.size (500 , 500));
//        fivePointStar.setPoint (Shape.point (20 , 20));
//        fivePointStar.paint (g2);

        for (Paint paint : paints) paint.paint (g2);
    }

    public interface Paint
    {
        void paint (Graphics2D g);
    }

    public void addPaint (Paint paint)
    {
        if (paint != null)
        {
            paints.add (paint);
            repaint ();
        }
    }

}
