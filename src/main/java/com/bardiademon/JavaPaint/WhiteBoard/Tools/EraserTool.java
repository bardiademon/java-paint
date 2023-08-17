package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.Shapes.Pen;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

@bardiademon
public final class EraserTool extends PenTool<Pen> implements Tools<Pen> {

    @bardiademon
    public EraserTool(final WhiteBoard whiteBoard) {
        super(whiteBoard);
        isEraser = true;
        this.whiteBoard.getPaintView().thickness.setValue(10);
    }

    @bardiademon
    @Override
    public void select() {
        final int size = 100;
        final BufferedImage read = new BufferedImage(size , size , BufferedImage.TYPE_INT_RGB);
        final Color backgroundColor = whiteBoard.getBackgroundColor();
        final Graphics2D graphics = read.createGraphics();
        graphics.setColor(backgroundColor);
        graphics.fillRect(0 , 0 , size , size);
        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(5));
        graphics.drawRect(0 , 0 , size , size);
        whiteBoard.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(read , Shape.point(15 , 15) , "eraser"));
    }
}
