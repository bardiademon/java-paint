package com.bardiademon.JavaPaint;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.Shapes.Text;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import say.swing.JFontChooser;

@bardiademon
public final class FText extends JFrame
{


    @bardiademon
    private Color color = Color.BLACK;

    @bardiademon
    private Color backgroundColor = Color.WHITE;

    @bardiademon
    private Font font;

    @bardiademon
    private final Text text;

    @bardiademon
    private final On on;

    private String strText;

    @bardiademon
    /*
      Creates new form FText
     */
    public FText (final On _On , final Text _Text)
    {
        this.on = _On;
        this.text = _Text;
        if (this.on == null) dispose ();
        else
        {
            initComponents ();
            addWindowListener (new WindowAdapter ()
            {
                @Override
                public void windowClosing (WindowEvent e)
                {
                    on.onCancel ();
                }
            });

            setLocationRelativeTo (null);
            setVisible (true);
            on ();
            if ((strText = text.getText ()) != null)
            {
                txtText.setText (strText);
                sArc.setValue (text.getArc ().width);
//                on.onChangedArc (sArc.getValue ());
                jpBackgroundColor.setBackground (text.getBackgroundColor ());
                jpTextColor.setBackground (text.getColor ());

                color = text.getColor ();
                backgroundColor = text.getBackgroundColor ();

                on.onChangedTextColor (color);
                on.onChangedBackgroundColor (backgroundColor);
            }
        }
    }

    @bardiademon
    public void setMinMaxSlider ()
    {
        sVertical.setMinimum (text.ctpY (10));
        sVertical.setMaximum (text.getAllPoint ().y);

        sHorizontal.setMinimum (text.getPoint ().x);
        sHorizontal.setMaximum (Math.abs (text.getAllPoint ().x - text.allX2 (text.getTextWidth () , text.getTextPoint ().x)));
    }

    @bardiademon
    public void setNullSlidersListener ()
    {
        sVertical.addChangeListener (null);
        sHorizontal.addChangeListener (null);
    }

    @bardiademon
    public void setSlider ()
    {
        setMinMaxSlider ();
        sVertical.addChangeListener (e ->
        {
            int newY = sVertical.getValue ();
            if (text.getTextPoint ().y < text.getPoint ().y)
                newY = text.ctpY (10);
            on.onChangedPoint (Shape.point (text.getTextPoint ().x , newY));
        });

        sHorizontal.addChangeListener (e ->
        {
            int newX = sHorizontal.getValue ();
            int allXText = text.allX (text.getTextWidth () , text.getTextPoint ().x);
            if (allXText > text.getAllPoint ().x)
                newX = (text.getTextPoint ().x - (allXText - text.getAllPoint ().x));
            else if (newX < text.getPoint ().x)
                newX = Math.abs (text.getPoint ().x - text.getTextPoint ().x) + text.getTextWidth ();

            on.onChangedPoint (Shape.point (newX , text.getTextPoint ().y));
        });
    }

    @bardiademon
    private void on ()
    {
        jpTextColor.addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mouseReleased (MouseEvent e)
            {
                if (e.getButton () == 1)
                {
                    final Color selectedColor = JColorChooser.showDialog (null , "Text color" , color);
                    if (selectedColor != null)
                    {
                        jpTextColor.setBackground (selectedColor);
                        color = selectedColor;
                        on.onChangedTextColor (color);
                    }
                }
            }
        });
        jpBackgroundColor.addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mouseReleased (MouseEvent e)
            {
                if (e.getButton () == 1)
                {
                    final Color selectedColor = JColorChooser.showDialog (null , "Background color" , backgroundColor);
                    if (selectedColor != null)
                    {
                        jpBackgroundColor.setBackground (selectedColor);
                        backgroundColor = selectedColor;
                        on.onChangedBackgroundColor (backgroundColor);
                    }
                }
            }
        });
        txtText.getDocument ().addDocumentListener (new DocumentListener ()
        {
            @Override
            public void insertUpdate (DocumentEvent e)
            {
                on.onChangedText (txtText.getText ());
            }

            @Override
            public void removeUpdate (DocumentEvent e)
            {
                on.onChangedText (txtText.getText ());
            }

            @Override
            public void changedUpdate (DocumentEvent e)
            {
                on.onChangedText (txtText.getText ());
            }
        });
        btnFont.addActionListener (e ->
        {
            JFontChooser jFontChooser = new JFontChooser ();
            jFontChooser.setFont (font);
            if (jFontChooser.showDialog (null) == JFontChooser.OK_OPTION)
            {
                font = jFontChooser.getSelectedFont ();
                on.onChangedFont (font);
                lblShowFont.setText (font.toString ()
                        .replace (font.getClass ().getName () , "")
                        .replace ("[" , "")
                        .replace ("]" , ""));
            }
        });

        btnCenterVertical.addActionListener (e -> sVertical.setValue (text.ctpY (50)));

        cLocation.addActionListener (e ->
        {
            Object selectedItem = cLocation.getSelectedItem ();
            if (selectedItem != null)
            {
                String strLocation = selectedItem.toString ();

                switch (strLocation)
                {
                    case "Left":
                        sHorizontal.setValue (text.getPoint ().x);
                        break;
                    case "Right":
                        sHorizontal.setValue (text.getAllPoint ().x);
                        break;
                    case "Up":
                        sVertical.setValue (text.getPoint ().y);
                        break;
                    case "Down":
                        sVertical.setValue (text.getAllPoint ().y);
                        break;
                    case "Center":
                        sHorizontal.setValue (Math.abs (text.ctpX (50) - (text.getTextWidth () / 2)));
                        break;
                }
            }
        });

        sArc.addChangeListener (e -> on.onChangedArc (sArc.getValue ()));

        btnCancel.addActionListener (e ->
        {
            if (strText == null) on.onCancel ();
            else FText.this.dispose ();
        });

        btnApply.addActionListener (e -> on.onApply ());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents ()
    {

        JPanel jPanel3 = new JPanel ();
        cLocation = new JComboBox <> ();
        btnCenterVertical = new JButton ();
        txtText = new JTextField ();
        jpTextColor = new JPanel ();
        jpBackgroundColor = new JPanel ();
        JLabel lblTC = new JLabel ();
        JLabel lblBC = new JLabel ();
        btnFont = new JButton ();
        lblShowFont = new JLabel ();
        btnApply = new JButton ();
        btnCancel = new JButton ();
        sHorizontal = new JSlider ();
        sVertical = new JSlider ();
        JLabel lblHS = new JLabel ();
        JLabel lblVS = new JLabel ();
        JLabel lblVS1 = new JLabel ();
        sArc = new JSlider ();
        sArc.setValue (0);

        jPanel3.setBackground (new java.awt.Color (0 , 0 , 0));
        jPanel3.setForeground (new java.awt.Color (0 , 0 , 0));

        GroupLayout jPanel3Layout = new GroupLayout (jPanel3);
        jPanel3.setLayout (jPanel3Layout);
        jPanel3Layout.setHorizontalGroup (
                jPanel3Layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                        .addGap (0 , 112 , Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup (
                jPanel3Layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                        .addGap (0 , 37 , Short.MAX_VALUE)
        );

        cLocation.setFont (new java.awt.Font ("Dialog" , Font.PLAIN , 12)); // NOI18N
        cLocation.setModel (new javax.swing.DefaultComboBoxModel <> (new String[]{ "Left" , "Right" , "Up" , "Down" , "Center" }));

        btnCenterVertical.setText ("Center Vertical");

        txtText.setFont (new java.awt.Font ("Dialog" , Font.PLAIN , 10)); // NOI18N

        jpTextColor.setBackground (new java.awt.Color (0 , 0 , 0));
        jpTextColor.setForeground (new java.awt.Color (0 , 0 , 0));
        jpTextColor.setCursor (new java.awt.Cursor (java.awt.Cursor.HAND_CURSOR));

        GroupLayout jpTextColorLayout = new GroupLayout (jpTextColor);
        jpTextColor.setLayout (jpTextColorLayout);
        jpTextColorLayout.setHorizontalGroup (
                jpTextColorLayout.createParallelGroup (GroupLayout.Alignment.LEADING)
                        .addGap (0 , 112 , Short.MAX_VALUE)
        );
        jpTextColorLayout.setVerticalGroup (
                jpTextColorLayout.createParallelGroup (GroupLayout.Alignment.LEADING)
                        .addGap (0 , 37 , Short.MAX_VALUE)
        );

        jpBackgroundColor.setBackground (new java.awt.Color (255 , 255 , 255));
        jpBackgroundColor.setForeground (new java.awt.Color (0 , 0 , 0));
        jpBackgroundColor.setCursor (new java.awt.Cursor (java.awt.Cursor.HAND_CURSOR));

        GroupLayout jpBackgroundColorLayout = new GroupLayout (jpBackgroundColor);
        jpBackgroundColor.setLayout (jpBackgroundColorLayout);
        jpBackgroundColorLayout.setHorizontalGroup (
                jpBackgroundColorLayout.createParallelGroup (GroupLayout.Alignment.LEADING)
                        .addGap (0 , 112 , Short.MAX_VALUE)
        );
        jpBackgroundColorLayout.setVerticalGroup (
                jpBackgroundColorLayout.createParallelGroup (GroupLayout.Alignment.LEADING)
                        .addGap (0 , 37 , Short.MAX_VALUE)
        );

        lblTC.setText ("Text color");

        lblBC.setText ("Background color");

        btnFont.setText ("Font");

        btnApply.setText ("Apply");

        btnCancel.setText ("Cancel");

        sHorizontal.setMaximum (0);

        sVertical.setMaximum (0);

        lblHS.setFont (new java.awt.Font ("Dialog" , Font.PLAIN , 12)); // NOI18N
        lblHS.setText ("horizontal");

        lblVS.setFont (new java.awt.Font ("Dialog" , Font.PLAIN , 12)); // NOI18N
        lblVS.setText ("Vertical");

        lblVS1.setFont (new java.awt.Font ("Dialog" , Font.PLAIN , 12)); // NOI18N
        lblVS1.setText ("Arc");

        GroupLayout layout = new GroupLayout (getContentPane ());
        getContentPane ().setLayout (layout);
        layout.setHorizontalGroup (
                layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                        .addGroup (layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                        .addGroup (layout.createSequentialGroup ()
                                                .addComponent (cLocation , GroupLayout.PREFERRED_SIZE , 100 , GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent (btnCenterVertical)
                                                .addGap (26 , 26 , 26)
                                                .addComponent (lblTC , GroupLayout.PREFERRED_SIZE , 62 , GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (jpTextColor , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE)
                                                .addGap (24 , 24 , 24)
                                                .addComponent (lblBC , GroupLayout.PREFERRED_SIZE , 112 , GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (jpBackgroundColor , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE))
                                        .addGroup (layout.createSequentialGroup ()
                                                .addComponent (btnFont)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (lblShowFont , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                        .addComponent (txtText)
                                        .addGroup (GroupLayout.Alignment.TRAILING , layout.createSequentialGroup ()
                                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                                        .addComponent (lblHS , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (lblVS , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (lblVS1 , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                                        .addGroup (layout.createSequentialGroup ()
                                                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                                                        .addComponent (sVertical , GroupLayout.PREFERRED_SIZE , 440 , GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent (sHorizontal , GroupLayout.PREFERRED_SIZE , 440 , GroupLayout.PREFERRED_SIZE))
                                                                .addGap (18 , 18 , 18)
                                                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                                                        .addComponent (btnApply , GroupLayout.PREFERRED_SIZE , 67 , GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent (btnCancel)))
                                                        .addComponent (sArc , GroupLayout.PREFERRED_SIZE , 534 , GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap ())
        );
        layout.setVerticalGroup (
                layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                        .addGroup (GroupLayout.Alignment.TRAILING , layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                        .addComponent (jpBackgroundColor , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE)
                                        .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                                .addComponent (lblTC , GroupLayout.Alignment.TRAILING , GroupLayout.PREFERRED_SIZE , 37 , GroupLayout.PREFERRED_SIZE)
                                                .addComponent (jpTextColor , GroupLayout.Alignment.TRAILING , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE)
                                                .addComponent (lblBC , GroupLayout.PREFERRED_SIZE , 37 , GroupLayout.PREFERRED_SIZE))
                                        .addGroup (GroupLayout.Alignment.TRAILING , layout.createParallelGroup (GroupLayout.Alignment.BASELINE)
                                                .addComponent (cLocation , GroupLayout.PREFERRED_SIZE , 37 , GroupLayout.PREFERRED_SIZE)
                                                .addComponent (btnCenterVertical)))
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.BASELINE)
                                        .addComponent (btnFont)
                                        .addComponent (lblShowFont , GroupLayout.PREFERRED_SIZE , 37 , GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent (txtText , GroupLayout.PREFERRED_SIZE , 61 , GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.TRAILING)
                                        .addComponent (btnApply)
                                        .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                                .addComponent (lblHS)
                                                .addComponent (sHorizontal , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                        .addComponent (sVertical , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE)
                                        .addComponent (lblVS)
                                        .addComponent (btnCancel))
                                .addGap (18 , 18 , 18)
                                .addGroup (layout.createParallelGroup (GroupLayout.Alignment.LEADING)
                                        .addComponent (sArc , GroupLayout.PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE)
                                        .addComponent (lblVS1))
                                .addContainerGap (16 , Short.MAX_VALUE))
        );

        pack ();
    }// </editor-fold>


    @bardiademon
    public interface On
    {
        void onChangedFont (final Font _Font);

        void onChangedTextColor (final Color _Color);

        void onChangedBackgroundColor (final Color _Color);

        void onChangedText (final String Text);

        void onChangedPoint (final Point _Point);

        void onChangedArc (final int value);

        void onCancel ();

        void onApply ();
    }


    @bardiademon
    // Variables declaration - do not modify
    private JButton btnApply;
    private JButton btnCancel;
    private JButton btnFont;
    private javax.swing.JComboBox <String> cLocation;
    private JButton btnCenterVertical;
    private JPanel jpBackgroundColor;
    private JPanel jpTextColor;
    private JSlider sArc;
    private JSlider sHorizontal;
    private JSlider sVertical;
    private JTextField txtText;
    private JLabel lblShowFont;
    // End of variables declaration

}
