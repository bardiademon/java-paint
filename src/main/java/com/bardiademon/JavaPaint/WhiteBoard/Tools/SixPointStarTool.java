package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Stars.SixPointStar;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;
import com.sun.glass.ui.Size;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@bardiademon
public final class SixPointStarTool extends ShapeTool<SixPointStar> implements Tools<SixPointStar> {
    @bardiademon
    private final List<SixPointStar> sixPointStars = new ArrayList<>();

    @bardiademon
    public SixPointStarTool(final WhiteBoard whiteBoard) {
        super(whiteBoard);
    }

    @bardiademon
    @Override
    public void mouseDragged(final Point point) {
        sixPointStars.get(index).setSizeWithPoint(point);
    }

    @bardiademon
    @Override
    public void mouseDragged(final Size size) {
        sixPointStars.get(index).setSize(size);
    }

    @Override
    public void setPoint(final Point point , final int index) {
        if (index >= 0 && index < sixPointStars.size())
            sixPointStars.get(index).setPoint(point);
    }

    @Override
    public void setSize(final Size size , final int index) {
        if (index >= 0 && index < sixPointStars.size())
            sixPointStars.get(index).setSize(size);
    }

    @Override
    public Size getSize(final int index) {
        if (checkIndex(index , sixPointStars.size()))
            return sixPointStars.get(index).getSize();
        else return null;
    }

    @Override
    public boolean isFill(final int index) {
        if (checkIndex(index , sixPointStars.size()))
            return sixPointStars.get(index).isFill();
        else return super.isFill(index);
    }

    @Override
    public int getThickness(final int index) {
        if (checkIndex(index , sixPointStars.size()))
            return sixPointStars.get(index).getThickness();
        else return super.getThickness(index);
    }

    @Override
    public Color getColor(final int index) {
        if (checkIndex(index , sixPointStars.size()))
            return sixPointStars.get(index).getColor();
        else return super.getColor(index);
    }

    @Override
    public Color getBackgroundColor(final int index) {
        if (checkIndex(index , sixPointStars.size()))
            return sixPointStars.get(index).getBackgroundColor();
        else return super.getBackgroundColor(index);
    }

    @Override
    public void setFill(final int index , final boolean fill) {
        if (checkIndex(index , sixPointStars.size()))
            sixPointStars.get(index).setFill(fill);
    }

    @Override
    public void setThickness(final int index , final int thickness) {
        if (checkIndex(index , sixPointStars.size()))
            sixPointStars.get(index).setThickness(thickness);
    }

    @Override
    public void setColor(final int index , final Color color) {
        if (checkIndex(index , sixPointStars.size()))
            sixPointStars.get(index).setColor(color);
    }

    @Override
    public void setBackgroundColor(final int index , final Color color) {
        if (checkIndex(index , sixPointStars.size()))
            sixPointStars.get(index).setBackgroundColor(color);
    }

    @bardiademon
    @Override
    public void mousePressed(final Point point) {
        SixPointStar sixPointStar = new SixPointStar();
        sixPointStar.setPoint(point);
        sixPointStar.shape(setShape(sixPointStar));
        sixPointStars.add(sixPointStar);
        setIndex(sixPointStars.size() - 1);
    }

    @bardiademon
    @Override
    public void paint(final Graphics2D g , final int index) {
        if (index >= 0 && index < sixPointStars.size()) {
            SixPointStar sixPointStar = sixPointStars.get(index);
            whiteBoard.setWHXY(sixPointStar.getSize() , sixPointStar.getPoint());
            sixPointStar.paint(g);
        }
    }

    @bardiademon
    @Override
    public void setPoint(final Point point) {
        if (index >= 0 && index < sixPointStars.size())
            sixPointStars.get(index).setPoint(point);
    }

    @bardiademon
    @Override
    public void remove(final int index) {
        if (index >= 0 && index < sixPointStars.size())
            sixPointStars.remove(index);
    }

    @bardiademon
    @Override
    public Point getPoint(final int index) {
        if (index >= 0 && index < sixPointStars.size())
            return sixPointStars.get(index).getPoint();
        else return super.getPoint(index);
    }

    @bardiademon
    @Override
    public Point getAllPoint(final int index) {
        if (index >= 0 && index < sixPointStars.size())
            return sixPointStars.get(index).getAllPoint();
        else return super.getAllPoint(index);
    }
}
