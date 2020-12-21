package com.bardiademon.JavaPaint.DrawnShapes;

import com.bardiademon.JavaPaint.WhiteBoard.Tools.Tools;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public final class ListDrawnShapes extends JPanel
{

    private final Map <String, Tools <?>> tools;
    private final DrawnShapes.WhiteBoardRepaint whiteBoardRepaint;
    private final List <WhiteBoard.ArrangePainting> arrangePaintings;

    public ListDrawnShapes (final Map <String, Tools <?>> _Tools , final List <WhiteBoard.ArrangePainting> _ArrangePaintings , DrawnShapes.WhiteBoardRepaint _WhiteBoardRepaint)
    {
        this.arrangePaintings = _ArrangePaintings;
        this.tools = _Tools;
        whiteBoardRepaint = _WhiteBoardRepaint;
    }

    public void add ()
    {
        final BoxLayout layout = new BoxLayout (this , BoxLayout.PAGE_AXIS);
        setLayout (layout);

        for (int i = arrangePaintings.size () - 1; i >= 0; i--)
        {
            final WhiteBoard.ArrangePainting arrangePainting = arrangePaintings.get (i);
            final Tools <?> tools = getTools (arrangePainting.getSelectedTool ());
            final int index = arrangePainting.getIndex ();

            final ListItemDrawnShapes item = new ListItemDrawnShapes (i , arrangePainting , new ListItemDrawnShapes.OnChanged ()
            {
                @Override
                public void onChangedColor (final WhiteBoard.ArrangePainting arrangePainting , final Color color)
                {
                    getTools (arrangePainting.getSelectedTool ()).setColor (arrangePainting.getIndex () , color);
                    whiteBoardRepaint.repaint ();
                }

                @Override
                public void onChangedBackgroundColor (final WhiteBoard.ArrangePainting arrangePainting , final Color color)
                {
                    getTools (arrangePainting.getSelectedTool ()).setBackgroundColor (arrangePainting.getIndex () , color);
                    whiteBoardRepaint.repaint ();
                }

                @Override
                public void onChangedThickness (final WhiteBoard.ArrangePainting arrangePainting , final int thickness)
                {
                    getTools (arrangePainting.getSelectedTool ()).setThickness (arrangePainting.getIndex () , thickness);
                    whiteBoardRepaint.repaint ();
                }

                @Override
                public void onChangedFill (final WhiteBoard.ArrangePainting arrangePainting , final boolean fill)
                {
                    getTools (arrangePainting.getSelectedTool ()).setFill (arrangePainting.getIndex () , fill);
                    whiteBoardRepaint.repaint ();
                }

                @Override
                public void onChangedPoint (final WhiteBoard.ArrangePainting arrangePainting , final Point point)
                {
                    getTools (arrangePainting.getSelectedTool ()).setPoint (point , arrangePainting.getIndex ());
                    whiteBoardRepaint.repaint ();
                }

                @Override
                public void onChangedSize (final WhiteBoard.ArrangePainting arrangePainting , final Size size)
                {
                    getTools (arrangePainting.getSelectedTool ()).setSize (size , arrangePainting.getIndex ());
                    whiteBoardRepaint.repaint ();
                }
            } , tools);
            item.setShapeName (tools.shapeName ());
            item.setPoint (tools.getPoint (index));
            item.setSize (tools.getSize (index));
            item.setColor (tools.getColor (index));
            item.setBackgroundColor (tools.getBackgroundColor (index));
            item.setThickness (tools.getThickness (index));
            item.setFill (tools.isFill (index));

            add (item);

            add (Box.createRigidArea (new Dimension (0 , 2)));

        }

    }

    private Tools <?> getTools (final String key)
    {
        return (tools.get (key));
    }

}
