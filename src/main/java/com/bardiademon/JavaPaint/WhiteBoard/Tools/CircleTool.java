package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Circle;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class CircleTool extends ShapeTool<Circle> implements Tools<Circle> {

    @bardiademon
    private final List<Circle> circles = new ArrayList<>();

    @bardiademon
    public CircleTool(final WhiteBoard whiteBoard) {
        super(whiteBoard);
    }

    @bardiademon
    @Override
    public void select() {
        setCursor();
    }

    @bardiademon
    @Override
    public void mouseDragged(final Point point) {
        circles.get(index).setSizeWithPoint(point);
    }

    @bardiademon
    @Override
    public void mouseDragged(final Size size) {
        circles.get(index).setSize(size);
    }

    @bardiademon
    @Override
    public void mousePressed(final Point point) {
        final Circle circle = new Circle();
        circle.setPoint(point);
        circle.shape(setShape(circle));
        circles.add(circle);
        setIndex(circles.size() - 1);
    }

    @bardiademon
    @Override
    public void setPoint(final Point point) {
        circles.get(index).setPoint(point);
    }


    @Override
    public boolean isFill(final int index) {
        if (checkIndex(index , circles.size()))
            return circles.get(index).isFill();
        else return super.isFill(index);
    }

    @Override
    public int getThickness(final int index) {
        if (checkIndex(index , circles.size()))
            return circles.get(index).getThickness();
        else return super.getThickness(index);
    }

    @Override
    public Color getColor(final int index) {
        if (checkIndex(index , circles.size()))
            return circles.get(index).getColor();
        else return super.getColor(index);
    }

    @Override
    public Color getBackgroundColor(final int index) {
        if (checkIndex(index , circles.size()))
            return circles.get(index).getBackgroundColor();
        else return super.getBackgroundColor(index);
    }

    @Override
    public void setFill(final int index , final boolean fill) {
        if (checkIndex(index , circles.size()))
            circles.get(index).setFill(fill);
    }

    @Override
    public void setThickness(final int index , final int thickness) {
        if (checkIndex(index , circles.size()))
            circles.get(index).setThickness(thickness);
    }

    @Override
    public void setColor(final int index , final Color color) {
        if (checkIndex(index , circles.size()))
            circles.get(index).setColor(color);
    }

    @Override
    public void setBackgroundColor(final int index , final Color color) {
        if (checkIndex(index , circles.size()))
            circles.get(index).setBackgroundColor(color);
    }

    @Override
    public Size getSize(final int index) {
        if (checkIndex(index , circles.size()))
            return circles.get(index).getSize();
        else return null;
    }

    @bardiademon
    @Override
    public void mouseReleased(final Point point) {
        index = circles.size() - 1;
    }

    @bardiademon
    @Override
    public void remove(int index) {
        if (index >= 0 && index < circles.size())
            circles.remove(index);
    }

    @bardiademon
    @Override
    public void paint(final Graphics2D g , final int index) {
        if (index >= 0 && index < circles.size()) {
            Circle circle = circles.get(index);
            whiteBoard.setWHXY(circle.getSize() , circle.getPoint());
            circle.paint(g);
        }
    }

    @bardiademon
    @Override
    public Point getPoint(final int index) {
        if (checkIndex(index , circles.size()))
            return circles.get(index).getPoint();
        else return super.getPoint(index);
    }

    @Override
    public void setPoint(final Point point , final int index) {
        circles.get(index).setPoint(point);
    }

    @Override
    public void setSize(final Size size , int index) {
        circles.get(index).setSize(size);
    }

    @bardiademon
    @Override
    public Point getAllPoint(final int index) {
        if (index >= 0 && index < circles.size())
            return circles.get(index).getAllPoint();
        else return super.getAllPoint(index);
    }

    @Override
    public void paint(final Graphics2D g , final int index , final Point point , final Size size) {
        if (checkIndex(index , circles.size())) {
            final Circle circle = circles.get(index);
            final Size tmpSize = circle.getSize();
            final Point tmpPoint = circle.getPoint();
            circle.setSize(size);
            circle.setPoint(point);
            circle.paint(g);
            circle.setSize(tmpSize);
            circle.setPoint(tmpPoint);
        }
    }

    @Override
    public String shapeName() {
        return "Circle";
    }
}
