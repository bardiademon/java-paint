package com.bardiademon.JavaPaint.DrawnShapes;

import com.bardiademon.JavaPaint.Shapes.Shape;
import com.bardiademon.JavaPaint.Shapes.Text;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.Tools;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import com.sun.glass.ui.Size;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ListItemDrawnShapes extends JPanel
{

    private final WhiteBoard.ArrangePainting arrangePainting;
    private final OnChanged onChanged;

    private Color color;
    private Color bgColor;

    private int x = 0, y = 0, width = 0, height = 0;
    private int thickness = 0;

    public ListItemDrawnShapes (final int i , final WhiteBoard.ArrangePainting _ArrangePainting , final OnChanged _OnChanged , Tools <?> tools)
    {
        this.arrangePainting = _ArrangePainting;
        this.onChanged = _OnChanged;
        initComponents ();
        pnlColor.setCursor (Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));
        pnlBgColor.setCursor (Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));

        if (i % 2 == 0)
        {
            final Color colorD7D7D5 = Color.decode ("#D7D7D5");
            setBackground (colorD7D7D5);
            chkFill.setBackground (colorD7D7D5);
        }

        chkFill.addChangeListener (e -> onChanged.onChangedFill (arrangePainting , chkFill.isSelected ()));
        txtHeight.getDocument ().addDocumentListener (new DocumentListener ()
        {
            @Override
            public void insertUpdate (DocumentEvent e)
            {
                onChangeSize ();
            }

            @Override
            public void removeUpdate (DocumentEvent e)
            {
                onChangeSize ();
            }

            @Override
            public void changedUpdate (DocumentEvent e)
            {
                onChangeSize ();
            }
        });
        txtWidth.getDocument ().addDocumentListener (new DocumentListener ()
        {
            @Override
            public void insertUpdate (DocumentEvent e)
            {
                onChangeSize ();
            }

            @Override
            public void removeUpdate (DocumentEvent e)
            {
                onChangeSize ();
            }

            @Override
            public void changedUpdate (DocumentEvent e)
            {
                onChangeSize ();
            }
        });
        txtX.getDocument ().addDocumentListener (new DocumentListener ()
        {
            @Override
            public void insertUpdate (DocumentEvent e)
            {
                onChangePoint ();
            }

            @Override
            public void removeUpdate (DocumentEvent e)
            {
                onChangePoint ();
            }

            @Override
            public void changedUpdate (DocumentEvent e)
            {
                onChangePoint ();
            }
        });
        txtY.getDocument ().addDocumentListener (new DocumentListener ()
        {
            @Override
            public void insertUpdate (DocumentEvent e)
            {
                onChangePoint ();
            }

            @Override
            public void removeUpdate (DocumentEvent e)
            {
                onChangePoint ();
            }

            @Override
            public void changedUpdate (DocumentEvent e)
            {
                onChangePoint ();
            }
        });
        txtThickness.getDocument ().addDocumentListener (new DocumentListener ()
        {
            @Override
            public void insertUpdate (DocumentEvent e)
            {
                onChangeThickness ();
            }

            @Override
            public void removeUpdate (DocumentEvent e)
            {
                onChangeThickness ();
            }

            @Override
            public void changedUpdate (DocumentEvent e)
            {
                onChangeThickness ();
            }
        });

        pnlColor.addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                final Color color;
                if ((color = JColorChooser.showDialog (null , "Color" , ListItemDrawnShapes.this.color)) != null)
                {
                    ListItemDrawnShapes.this.color = color;
                    onChanged.onChangedColor (arrangePainting , color);
                    pnlColor.setBackground (color);
                }
            }
        });
        pnlBgColor.addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mouseClicked (MouseEvent e)
            {
                final Color color;
                if ((color = JColorChooser.showDialog (null , "Color" , bgColor)) != null)
                {
                    bgColor = color;
                    onChanged.onChangedBackgroundColor (arrangePainting , color);
                    pnlBgColor.setBackground (color);
                }
            }
        });

        if (arrangePainting.getSelectedTool ().equals (SelectedTool.text.name ()))
        {
            pnlColor.setEnabled (false);
            pnlBgColor.setEnabled (false);
            chkFill.setEnabled (false);
            txtHeight.setEnabled (false);
            txtWidth.setEnabled (false);
            txtX.setEnabled (false);
            txtY.setEnabled (false);
            txtThickness.setEnabled (false);

            Tools <Text> textTools = (Tools <Text>) tools;
            Text shape = textTools.getShape (arrangePainting.getIndex ());
            addMouseListener (new MouseAdapter ()
            {
                @Override
                public void mouseClicked (MouseEvent e)
                {
                    shape.afterPaint ();
                }
            });

        }

    }

    private void onChangeSize ()
    {
        String strW = txtWidth.getText ();
        String strH = txtHeight.getText ();

        if (strW != null && !strW.equals (""))
        {
            try
            {
                width = Integer.parseInt (strW);
            }
            catch (Exception ignored)
            {
            }
        }
        if (strH != null && !strH.equals (""))
        {
            try
            {
                height = Integer.parseInt (strH);
            }
            catch (Exception ignored)
            {
            }
        }
        onChanged.onChangedSize (arrangePainting , Shape.size (width , height));
    }

    private void onChangeThickness ()
    {
        String strT = txtThickness.getText ();

        if (strT != null && !strT.equals (""))
        {
            try
            {
                thickness = Integer.parseInt (strT);
            }
            catch (Exception ignored)
            {
            }
        }

        onChanged.onChangedThickness (arrangePainting , thickness);
    }

    private void onChangePoint ()
    {
        String strX = txtX.getText ();
        String strY = txtY.getText ();

        if (strX != null && !strX.equals (""))
        {
            try
            {
                x = Integer.parseInt (strX);
            }
            catch (Exception ignored)
            {
            }
        }
        if (strY != null && !strY.equals (""))
        {
            try
            {
                y = Integer.parseInt (strY);
            }
            catch (Exception ignored)
            {
            }
        }

        onChanged.onChangedPoint (arrangePainting , Shape.point (x , y));
    }

    public void setShapeName (final String name)
    {
        lblShapeName.setText (name);
    }

    public void setPoint (final Point point)
    {
        if (point != null)
        {
            x = point.x;
            y = point.y;
            txtX.setText (String.valueOf (point.x));
            txtY.setText (String.valueOf (point.y));
        }
    }

    public void setSize (final Size size)
    {
        if (size != null)
        {
            width = size.width;
            height = size.height;
            txtWidth.setText (String.valueOf (size.width));
            txtHeight.setText (String.valueOf (size.height));
        }
    }

    public void setThickness (final int thickness)
    {
        this.thickness = thickness;
        txtThickness.setText (String.valueOf (thickness));
    }

    public void setFill (final boolean fill)
    {
        chkFill.setSelected (fill);
    }

    public void setColor (final Color color)
    {
        pnlColor.setBackground (color);
    }

    public void setBackgroundColor (final Color color)
    {
        pnlBgColor.setBackground (color);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents ()
    {

        jCheckBox1 = new JCheckBox ();
        shape = new JPanel ();
        lblShapeName = new JLabel ();
        lblX = new JLabel ();
        txtX = new JTextField ();
        txtY = new JTextField ();
        lblY = new JLabel ();
        txtWidth = new JTextField ();
        lblHeight = new JLabel ();
        txtHeight = new JTextField ();
        lblWidth = new JLabel ();
        lblThickness = new JLabel ();
        txtThickness = new JTextField ();
        pnlColor = new PnlColor ("Color");
        pnlBgColor = new PnlColor ("Bg color");
        chkFill = new JCheckBox ();

        jCheckBox1.setText ("fill");

        shape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout shapeLayout = new javax.swing.GroupLayout (shape);
        shape.setLayout (shapeLayout);
        shapeLayout.setHorizontalGroup (
                shapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 100 , Short.MAX_VALUE)
        );
        shapeLayout.setVerticalGroup (
                shapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 46 , Short.MAX_VALUE)
        );

        lblShapeName.setFont (new java.awt.Font ("Dialog" , 0 , 18)); // NOI18N
        lblShapeName.setText ("Shape name");

        lblX.setFont (new java.awt.Font ("Dialog" , 0 , 18)); // NOI18N
        lblX.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        lblX.setText ("x");

        lblY.setFont (new java.awt.Font ("Dialog" , 0 , 14)); // NOI18N
        lblY.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        lblY.setText ("Y");

        lblHeight.setFont (new java.awt.Font ("Dialog" , 0 , 14)); // NOI18N
        lblHeight.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        lblHeight.setText ("Height");

        lblWidth.setFont (new java.awt.Font ("Dialog" , 0 , 14)); // NOI18N
        lblWidth.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        lblWidth.setText ("Width");

        lblThickness.setFont (new java.awt.Font ("Dialog" , 0 , 14)); // NOI18N
        lblThickness.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        lblThickness.setText ("Thickness");

        pnlColor.setBackground (new java.awt.Color (255 , 255 , 255));
        pnlColor.setPreferredSize (new java.awt.Dimension (35 , 35));

        javax.swing.GroupLayout pnlColorLayout = new javax.swing.GroupLayout (pnlColor);
        pnlColor.setLayout (pnlColorLayout);
        pnlColorLayout.setHorizontalGroup (
                pnlColorLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 35 , Short.MAX_VALUE)
        );
        pnlColorLayout.setVerticalGroup (
                pnlColorLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 35 , Short.MAX_VALUE)
        );

        pnlBgColor.setBackground (new java.awt.Color (255 , 255 , 255));
        pnlBgColor.setPreferredSize (new java.awt.Dimension (35 , 35));

        javax.swing.GroupLayout pnlBgColorLayout = new javax.swing.GroupLayout (pnlBgColor);
        pnlBgColor.setLayout (pnlBgColorLayout);
        pnlBgColorLayout.setHorizontalGroup (
                pnlBgColorLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 35 , Short.MAX_VALUE)
        );
        pnlBgColorLayout.setVerticalGroup (
                pnlBgColorLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 35 , Short.MAX_VALUE)
        );

        chkFill.setFont (new java.awt.Font ("Dialog" , 0 , 12)); // NOI18N
        chkFill.setText ("Fill");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout (this);
        this.setLayout (layout);
        layout.setHorizontalGroup (
                layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent (lblY , javax.swing.GroupLayout.PREFERRED_SIZE , 23 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup (layout.createSequentialGroup ()
                                                .addComponent (lblWidth)
                                                .addGap (3 , 3 , 3)
                                                .addComponent (txtWidth , javax.swing.GroupLayout.PREFERRED_SIZE , 65 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap (3 , 3 , 3)
                                                .addComponent (lblHeight , javax.swing.GroupLayout.PREFERRED_SIZE , 60 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (txtHeight , javax.swing.GroupLayout.PREFERRED_SIZE , 66 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent (chkFill))
                                        .addComponent (shape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup (layout.createSequentialGroup ()
                                                .addComponent (lblX , javax.swing.GroupLayout.PREFERRED_SIZE , 23 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap (2 , 2 , 2)
                                                .addComponent (txtX , javax.swing.GroupLayout.PREFERRED_SIZE , 65 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup (layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup (layout.createSequentialGroup ()
                                                                .addComponent (lblShapeName)
                                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent (pnlColor , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent (pnlBgColor , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup (layout.createSequentialGroup ()
                                                                .addGap (7 , 7 , 7)
                                                                .addComponent (txtY , javax.swing.GroupLayout.PREFERRED_SIZE , 66 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent (lblThickness)
                                                                .addGap (2 , 2 , 2)
                                                                .addComponent (txtThickness , javax.swing.GroupLayout.PREFERRED_SIZE , 40 , javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap (javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );
        layout.setVerticalGroup (
                layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (layout.createSequentialGroup ()
                                .addGap (10 , 10 , 10)
                                .addGroup (layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup (layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING , false)
                                                .addComponent (pnlBgColor , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (pnlColor , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (lblShapeName , javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent (shape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap (18 , 18 , 18)
                                .addGroup (layout.createParallelGroup (javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent (lblX)
                                        .addComponent (txtX , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent (lblY)
                                        .addComponent (txtY , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent (lblThickness)
                                        .addComponent (txtThickness , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup (layout.createParallelGroup (javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent (lblWidth)
                                        .addComponent (txtHeight , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent (txtWidth , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent (lblHeight)
                                        .addComponent (chkFill))
                                .addContainerGap (javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );
    }// </editor-fold>

    public interface OnChanged
    {
        void onChangedColor (final WhiteBoard.ArrangePainting arrangePainting , final Color color);

        void onChangedBackgroundColor (final WhiteBoard.ArrangePainting arrangePainting , final Color color);

        void onChangedThickness (final WhiteBoard.ArrangePainting arrangePainting , final int thickness);

        void onChangedFill (final WhiteBoard.ArrangePainting arrangePainting , final boolean fill);

        void onChangedPoint (final WhiteBoard.ArrangePainting arrangePainting , final Point point);

        void onChangedSize (final WhiteBoard.ArrangePainting arrangePainting , final Size size);
    }

    // Variables declaration - do not modify
    private JCheckBox chkFill;
    private JCheckBox jCheckBox1;
    private JLabel lblHeight;
    private JLabel lblShapeName;
    private JLabel lblThickness;
    private JLabel lblWidth;
    private JLabel lblX;
    private JLabel lblY;
    private PnlColor pnlBgColor;
    private PnlColor pnlColor;
    private JPanel shape;
    private JTextField txtHeight;
    private JTextField txtThickness;
    private JTextField txtWidth;
    private JTextField txtX;
    private JTextField txtY;
    // End of variables declaration
}
