package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.PaintView;
import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import javafx.scene.control.ColorPicker;

public final class ColorPickerTool extends ShapeTool <ColorPicker> implements Tools <ColorPicker>
{
    public ColorPickerTool (final WhiteBoard _WhiteBoard)
    {
        super (_WhiteBoard);
        setPaint (false);
    }

    @Override
    public void select ()
    {
        whiteBoard.setCursor ("ic_color_picker" , Shape.point (5 , 30));
    }

    @Override
    public void mousePressed (final Point point , final int button)
    {
        final PaintView paintView = whiteBoard.getPaintView ();
        final Point location = MouseInfo.getPointerInfo ().getLocation ();
        final Color colorPicker = whiteBoard.getRobot ().getPixelColor (location.x , location.y);

        if (paintView.selectedPreviousColor_BC == null && paintView.selectedPreviousColor_C == null)
        {
            if (button == 1) paintView.btnColor.setColor (colorPicker);
            if (button == 3) paintView.btnBGColor.setColor (colorPicker);
        }
        else
        {
            if (paintView.selectedPreviousColor_BC != null)
            {
                paintView.selectedPreviousColor_BC.setColor (colorPicker);
                paintView.selectedPreviousColor_BC = null;
            }

            if (paintView.selectedPreviousColor_C != null)
            {
                paintView.selectedPreviousColor_C.setColor (colorPicker);
                paintView.selectedPreviousColor_C = null;

            }
        }
    }
}
