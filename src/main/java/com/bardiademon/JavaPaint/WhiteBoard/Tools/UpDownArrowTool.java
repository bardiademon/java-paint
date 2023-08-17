package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Arrow.UpDownArrow;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class UpDownArrowTool extends ShapeTool<UpDownArrow> implements Tools<UpDownArrow> {

    @bardiademon
    private final List<UpDownArrow> upDownArrows = new ArrayList<>();

    @bardiademon
    public UpDownArrowTool(final WhiteBoard whiteBoard) {
        super(whiteBoard);
    }

    @Override
    public Size getSize(final int index) {
        if (checkIndex(index , upDownArrows.size()))
            return upDownArrows.get(index).getSize();
        else return null;
    }

    @Override
    public boolean isFill(final int index) {
        if (checkIndex(index , upDownArrows.size()))
            return upDownArrows.get(index).isFill();
        else return super.isFill(index);
    }

    @Override
    public int getThickness(final int index) {
        if (checkIndex(index , upDownArrows.size()))
            return upDownArrows.get(index).getThickness();
        else return super.getThickness(index);
    }

    @Override
    public Color getColor(final int index) {
        if (checkIndex(index , upDownArrows.size()))
            return upDownArrows.get(index).getColor();
        else return super.getColor(index);
    }

    @Override
    public Color getBackgroundColor(final int index) {
        if (checkIndex(index , upDownArrows.size()))
            return upDownArrows.get(index).getBackgroundColor();
        else return super.getBackgroundColor(index);
    }

    @Override
    public void setFill(final int index , final boolean fill) {
        if (checkIndex(index , upDownArrows.size()))
            upDownArrows.get(index).setFill(fill);
    }

    @Override
    public void setThickness(final int index , final int thickness) {
        if (checkIndex(index , upDownArrows.size()))
            upDownArrows.get(index).setThickness(thickness);
    }

    @Override
    public void setColor(final int index , final Color color) {
        if (checkIndex(index , upDownArrows.size()))
            upDownArrows.get(index).setColor(color);
    }

    @Override
    public void setBackgroundColor(final int index , final Color color) {
        if (checkIndex(index , upDownArrows.size()))
            upDownArrows.get(index).setBackgroundColor(color);
    }

    @bardiademon
    @Override
    public void mouseDragged(final Point point) {
        upDownArrows.get(getIndex()).setSizeWithPoint(point);
    }

    @bardiademon
    @Override
    public void mouseDragged(final Size size) {
        upDownArrows.get(getIndex()).setSize(size);
    }

    @bardiademon
    @Override
    public void mousePressed(final Point point) {
        final UpDownArrow upDownArrow = new UpDownArrow();
        upDownArrow.setPoint(point);
        upDownArrow.shape(setShape(upDownArrow));
        upDownArrows.add(upDownArrow);
        setIndex(upDownArrows.size() - 1);
    }

    @bardiademon
    @Override
    public void paint(final Graphics2D g , final int index) {
        if (index >= 0 && index < upDownArrows.size()) {
            final UpDownArrow upDownArrow = upDownArrows.get(index);
            whiteBoard.setWHXY(upDownArrow.getSize() , upDownArrow.getPoint());
            upDownArrow.paint(g);
        }
    }

    @bardiademon
    @Override
    public void setPoint(final Point point) {
        if (index >= 0 && index < upDownArrows.size())
            upDownArrows.get(index).setPoint(point);
    }

    @bardiademon
    @Override
    public void remove(final int index) {
        if (index >= 0 && index < upDownArrows.size())
            upDownArrows.remove(index);
    }

    @Override
    public void setPoint(final Point point , final int index) {
        if (index >= 0 && index < upDownArrows.size())
            upDownArrows.get(index).setPoint(point);
    }

    @Override
    public void setSize(final Size size , final int index) {
        if (index >= 0 && index < upDownArrows.size())
            upDownArrows.get(index).setSize(size);
    }

    @bardiademon
    @Override
    public Point getPoint(final int index) {
        if (index >= 0 && index < upDownArrows.size())
            return upDownArrows.get(index).getPoint();
        else return super.getPoint(index);
    }

    @bardiademon
    @Override
    public Point getAllPoint(final int index) {
        if (index >= 0 && index < upDownArrows.size())
            return upDownArrows.get(index).getAllPoint();
        else return super.getAllPoint(index);
    }
}
