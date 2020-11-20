package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.sun.glass.ui.Size;
import java.awt.Graphics2D;
import java.awt.Point;

public interface Tools
{
    void select ();

    void mouseDragged (final Point point);

    void mouseDragged (final Size size);

    void mousePressed (final Point point);

    void mouseReleased (final Point point);

    void paint (final Graphics2D g , final int index);

    void setPoint (final Point point);

    void remove (final int index);

    int getIndex ();

    void setIndex (final int index);
}
