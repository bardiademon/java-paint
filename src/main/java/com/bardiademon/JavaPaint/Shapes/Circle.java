package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

@bardiademon
public final class Circle extends Rectangle {
    @bardiademon
    private double diameter, radius, area;

    @bardiademon
    public void paint(final Graphics2D g) {
        if (getSize() != null && getPoint() != null) {
            this.apply();

            g.setStroke(new BasicStroke(getThickness()));

            if (isFill()) {
                g.setColor(getBackgroundColor());
                g.fillOval(getPoint().x , getPoint().y , getSize().width , getSize().height);
            }

            g.setColor(getColor());
            g.drawOval(getPoint().x , getPoint().y , getSize().width , getSize().height);

        }
    }

    @bardiademon
    @Override
    public void apply() {
        super.apply();
        setDiameter();
        setRadius();
        setArea();
    }

    @bardiademon
    public double getArea() {
        return area;
    }

    @bardiademon
    private void setRadius() {
        radius = Math.abs(getSize().width / 2);
    }

    @bardiademon
    private void setDiameter() {
        this.diameter = getSize().width;
    }

    @bardiademon
    public void setArea() {
        this.area = Math.abs(Math.PI * (Math.pow(radius , 2)));
    }

    @bardiademon
    public double getRadius() {
        int width = getSize().width;
        return Math.abs(width - (width / 2));
    }

    @bardiademon
    public double getDiameter() {
        return diameter;
    }
}
