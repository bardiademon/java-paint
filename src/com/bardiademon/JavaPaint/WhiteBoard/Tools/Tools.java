package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import java.awt.Graphics2D;
import java.awt.Point;

public interface Tools
{
    void select ();

    void mouseDragged (final Point point);

    void mousePressed (final Point point);

    void mouseReleased (final Point point);

    void paint (final Graphics2D g , int index);

    int getIndex ();
}
