package com.bardiademon.JavaPaint;

import com.bardiademon.JavaPaint.Shapes.BackgroundPaint;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.PREFERRED_SIZE;

@bardiademon
public final class PaintView extends JFrame
{

    // C => Color
    public PreviousColors selectedPreviousColor_C;

    // BC => Background Color
    public PreviousColors selectedPreviousColor_BC;

    @bardiademon
    public static final BackgroundPaint BACKGROUND_PAINT = new BackgroundPaint ();

    public interface PreviousColor
    {
        void onClick (Color color);
    }

    @bardiademon
    public PaintView ()
    {
        initComponents ();
        setVisible (true);

        txtThickness.getDocument ().addDocumentListener (new DocumentListener ()
        {
            @Override
            public void insertUpdate (DocumentEvent e)
            {
                onChangeTxtThickness ();
            }

            @Override
            public void removeUpdate (DocumentEvent e)
            {
                onChangeTxtThickness ();
            }

            @Override
            public void changedUpdate (DocumentEvent e)
            {
                onChangeTxtThickness ();
            }
        });

        setLocationRelativeTo (null);

        setOnClick ();
    }

    private void onChangeTxtThickness ()
    {
        final String valTxtThickness = txtThickness.getText ();
        if (valTxtThickness != null && !valTxtThickness.equals (""))
        {
            try
            {
                if (valTxtThickness.matches ("[0-9]*"))
                {
                    int valThickness = Integer.parseInt (valTxtThickness);
                    if (valThickness <= thickness.getMaximum () && valThickness >= thickness.getMinimum ())
                        thickness.setValue (valThickness);
                    else
                        throw new Exception ();
                }
                else
                    throw new Exception ();
            }
            catch (Exception e)
            {
                SwingUtilities.invokeLater (() -> txtThickness.setText (String.valueOf (thickness.getValue ())));
            }
        }
    }

    @bardiademon
    private void setOnClick ()
    {

    }

    @bardiademon
    public void setCursorPoint (Point cursorPoint)
    {
        lblCursorPoint.setText (String.format ("X = %d , Y = %d" , cursorPoint.x , cursorPoint.y));
    }

    public PreviousColor getPreviousColor (final PreviousColors previousColor)
    {
        return color ->
        {

            if (previousColor.getColorFor ().equals (PreviousColors.ColorFor.bgcolor))
            {
                selectedPreviousColor_BC = previousColor;
                if (previousColor.isSetColor ())
                {
                    btnBGColor.setBackground (color);
                    WhiteBoard.SetBackgroundColor (color);
                }
            }
            else
            {
                selectedPreviousColor_C = previousColor;

                if (previousColor.isSetColor ())
                {
                    btnColor.setBackground (color);
                    WhiteBoard.SetColor (color);
                }

            }
        };
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents ()
    {
        jRadioButton1 = new JRadioButton ();
        jPanel1 = new JPanel ();
        jPanel4 = new JPanel ();
        circleShape = new BtnPanel (SelectedTool.circle);
        squareShape = new BtnPanel (SelectedTool.square);
        roundRectShape = new BtnPanel (SelectedTool.round_rect);
        polygonShape = new BtnPanel (SelectedTool.polygon);
        triangleShape = new BtnPanel (SelectedTool.triangle);
        rightArrowShape = new BtnPanel (SelectedTool.right_arrow);
        hexagonShape = new BtnPanel (SelectedTool.hexagon);
        pentagonShape = new BtnPanel (SelectedTool.pentagon);
        diamondShape = new BtnPanel (SelectedTool.diamond);
        rightTriangleShape = new BtnPanel (SelectedTool.right_triangle);
        leftArrowShape = new BtnPanel (SelectedTool.left_arrow);
        upArrowShape = new BtnPanel (SelectedTool.up_arrow);
        downArrowShape = new BtnPanel (SelectedTool.down_arrow);
        fourPointStarShape = new BtnPanel (SelectedTool.four_point_star);
        fivePointStarShape = new BtnPanel (SelectedTool.five_point_star);
        sixPointStarShape = new BtnPanel (SelectedTool.six_point_star);
        roundedRectangleCalloutShape = new BtnPanel (SelectedTool.rounded_rectangle_callout);
        ovalCalloutShape = new BtnPanel (SelectedTool.oval_callout);
        cloudCalloutShape = new BtnPanel (SelectedTool.cloud_callout);
        heartShape = new BtnPanel (SelectedTool.heart);
        lightningShape = new BtnPanel (SelectedTool.lightning);
        line = new BtnPanel (SelectedTool.line);
        jPanel3 = new JPanel ();
        pen = new BtnPanel (SelectedTool.pen);
        bucketOfPaint = new BtnPanel (SelectedTool.bucket_of_paint);
        eraser = new BtnPanel (SelectedTool.eraser);
        colorPicker = new BtnPanel (SelectedTool.color_picker);
        text = new BtnPanel (SelectedTool.text);
        isFill = new JCheckBox ();
        thickness = new JSlider ();
        jLabel1 = new JLabel ();
        rectShape = new BtnPanel (SelectedTool.rect);

        txtX = new JTextField ();
        lX = new JLabel ();
        txtY = new JTextField ();
        lY = new JLabel ();
        txtHeight = new JTextField ();
        txtWidth = new JTextField ();
        lWidth = new JLabel ();
        lHeight = new JLabel ();
        pWHXY = new JPanel ();

        lblCursorPoint = new JLabel ("X = 0 , Y = 0");

        jLabel2 = new javax.swing.JLabel ();
        jLabel3 = new javax.swing.JLabel ();
        color1 = new PreviousColors (PreviousColors.ColorFor.color);
        color1.setPreviousColor (getPreviousColor (color1));

        color2 = new PreviousColors (PreviousColors.ColorFor.color);
        color2.setPreviousColor (getPreviousColor (color2));

        color3 = new PreviousColors (PreviousColors.ColorFor.color);
        color3.setPreviousColor (getPreviousColor (color3));

        color4 = new PreviousColors (PreviousColors.ColorFor.color);
        color4.setPreviousColor (getPreviousColor (color4));

        bgcolor3 = new PreviousColors (PreviousColors.ColorFor.bgcolor);
        bgcolor3.setPreviousColor (getPreviousColor (bgcolor3));

        bgcolor4 = new PreviousColors (PreviousColors.ColorFor.bgcolor);
        bgcolor4.setPreviousColor (getPreviousColor (bgcolor4));

        bgcolor2 = new PreviousColors (PreviousColors.ColorFor.bgcolor);
        bgcolor2.setPreviousColor (getPreviousColor (bgcolor2));

        bgcolor1 = new PreviousColors (PreviousColors.ColorFor.bgcolor);
        bgcolor1.setPreviousColor (getPreviousColor (bgcolor1));

        txtThickness = new javax.swing.JTextField ();

        whiteBoard = new WhiteBoard (this);
        whiteBoard.setOpaque (true);
        whiteBoard.setBackground (Color.WHITE);

        btnBGColor = new BtnColor (_Color ->
        {
            WhiteBoard.SetBackgroundColor (_Color);
            if (selectedPreviousColor_BC != null)
            {
                selectedPreviousColor_BC.setColor (_Color);
                selectedPreviousColor_BC = null;
            }
        });
        btnColor = new BtnColor (_Color ->
        {
            WhiteBoard.SetColor (_Color);
            if (selectedPreviousColor_C != null)
            {
                selectedPreviousColor_C.setColor (_Color);
                selectedPreviousColor_C = null;
            }

        });

        image = new BtnPanel (whiteBoard , SelectedTool.image);

        jRadioButton1.setText ("jRadioButton1");

        btnColor.setBackground (Color.BLACK);
        btnColor.setCursor (Cursor.getPredefinedCursor (Cursor.HAND_CURSOR));

        setDefaultCloseOperation (javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground (new java.awt.Color (204 , 204 , 204));

        jPanel1.setBackground (new java.awt.Color (204 , 204 , 204));
        jPanel1.setForeground (new java.awt.Color (204 , 204 , 204));

        jPanel4.setBackground (new java.awt.Color (204 , 204 , 204));

        circleShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout circleShapeLayout = new GroupLayout (circleShape);
        circleShape.setLayout (circleShapeLayout);
        circleShapeLayout.setHorizontalGroup (
                circleShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        circleShapeLayout.setVerticalGroup (
                circleShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        squareShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout squareShapeLayout = new GroupLayout (squareShape);
        squareShape.setLayout (squareShapeLayout);
        squareShapeLayout.setHorizontalGroup (
                squareShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        squareShapeLayout.setVerticalGroup (
                squareShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        roundRectShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout roundRectShapeLayout = new GroupLayout (roundRectShape);
        roundRectShape.setLayout (roundRectShapeLayout);
        roundRectShapeLayout.setHorizontalGroup (
                roundRectShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        roundRectShapeLayout.setVerticalGroup (
                roundRectShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        polygonShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout polygonShapeLayout = new GroupLayout (polygonShape);
        polygonShape.setLayout (polygonShapeLayout);
        polygonShapeLayout.setHorizontalGroup (
                polygonShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        polygonShapeLayout.setVerticalGroup (
                polygonShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        triangleShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout triangleShapeLayout = new GroupLayout (triangleShape);
        triangleShape.setLayout (triangleShapeLayout);
        triangleShapeLayout.setHorizontalGroup (
                triangleShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        triangleShapeLayout.setVerticalGroup (
                triangleShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        rightArrowShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout rightArrowShapeLayout = new GroupLayout (rightArrowShape);
        rightArrowShape.setLayout (rightArrowShapeLayout);
        rightArrowShapeLayout.setHorizontalGroup (
                rightArrowShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        rightArrowShapeLayout.setVerticalGroup (
                rightArrowShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 29 , Short.MAX_VALUE)
        );

        hexagonShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout hexagonShapeLayout = new GroupLayout (hexagonShape);
        hexagonShape.setLayout (hexagonShapeLayout);
        hexagonShapeLayout.setHorizontalGroup (
                hexagonShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        hexagonShapeLayout.setVerticalGroup (
                hexagonShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        pentagonShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout pentagonShapeLayout = new GroupLayout (pentagonShape);
        pentagonShape.setLayout (pentagonShapeLayout);
        pentagonShapeLayout.setHorizontalGroup (
                pentagonShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        pentagonShapeLayout.setVerticalGroup (
                pentagonShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        diamondShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout diamondShapeLayout = new GroupLayout (diamondShape);
        diamondShape.setLayout (diamondShapeLayout);
        diamondShapeLayout.setHorizontalGroup (
                diamondShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        diamondShapeLayout.setVerticalGroup (
                diamondShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        rightTriangleShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout rightTriangleShapeLayout = new GroupLayout (rightTriangleShape);
        rightTriangleShape.setLayout (rightTriangleShapeLayout);
        rightTriangleShapeLayout.setHorizontalGroup (
                rightTriangleShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        rightTriangleShapeLayout.setVerticalGroup (
                rightTriangleShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        leftArrowShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout leftArrowShapeLayout = new GroupLayout (leftArrowShape);
        leftArrowShape.setLayout (leftArrowShapeLayout);
        leftArrowShapeLayout.setHorizontalGroup (
                leftArrowShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        leftArrowShapeLayout.setVerticalGroup (
                leftArrowShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 29 , Short.MAX_VALUE)
        );

        upArrowShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout upArrowShapeLayout = new GroupLayout (upArrowShape);
        upArrowShape.setLayout (upArrowShapeLayout);
        upArrowShapeLayout.setHorizontalGroup (
                upArrowShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        upArrowShapeLayout.setVerticalGroup (
                upArrowShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        downArrowShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout downArrowShapeLayout = new GroupLayout (downArrowShape);
        downArrowShape.setLayout (downArrowShapeLayout);
        downArrowShapeLayout.setHorizontalGroup (
                downArrowShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        downArrowShapeLayout.setVerticalGroup (
                downArrowShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        fourPointStarShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout fourPointStarShapeLayout = new GroupLayout (fourPointStarShape);
        fourPointStarShape.setLayout (fourPointStarShapeLayout);
        fourPointStarShapeLayout.setHorizontalGroup (
                fourPointStarShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        fourPointStarShapeLayout.setVerticalGroup (
                fourPointStarShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        fivePointStarShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout fivePointStarShapeLayout = new GroupLayout (fivePointStarShape);
        fivePointStarShape.setLayout (fivePointStarShapeLayout);
        fivePointStarShapeLayout.setHorizontalGroup (
                fivePointStarShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        fivePointStarShapeLayout.setVerticalGroup (
                fivePointStarShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        sixPointStarShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout sixPointStarShapeLayout = new GroupLayout (sixPointStarShape);
        sixPointStarShape.setLayout (sixPointStarShapeLayout);
        sixPointStarShapeLayout.setHorizontalGroup (
                sixPointStarShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        sixPointStarShapeLayout.setVerticalGroup (
                sixPointStarShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 29 , Short.MAX_VALUE)
        );

        roundedRectangleCalloutShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout roundedRectangleCalloutShapeLayout = new GroupLayout (roundedRectangleCalloutShape);
        roundedRectangleCalloutShape.setLayout (roundedRectangleCalloutShapeLayout);
        roundedRectangleCalloutShapeLayout.setHorizontalGroup (
                roundedRectangleCalloutShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        roundedRectangleCalloutShapeLayout.setVerticalGroup (
                roundedRectangleCalloutShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        ovalCalloutShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout ovalCalloutShapeLayout = new GroupLayout (ovalCalloutShape);
        ovalCalloutShape.setLayout (ovalCalloutShapeLayout);
        ovalCalloutShapeLayout.setHorizontalGroup (
                ovalCalloutShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        ovalCalloutShapeLayout.setVerticalGroup (
                ovalCalloutShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        cloudCalloutShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout cloudCalloutShapeLayout = new GroupLayout (cloudCalloutShape);
        cloudCalloutShape.setLayout (cloudCalloutShapeLayout);
        cloudCalloutShapeLayout.setHorizontalGroup (
                cloudCalloutShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        cloudCalloutShapeLayout.setVerticalGroup (
                cloudCalloutShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        heartShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout heartShapeLayout = new GroupLayout (heartShape);
        heartShape.setLayout (heartShapeLayout);
        heartShapeLayout.setHorizontalGroup (
                heartShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        heartShapeLayout.setVerticalGroup (
                heartShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        lightningShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout lightningShapeLayout = new GroupLayout (lightningShape);
        lightningShape.setLayout (lightningShapeLayout);
        lightningShapeLayout.setHorizontalGroup (
                lightningShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        lightningShapeLayout.setVerticalGroup (
                lightningShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        line.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout lineLayout = new GroupLayout (line);
        line.setLayout (lineLayout);
        lineLayout.setHorizontalGroup (
                lineLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        lineLayout.setVerticalGroup (
                lineLayout.createParallelGroup (LEADING)
                        .addGap (0 , 29 , Short.MAX_VALUE)
        );

        rectShape.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout rectShapeLayout = new GroupLayout (rectShape);
        rectShape.setLayout (rectShapeLayout);
        rectShapeLayout.setHorizontalGroup (
                rectShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        rectShapeLayout.setVerticalGroup (
                rectShapeLayout.createParallelGroup (LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        isFill.setBackground (new java.awt.Color (204 , 204 , 204));
        isFill.setFont (new java.awt.Font ("Dubai" , 0 , 14)); // NOI18N
        isFill.setForeground (new java.awt.Color (0 , 0 , 0));
        isFill.setText ("Fill");

        GroupLayout jPanel4Layout = new GroupLayout (jPanel4);
        jPanel4.setLayout (jPanel4Layout);
        jPanel4Layout.setHorizontalGroup (
                jPanel4Layout.createParallelGroup (LEADING)
                        .addGroup (jPanel4Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel4Layout.createParallelGroup (LEADING)
                                        .addGroup (jPanel4Layout.createSequentialGroup ()
                                                .addComponent (circleShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (squareShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (rectShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (roundRectShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (triangleShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (polygonShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (rightTriangleShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (diamondShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (pentagonShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (hexagonShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (rightArrowShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (lightningShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE))
                                        .addGroup (jPanel4Layout.createSequentialGroup ()
                                                .addComponent (leftArrowShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (upArrowShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (downArrowShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (fourPointStarShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (fivePointStarShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (sixPointStarShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (roundedRectangleCalloutShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (ovalCalloutShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (cloudCalloutShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (heartShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (line , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent (isFill)))
                                .addContainerGap (12 , Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup (
                jPanel4Layout.createParallelGroup (LEADING)
                        .addGroup (jPanel4Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel4Layout.createParallelGroup (LEADING , false)
                                        .addComponent (rightArrowShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (hexagonShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (pentagonShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (diamondShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (rightTriangleShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (lightningShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (polygonShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (triangleShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (roundRectShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (squareShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (circleShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (rectShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                .addGap (18 , 18 , 18)
                                .addGroup (jPanel4Layout.createParallelGroup (Alignment.TRAILING)
                                        .addGroup (jPanel4Layout.createParallelGroup (LEADING)
                                                .addGroup (jPanel4Layout.createParallelGroup (LEADING , false)
                                                        .addComponent (heartShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (cloudCalloutShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (ovalCalloutShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (roundedRectangleCalloutShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (sixPointStarShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                        .addComponent (line , Alignment.TRAILING , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE))
                                                .addGroup (jPanel4Layout.createParallelGroup (LEADING , false)
                                                        .addComponent (fivePointStarShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (fourPointStarShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (downArrowShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (upArrowShape , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (leftArrowShape , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)))
                                        .addComponent (isFill))
                                .addContainerGap (GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );

        jPanel3.setBackground (new java.awt.Color (204 , 204 , 204));

        pen.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout penLayout = new GroupLayout (pen);
        pen.setLayout (penLayout);
        penLayout.setHorizontalGroup (
                penLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        penLayout.setVerticalGroup (
                penLayout.createParallelGroup (LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        bucketOfPaint.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout bucketOfPaintLayout = new GroupLayout (bucketOfPaint);
        bucketOfPaint.setLayout (bucketOfPaintLayout);
        bucketOfPaintLayout.setHorizontalGroup (
                bucketOfPaintLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        bucketOfPaintLayout.setVerticalGroup (
                bucketOfPaintLayout.createParallelGroup (LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        eraser.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout eraserLayout = new GroupLayout (eraser);
        eraser.setLayout (eraserLayout);
        eraserLayout.setHorizontalGroup (
                eraserLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        eraserLayout.setVerticalGroup (
                eraserLayout.createParallelGroup (LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        colorPicker.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout colorPickerLayout = new GroupLayout (colorPicker);
        colorPicker.setLayout (colorPickerLayout);
        colorPickerLayout.setHorizontalGroup (
                colorPickerLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        colorPickerLayout.setVerticalGroup (
                colorPickerLayout.createParallelGroup (LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        text.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout textLayout = new GroupLayout (text);
        text.setLayout (textLayout);
        textLayout.setHorizontalGroup (
                textLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        textLayout.setVerticalGroup (
                textLayout.createParallelGroup (LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        image.setBackground (new java.awt.Color (255 , 255 , 255));

        GroupLayout imageLayout = new GroupLayout (image);
        image.setLayout (imageLayout);
        imageLayout.setHorizontalGroup (
                imageLayout.createParallelGroup (LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        imageLayout.setVerticalGroup (
                imageLayout.createParallelGroup (LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        GroupLayout jPanel3Layout = new GroupLayout (jPanel3);
        jPanel3.setLayout (jPanel3Layout);
        jPanel3Layout.setHorizontalGroup (
                jPanel3Layout.createParallelGroup (LEADING)
                        .addGroup (jPanel3Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel3Layout.createParallelGroup (LEADING)
                                        .addGroup (jPanel3Layout.createSequentialGroup ()
                                                .addComponent (pen , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent (bucketOfPaint , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent (eraser , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addGap (0 , 0 , Short.MAX_VALUE))
                                        .addGroup (jPanel3Layout.createSequentialGroup ()
                                                .addComponent (text , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent (colorPicker , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (image , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)))
                                .addContainerGap (GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup (
                jPanel3Layout.createParallelGroup (LEADING)
                        .addGroup (jPanel3Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel3Layout.createParallelGroup (LEADING)
                                        .addComponent (eraser , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                        .addComponent (bucketOfPaint , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                        .addComponent (pen , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE))
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                .addGroup (jPanel3Layout.createParallelGroup (LEADING)
                                        .addComponent (colorPicker , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                        .addComponent (text , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                        .addComponent (image , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE))
                                .addContainerGap ())
        );

        thickness.setBackground (new java.awt.Color (255 , 255 , 255));
        thickness.setForeground (new java.awt.Color (0 , 0 , 0));
        thickness.setMinimum (1);
        thickness.setValue (1);

        jLabel1.setBackground (new java.awt.Color (255 , 255 , 255));
        jLabel1.setForeground (new java.awt.Color (0 , 0 , 0));
        jLabel1.setText ("Thickness");

        pWHXY.setBackground (new java.awt.Color (204 , 204 , 204));
        pWHXY.setForeground (new java.awt.Color (204 , 204 , 204));

        lX.setFont (new java.awt.Font ("Dialog" , 0 , 14)); // NOI18N
        lX.setForeground (new java.awt.Color (0 , 0 , 0));
        lX.setText ("X");

        lY.setFont (new java.awt.Font ("Dialog" , 0 , 14)); // NOI18N
        lY.setForeground (new java.awt.Color (0 , 0 , 0));
        lY.setText ("Y");

        lWidth.setFont (new java.awt.Font ("Dialog" , 0 , 14)); // NOI18N
        lWidth.setForeground (new java.awt.Color (0 , 0 , 0));
        lWidth.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        lWidth.setText ("Width");

        lHeight.setFont (new java.awt.Font ("Dialog" , 0 , 14)); // NOI18N
        lHeight.setForeground (new java.awt.Color (0 , 0 , 0));
        lHeight.setText ("Height");

        GroupLayout pWHXYLayout = new GroupLayout (pWHXY);
        pWHXY.setLayout (pWHXYLayout);
        pWHXYLayout.setHorizontalGroup (
                pWHXYLayout.createParallelGroup (LEADING)
                        .addGroup (pWHXYLayout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (pWHXYLayout.createParallelGroup (LEADING , false)
                                        .addComponent (lHeight , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (lWidth , PREFERRED_SIZE , 40 , PREFERRED_SIZE))
                                .addGap (8 , 8 , 8)
                                .addGroup (pWHXYLayout.createParallelGroup (LEADING)
                                        .addComponent (txtHeight , PREFERRED_SIZE , 69 , PREFERRED_SIZE)
                                        .addComponent (txtWidth , PREFERRED_SIZE , 69 , PREFERRED_SIZE))
                                .addGap (18 , 18 , 18)
                                .addGroup (pWHXYLayout.createParallelGroup (LEADING)
                                        .addGroup (Alignment.TRAILING , pWHXYLayout.createSequentialGroup ()
                                                .addComponent (lX)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (txtX , PREFERRED_SIZE , 69 , PREFERRED_SIZE))
                                        .addGroup (Alignment.TRAILING , pWHXYLayout.createSequentialGroup ()
                                                .addComponent (lY)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (txtY , PREFERRED_SIZE , 69 , PREFERRED_SIZE)))
                                .addContainerGap (14 , Short.MAX_VALUE))
        );
        pWHXYLayout.setVerticalGroup (
                pWHXYLayout.createParallelGroup (LEADING)
                        .addGroup (pWHXYLayout.createSequentialGroup ()
                                .addGroup (pWHXYLayout.createParallelGroup (LEADING)
                                        .addGroup (pWHXYLayout.createSequentialGroup ()
                                                .addGroup (pWHXYLayout.createParallelGroup (Alignment.BASELINE)
                                                        .addComponent (lWidth)
                                                        .addComponent (txtWidth , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE))
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup (pWHXYLayout.createParallelGroup (Alignment.BASELINE)
                                                        .addComponent (lHeight)
                                                        .addComponent (txtHeight , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)))
                                        .addGroup (pWHXYLayout.createSequentialGroup ()
                                                .addGroup (pWHXYLayout.createParallelGroup (Alignment.BASELINE)
                                                        .addComponent (txtX , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                        .addComponent (lX))
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup (pWHXYLayout.createParallelGroup (Alignment.BASELINE)
                                                        .addComponent (txtY , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                        .addComponent (lY))))
                                .addGap (0 , 18 , Short.MAX_VALUE))
        );

        lblCursorPoint.setBackground (new java.awt.Color (204 , 204 , 204));
        lblCursorPoint.setFont (new java.awt.Font ("Dialog" , 0 , 12)); // NOI18N
        lblCursorPoint.setForeground (new java.awt.Color (0 , 0 , 0));
        lblCursorPoint.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        lblCursorPoint.setText ("X = 0 , Y = 0");

        btnBGColor.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout btnBGColorLayout = new GroupLayout (btnBGColor);
        btnBGColor.setLayout (btnBGColorLayout);
        btnBGColorLayout.setHorizontalGroup (
                btnBGColorLayout.createParallelGroup (LEADING)
                        .addGap (0 , 37 , Short.MAX_VALUE)
        );
        btnBGColorLayout.setVerticalGroup (
                btnBGColorLayout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        btnColor.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout btnColorLayout = new GroupLayout (btnColor);
        btnColor.setLayout (btnColorLayout);
        btnColorLayout.setHorizontalGroup (
                btnColorLayout.createParallelGroup (LEADING)
                        .addGap (0 , 39 , Short.MAX_VALUE)
        );
        btnColorLayout.setVerticalGroup (
                btnColorLayout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        jLabel2.setFont (new java.awt.Font ("DialogInput" , 0 , 14)); // NOI18N
        jLabel2.setForeground (new java.awt.Color (0 , 0 , 0));
        jLabel2.setText ("Color");

        jLabel3.setFont (new java.awt.Font ("DialogInput" , 0 , 14)); // NOI18N
        jLabel3.setForeground (new java.awt.Color (0 , 0 , 0));
        jLabel3.setText ("BGcolor");

        color1.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout color1Layout = new GroupLayout (color1);
        color1.setLayout (color1Layout);
        color1Layout.setHorizontalGroup (
                color1Layout.createParallelGroup (LEADING)
                        .addGap (0 , 39 , Short.MAX_VALUE)
        );
        color1Layout.setVerticalGroup (
                color1Layout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        color2.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout color2Layout = new GroupLayout (color2);
        color2.setLayout (color2Layout);
        color2Layout.setHorizontalGroup (
                color2Layout.createParallelGroup (LEADING)
                        .addGap (0 , 39 , Short.MAX_VALUE)
        );
        color2Layout.setVerticalGroup (
                color2Layout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        color3.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout color3Layout = new GroupLayout (color3);
        color3.setLayout (color3Layout);
        color3Layout.setHorizontalGroup (
                color3Layout.createParallelGroup (LEADING)
                        .addGap (0 , 39 , Short.MAX_VALUE)
        );
        color3Layout.setVerticalGroup (
                color3Layout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        color4.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout color4Layout = new GroupLayout (color4);
        color4.setLayout (color4Layout);
        color4Layout.setHorizontalGroup (
                color4Layout.createParallelGroup (LEADING)
                        .addGap (0 , 39 , Short.MAX_VALUE)
        );
        color4Layout.setVerticalGroup (
                color4Layout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        bgcolor3.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout bgcolor3Layout = new GroupLayout (bgcolor3);
        bgcolor3.setLayout (bgcolor3Layout);
        bgcolor3Layout.setHorizontalGroup (
                bgcolor3Layout.createParallelGroup (LEADING)
                        .addGap (0 , 39 , Short.MAX_VALUE)
        );
        bgcolor3Layout.setVerticalGroup (
                bgcolor3Layout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        bgcolor4.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout bgcolor4Layout = new GroupLayout (bgcolor4);
        bgcolor4.setLayout (bgcolor4Layout);
        bgcolor4Layout.setHorizontalGroup (
                bgcolor4Layout.createParallelGroup (LEADING)
                        .addGap (0 , 39 , Short.MAX_VALUE)
        );
        bgcolor4Layout.setVerticalGroup (
                bgcolor4Layout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        bgcolor2.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout bgcolor2Layout = new GroupLayout (bgcolor2);
        bgcolor2.setLayout (bgcolor2Layout);
        bgcolor2Layout.setHorizontalGroup (
                bgcolor2Layout.createParallelGroup (LEADING)
                        .addGap (0 , 39 , Short.MAX_VALUE)
        );
        bgcolor2Layout.setVerticalGroup (
                bgcolor2Layout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        bgcolor1.setPreferredSize (new java.awt.Dimension (60 , 60));

        GroupLayout bgcolor1Layout = new GroupLayout (bgcolor1);
        bgcolor1.setLayout (bgcolor1Layout);
        bgcolor1Layout.setHorizontalGroup (
                bgcolor1Layout.createParallelGroup (LEADING)
                        .addGap (0 , 39 , Short.MAX_VALUE)
        );
        bgcolor1Layout.setVerticalGroup (
                bgcolor1Layout.createParallelGroup (LEADING)
                        .addGap (0 , 38 , Short.MAX_VALUE)
        );

        txtThickness.setFont (new java.awt.Font ("Dialog" , 0 , 14)); // NOI18N
        txtThickness.setText ("0");

        GroupLayout jPanel1Layout = new GroupLayout (jPanel1);
        jPanel1.setLayout (jPanel1Layout);
        jPanel1Layout.setHorizontalGroup (
                jPanel1Layout.createParallelGroup (LEADING)
                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addComponent (jPanel4 , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent (jPanel3 , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                                        .addComponent (jLabel2 , PREFERRED_SIZE , 55 , PREFERRED_SIZE)
                                                        .addComponent (btnColor , PREFERRED_SIZE , 39 , PREFERRED_SIZE))
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                                        .addComponent (jLabel3 , PREFERRED_SIZE , 67 , PREFERRED_SIZE)
                                                        .addGroup (Alignment.TRAILING , jPanel1Layout.createSequentialGroup ()
                                                                .addComponent (btnBGColor , PREFERRED_SIZE , 37 , PREFERRED_SIZE)
                                                                .addGap (22 , 22 , 22))))
                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                .addComponent (color1 , PREFERRED_SIZE , 39 , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (color2 , PREFERRED_SIZE , 39 , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (color3 , PREFERRED_SIZE , 39 , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (color4 , PREFERRED_SIZE , 39 , PREFERRED_SIZE)))
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                .addGap (6 , 6 , 6)
                                                .addComponent (bgcolor1 , PREFERRED_SIZE , 39 , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (bgcolor2 , PREFERRED_SIZE , 39 , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (bgcolor3 , PREFERRED_SIZE , 39 , PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (bgcolor4 , PREFERRED_SIZE , 39 , PREFERRED_SIZE))
                                        .addGroup (jPanel1Layout.createParallelGroup (LEADING , false)
                                                .addGroup (jPanel1Layout.createSequentialGroup ()
                                                        .addComponent (jLabel1)
                                                        .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (txtThickness , PREFERRED_SIZE , 60 , PREFERRED_SIZE))
                                                .addGroup (jPanel1Layout.createSequentialGroup ()
                                                        .addGap (12 , 12 , 12)
                                                        .addComponent (thickness , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE))))
                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                .addGap (50 , 50 , 50)
                                                .addComponent (pWHXY , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                .addContainerGap (GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                        .addGroup (Alignment.TRAILING , jPanel1Layout.createSequentialGroup ()
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (lblCursorPoint , PREFERRED_SIZE , 129 , PREFERRED_SIZE)
                                                .addGap (20 , 20 , 20))))
        );
        jPanel1Layout.setVerticalGroup (
                jPanel1Layout.createParallelGroup (LEADING)
                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                        .addComponent (jPanel4 , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (jPanel3 , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                                        .addComponent (btnColor , PREFERRED_SIZE , 38 , PREFERRED_SIZE)
                                                        .addComponent (btnBGColor , PREFERRED_SIZE , 38 , PREFERRED_SIZE))
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup (jPanel1Layout.createParallelGroup (LEADING , false)
                                                        .addComponent (jLabel3 , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent (jLabel2 , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , 11 , Short.MAX_VALUE)
                                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                                        .addComponent (color1 , Alignment.TRAILING , PREFERRED_SIZE , 38 , PREFERRED_SIZE)
                                                        .addComponent (color2 , Alignment.TRAILING , PREFERRED_SIZE , 38 , PREFERRED_SIZE)
                                                        .addComponent (color3 , Alignment.TRAILING , PREFERRED_SIZE , 38 , PREFERRED_SIZE)
                                                        .addComponent (color4 , Alignment.TRAILING , PREFERRED_SIZE , 38 , PREFERRED_SIZE)
                                                        .addComponent (bgcolor2 , Alignment.TRAILING , PREFERRED_SIZE , 38 , PREFERRED_SIZE)
                                                        .addComponent (bgcolor3 , Alignment.TRAILING , PREFERRED_SIZE , 38 , PREFERRED_SIZE)
                                                        .addComponent (bgcolor4 , Alignment.TRAILING , PREFERRED_SIZE , 38 , PREFERRED_SIZE)))
                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                                        .addComponent (pWHXY , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                                .addComponent (thickness , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup (jPanel1Layout.createParallelGroup (Alignment.BASELINE)
                                                                        .addComponent (jLabel1)
                                                                        .addComponent (txtThickness , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE))))
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addGroup (jPanel1Layout.createParallelGroup (LEADING)
                                                        .addComponent (lblCursorPoint , Alignment.TRAILING , PREFERRED_SIZE , 31 , PREFERRED_SIZE)
                                                        .addComponent (bgcolor1 , Alignment.TRAILING , PREFERRED_SIZE , 38 , PREFERRED_SIZE))))
                                .addContainerGap ())
        );

        GroupLayout layout = new GroupLayout (getContentPane ());
        getContentPane ().setLayout (layout);
        layout.setHorizontalGroup (
                layout.createParallelGroup (LEADING)
                        .addGroup (layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (layout.createParallelGroup (LEADING)
                                        .addComponent (whiteBoard , GroupLayout.DEFAULT_SIZE , GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addGroup (layout.createSequentialGroup ()
                                                .addComponent (jPanel1 , PREFERRED_SIZE , 1355 , PREFERRED_SIZE)
                                                .addGap (0 , 0 , Short.MAX_VALUE)))
                                .addContainerGap ())
        );
        layout.setVerticalGroup (
                layout.createParallelGroup (LEADING)
                        .addGroup (layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addComponent (jPanel1 , PREFERRED_SIZE , GroupLayout.DEFAULT_SIZE , PREFERRED_SIZE)
                                .addGap (18 , 18 , 18)
                                .addComponent (whiteBoard , GroupLayout.DEFAULT_SIZE , 384 , Short.MAX_VALUE)
                                .addContainerGap ())
        );

        pack ();
    }// </editor-fold>

    @bardiademon
    // Variables declaration - do not modify
    private BtnPanel bucketOfPaint;
    private BtnPanel circleShape;
    private BtnPanel cloudCalloutShape;
    private BtnPanel colorPicker;
    private BtnPanel diamondShape;
    private BtnPanel downArrowShape;
    private BtnPanel eraser;
    private BtnPanel fivePointStarShape;
    private BtnPanel fourPointStarShape;
    private BtnPanel heartShape;
    private JPanel hexagonShape;
    public JCheckBox isFill;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JRadioButton jRadioButton1;
    public JSlider thickness;
    private BtnPanel leftArrowShape;
    private BtnPanel lightningShape;
    private BtnPanel line;
    private BtnPanel ovalCalloutShape;
    private WhiteBoard whiteBoard;
    private BtnPanel pen;
    private BtnPanel pentagonShape;
    private BtnPanel polygonShape;
    private BtnPanel rectShape;
    private BtnPanel rightArrowShape;
    private BtnPanel rightTriangleShape;
    private BtnPanel roundRectShape;
    private BtnPanel roundedRectangleCalloutShape;
    private BtnPanel sixPointStarShape;
    private BtnPanel squareShape;
    private BtnPanel text;
    private BtnPanel triangleShape;
    private BtnPanel upArrowShape;


    public JTextField txtHeight;
    public JTextField txtWidth;
    public JTextField txtX;
    public JTextField txtY;
    private JLabel lHeight;
    private JLabel lWidth;
    private JLabel lX;
    private JLabel lY;

    // pWHXY => panel width height x y
    private JPanel pWHXY;

    public JLabel lblCursorPoint;

    private BtnPanel image;


    private JLabel jLabel2;
    private JLabel jLabel3;
    public BtnColor btnColor;
    public BtnColor btnBGColor;


    public PreviousColors color1;
    private PreviousColors color2;
    private PreviousColors color3;
    private PreviousColors color4;
    private PreviousColors bgcolor1;
    private PreviousColors bgcolor2;
    private PreviousColors bgcolor3;
    private PreviousColors bgcolor4;

    public JTextField txtThickness;
    // End of variables declaration
}
