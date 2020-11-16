package com.bardiademon.JavaPaint.WhiteBoard.Tools;

import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Cursor;

public class ShapeTool
{
    protected ShapeTool (final WhiteBoard _WhiteBoard)
    {
        setCursor (_WhiteBoard);
    }

    protected void setCursor (final WhiteBoard whiteBoard)
    {
        whiteBoard.setCursor (Cursor.getPredefinedCursor (Cursor.CROSSHAIR_CURSOR));
    }
}
