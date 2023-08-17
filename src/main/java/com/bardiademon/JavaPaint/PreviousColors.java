package com.bardiademon.JavaPaint;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

@bardiademon
public final class PreviousColors extends JPanel {

    @bardiademon
    private boolean setColor;

    @bardiademon
    private Color color;

    @bardiademon
    private final ColorFor colorFor;

    @bardiademon
    public PreviousColors(final ColorFor colorFor) {
        this.colorFor = colorFor;

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void setPreviousColor(PaintView.PreviousColor previousColor) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                previousColor.onClick(color);
            }
        });
    }

    @bardiademon
    public void setColor(final Color color) {
        setColor = true;
        this.color = color;
        setBackground(color);
    }

    @bardiademon
    public Color getColor() {
        return color;
    }

    @bardiademon
    public ColorFor getColorFor() {
        return colorFor;
    }

    @bardiademon
    public enum ColorFor {
        color, bgcolor
    }

    @bardiademon
    public boolean isSetColor() {
        return setColor;
    }
}
