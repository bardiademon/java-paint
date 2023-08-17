package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Diamond;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class DiamondTool extends ShapeTool<Diamond> implements Tools<Diamond> {
    @bardiademon
    private final List<Diamond> diamonds = new ArrayList<>();

    @bardiademon
    public DiamondTool(final WhiteBoard whiteBoard) {
        super(whiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged(final Point point) {
        diamonds.get(diamonds.size() - 1).setSizeWithPoint(point);
    }

    @bardiademon
    @Override
    public void mouseDragged(final Size size) {
        diamonds.get(index).setSize(size);
    }

    @bardiademon
    @Override
    public void mousePressed(final Point point) {
        final Diamond diamond = new Diamond();
        diamond.setPoint(point);
        diamond.shape(setShape(diamond));
        diamonds.add(diamond);
        index = diamonds.size() - 1;
    }

    @Override
    public void setPoint(final Point point , final int index) {
        diamonds.get(index).setPoint(point);
    }

    @Override
    public void setSize(final Size size , int index) {
        diamonds.get(index).setSize(size);
    }

    @bardiademon
    @Override
    public void setPoint(final Point point) {
        diamonds.get(index).setPoint(point);
    }

    @bardiademon
    @Override
    public void remove(int index) {
        if (index >= 0 && index < diamonds.size())
            diamonds.remove(index);
    }

    @bardiademon
    @Override
    public void paint(final Graphics2D g , final int index) {
        if (index >= 0 && index < diamonds.size()) {
            Diamond diamond = diamonds.get(index);
            whiteBoard.setWHXY(diamond.getSize() , diamond.getPoint());
            diamonds.get(index).paint(g);
        }
    }

    @bardiademon
    @Override
    public Point getPoint(final int index) {
        if (index >= 0 && index < diamonds.size())
            return diamonds.get(index).getPoint();
        else return super.getPoint(index);
    }

    @Override
    public boolean isFill(final int index) {
        if (checkIndex(index , diamonds.size()))
            return diamonds.get(index).isFill();
        else return super.isFill(index);
    }

    @Override
    public int getThickness(final int index) {
        if (checkIndex(index , diamonds.size()))
            return diamonds.get(index).getThickness();
        else return super.getThickness(index);
    }

    @Override
    public Color getColor(final int index) {
        if (checkIndex(index , diamonds.size()))
            return diamonds.get(index).getColor();
        else return super.getColor(index);
    }

    @Override
    public Color getBackgroundColor(final int index) {
        if (checkIndex(index , diamonds.size()))
            return diamonds.get(index).getBackgroundColor();
        else return super.getBackgroundColor(index);
    }

    @Override
    public void setFill(final int index , final boolean fill) {
        if (checkIndex(index , diamonds.size()))
            diamonds.get(index).setFill(fill);
    }

    @Override
    public void setThickness(final int index , final int thickness) {
        if (checkIndex(index , diamonds.size()))
            diamonds.get(index).setThickness(thickness);
    }

    @Override
    public void setColor(final int index , final Color color) {
        if (checkIndex(index , diamonds.size()))
            diamonds.get(index).setColor(color);
    }

    @Override
    public void setBackgroundColor(final int index , final Color color) {
        if (checkIndex(index , diamonds.size()))
            diamonds.get(index).setBackgroundColor(color);
    }

    @Override
    public Size getSize(int index) {
        if (checkIndex(index , diamonds.size()))
            return diamonds.get(index).getSize();
        else return null;
    }

    @bardiademon
    @Override
    public Point getAllPoint(final int index) {
        if (index >= 0 && index < diamonds.size())
            return diamonds.get(index).getAllPoint();
        else return super.getAllPoint(index);
    }

}
