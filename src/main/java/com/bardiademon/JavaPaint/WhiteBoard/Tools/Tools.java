package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public interface Tools <T>
{

    @bardiademon
    void select ();

    @bardiademon
    void mouseDragged (final Point point);

    @bardiademon
    void mouseDragged (final Size size);

    @bardiademon
    void mousePressed (final Point point);

    @bardiademon
    void mousePressed (final Point point , final int button);

    @bardiademon
    void mouseReleased (final Point point);

    @bardiademon
    void paint (final Graphics2D g , final int index);

    @bardiademon
    void paint (final Graphics2D g , final int index , final Point point , final Size size);

    @bardiademon
    String shapeName ();

    @bardiademon
    void setPoint (final Point point);

    @bardiademon
    void setPoint (final Point point , final int index);

    @bardiademon
    void setSize (final Size size , final int index);

    @bardiademon
    void remove (final int index);

    @bardiademon
    int getIndex ();

    @bardiademon
    Point getPoint (final int index);

    @bardiademon
    Point getAllPoint (final int index);

    @bardiademon
    Size getSize (final int index);

    @bardiademon
    boolean isFill (final int index);

    @bardiademon
    int getThickness (final int index);

    @bardiademon
    Color getColor (final int index);

    @bardiademon
    Color getBackgroundColor (final int index);

    @bardiademon
    void setFill (final int index , final boolean fill);

    @bardiademon
    void setThickness (final int index , final int thickness);

    @bardiademon
    void setColor (final int index , final Color color);

    @bardiademon
    void setBackgroundColor (final int index , final Color color);

    @bardiademon
    void setIndex (final int index);

    @bardiademon
    void mouseDbClick (final Point point);

    @bardiademon
    boolean isPaint ();

    @bardiademon
    void setPaint (final boolean paint);

    @bardiademon
    String toString (final int index);

    T getShape (final int index);

}
