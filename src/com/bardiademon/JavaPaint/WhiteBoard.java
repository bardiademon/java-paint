package com.bardiademon.JavaPaint;

import com.bardiademon.JavaPaint.Shapes.Shape;
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

    private final PaintView paintView;

    public final List <Paint> paints = new ArrayList <> ();
    public FourPointStar fourPointStar;

    private Paint paint = graphics2D -> fourPointStar.paint (graphics2D);

    public WhiteBoard (final PaintView _PaintView)
    {

        this.paintView = _PaintView;


        fourPointStar = new FourPointStar ();
        fourPointStar.setThickness (paintView.thickness.getValue ());
        addPaint (paint);
        repaint ();

        addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                fourPointStar.setPoint (e.getPoint ());
            }

            @Override
            public void mouseReleased (MouseEvent e)
            {
                fourPointStar = new FourPointStar ();
                fourPointStar.setThickness (paintView.thickness.getValue ());
                FourPointStar fourPointStar1 = fourPointStar;
                addPaint (fourPointStar1::paint);
            }
        });

        addMouseMotionListener (new MouseMotionListener ()
        {

            @Override
            public void mouseDragged (MouseEvent e)
            {
                if (fourPointStar.getPoint () != null)
                    fourPointStar.setSize (Shape.size (Math.abs (e.getX () - fourPointStar.getPoint ().x) , Math.abs (e.getY () - fourPointStar.getPoint ().y)));

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
