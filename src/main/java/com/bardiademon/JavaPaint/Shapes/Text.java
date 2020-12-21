package com.bardiademon.JavaPaint.Shapes;

import com.bardiademon.JavaPaint.FText;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.TextTool;
import com.bardiademon.JavaPaint.bardiademon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

@bardiademon
public final class Text extends Rectangle
{
    @bardiademon
    private final TextTool textTool;

    @bardiademon
    private boolean ultimate;

    @bardiademon
    private FText fText;

    @bardiademon
    private Font font;

    @bardiademon
    private String text = null;

    @bardiademon
    private Point textPoint;

    @bardiademon
    private int textWidth;

    @bardiademon
    public Text (final TextTool textTool)
    {
        this.textTool = textTool;
    }

    @bardiademon
    public void close ()
    {
        if (fText != null) fText.dispose ();
    }

    @bardiademon
    public void afterPaint ()
    {
        fText = new FText (new FText.On ()
        {
            @Override
            public void onChangedFont (final Font _Font)
            {
                font = _Font;
                textTool.repaint ();
            }

            @Override
            public void onChangedTextColor (final Color _Color)
            {
                Text.super.setColor (_Color);
                textTool.repaint ();
            }

            @Override
            public void onChangedBackgroundColor (final Color _Color)
            {
                Text.super.setBackgroundColor (_Color);
                textTool.repaint ();
            }

            @Override
            public void onChangedText (final String Text)
            {
                text = Text;
                textTool.repaint ();
            }

            @Override
            public void onChangedPoint (final Point _Point)
            {
                textPoint = _Point;
                textTool.repaint ();
            }

            @Override
            public void onChangedArc (int value)
            {
                setArc (Shape.size (value , value));
                textTool.repaint ();
            }

            @Override
            public void onCancel ()
            {
                fText.dispose ();
                textTool.remove (textTool.getIndex ());
                textTool.repaint ();
            }

            @Override
            public void onApply ()
            {
                fText.dispose ();
                ultimate = true;
                textTool.setUltimate ();
                textTool.repaint ();
            }
        } , this);
        fText.setSlider ();
        textTool.repaint ();
    }

    public void setFont (final Font font)
    {
        this.font = font;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    @bardiademon
    @Override
    public void paint (final Graphics2D g)
    {
        if (getSize () != null && getPoint () != null)
        {
            apply ();

            g.setBackground (getBackgroundColor ());
            g.setColor (getColor ());
            g.setStroke (new BasicStroke (getThickness ()));

            if (!ultimate || (getBackgroundColor () != null) || ((getArc () != null) && getArc ().width > 0))
            {
                if (getBackgroundColor () == null)
                {
                    g.setColor (Color.BLACK);
                    g.drawRoundRect (getPoint ().x , getPoint ().y , getSize ().width , getSize ().height , getArc ().width , getArc ().height);
                }
                else
                {
                    g.setColor (getBackgroundColor ());
                    g.fillRoundRect (getPoint ().x , getPoint ().y , getSize ().width , getSize ().height , getArc ().width , getArc ().height);
                }
            }

            if (textPoint == null)
                textPoint = point (ctpFirstHalfX (2) , ctpFirstHalfY (20));

            if (text != null)
            {
                if (font != null) g.setFont (font);
                if (getColor () != null) g.setColor (getColor ());
                else g.setColor (Color.BLACK);

                textWidth = g.getFontMetrics ().stringWidth (text);

                if (textWidth > getSize ().width)
                {
                    setSize (size ((textWidth - getSize ().width + getSize ().width) , getSize ().height));
                    if (textTool != null) textTool.repaint ();
                    return;
                }

                if (fText != null) fText.setNullSlidersListener ();
                g.drawString (text , textPoint.x , textPoint.y);
                if (fText != null) fText.setMinMaxSlider ();
            }


        }
    }

    public void setUltimate (final boolean ultimate)
    {
        this.ultimate = ultimate;
    }

    public String getText ()
    {
        return text;
    }

    @bardiademon
    public int getTextWidth ()
    {
        return textWidth;
    }

    @bardiademon
    public Point getTextPoint ()
    {
        return textPoint;
    }
}
