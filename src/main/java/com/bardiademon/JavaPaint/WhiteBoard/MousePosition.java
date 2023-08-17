package com.bardiademon.JavaPaint.WhiteBoard;

import com.bardiademon.JavaPaint.Shapes.Rectangle;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.Shapes.Text;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import javax.swing.JLabel;

public final class MousePosition extends JLabel {

    private final Robot robot;

    private Text text;

    private Rectangle rectangle;

    private boolean fromText;
    private Color color;

    public MousePosition(final Robot robot) {
        super("X = 0 , Y = 0");
        this.robot = robot;
    }

    public void setPoint(final Point point) {
        new Thread(() ->
        {
            if (text == null) setText();
            text.setText(String.format("X = %d , Y = %d" , point.x , point.y));
            repaint();
        }).start();
    }

    public void text(final String text , final Color color) {
        new Thread(() ->
        {
            if (text == null) setText();
            this.text.setText(text);
            this.color = color;
            fromText = true;
            repaint();
        }).start();
    }

    public void setText() {
        text = new Text(null);
        text.setText(getText());
        text.setSize(Shape.size(getWidth() , getHeight()));
        text.setUltimate(true);
        text.setPoint(Shape.point(0 , 0));
        text.setFont(new Font(Font.SANS_SERIF , Font.PLAIN , 12));
        text.apply();
        text.setPoint(Shape.point(text.ctpX(5) , text.ctpY(50)));
        setBackground(Color.BLACK);

        rectangle = new Rectangle();
        rectangle.setPoint(Shape.point(0 , 0));
        rectangle.setSize(Shape.size(getWidth() , getHeight()));
        rectangle.setThickness(5);
    }

    @Override
    public void paint(final Graphics g) {
        if (text != null) {
            final Point location = MouseInfo.getPointerInfo().getLocation();

            if (!fromText)
                rectangle.setColor(robot.getPixelColor(location.x , location.y));
            else {
                fromText = false;
                rectangle.setColor(color);
            }

            final Graphics2D g2 = (Graphics2D) g;
            text.paint(g2);
            rectangle.paint(g2);
        }
    }
}
