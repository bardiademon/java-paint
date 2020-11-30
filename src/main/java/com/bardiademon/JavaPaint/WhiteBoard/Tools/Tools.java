package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public interface Tools
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
    void mouseReleased (final Point point);

    @bardiademon
    void paint (final Graphics2D g , final int index);

    @bardiademon
    void setPoint (final Point point);

    @bardiademon
    void remove (final int index);

    @bardiademon
    int getIndex ();

    @bardiademon
    Point getPoint (final int index);

    @bardiademon
    Point getAllPoint (final int index);

    @bardiademon
    void setIndex (final int index);

    @bardiademon
    void mouseDbClick (final Point point);
}
