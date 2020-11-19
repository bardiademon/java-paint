package com.bardiademon.JavaPaint;

import com.bardiademon.JavaPaint.Shapes.BackgroundPaint;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class PaintView extends JFrame
{

    public static final BackgroundPaint BACKGROUND_PAINT = new BackgroundPaint ();

    private Color color;

    public PaintView ()
    {
        initComponents ();
        setLocationRelativeTo (null);
        setVisible (true);

        setOnClick ();

    }

    private void setOnClick ()
    {
        btnColor.addActionListener (e ->
        {
            Color selectColor = JColorChooser.showDialog (null , "Select color" , null);
            if (selectColor != null) color = selectColor;
            else color = Color.BLACK;
        });
    }

    public void setCursorPoint (Point cursorPoint)
    {
        lblCursorPoint.setText (String.format ("X = %d , Y = %d" , cursorPoint.x , cursorPoint.y));
    }

    public Color getColor ()
    {
        return color;
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
        colorPicker = new BtnPanel ();
        text = new BtnPanel (SelectedTool.text);
        isFill = new JCheckBox ();
        btnColor = new JButton ();
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


        whiteBoard = new WhiteBoard (this);

        jRadioButton1.setText ("jRadioButton1");

        setDefaultCloseOperation (javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground (new java.awt.Color (204 , 204 , 204));

        jPanel1.setBackground (new java.awt.Color (204 , 204 , 204));
        jPanel1.setForeground (new java.awt.Color (204 , 204 , 204));

        jPanel4.setBackground (new java.awt.Color (204 , 204 , 204));

        circleShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout circleShapeLayout = new javax.swing.GroupLayout (circleShape);
        circleShape.setLayout (circleShapeLayout);
        circleShapeLayout.setHorizontalGroup (
                circleShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        circleShapeLayout.setVerticalGroup (
                circleShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        squareShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout squareShapeLayout = new javax.swing.GroupLayout (squareShape);
        squareShape.setLayout (squareShapeLayout);
        squareShapeLayout.setHorizontalGroup (
                squareShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        squareShapeLayout.setVerticalGroup (
                squareShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        roundRectShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout roundRectShapeLayout = new javax.swing.GroupLayout (roundRectShape);
        roundRectShape.setLayout (roundRectShapeLayout);
        roundRectShapeLayout.setHorizontalGroup (
                roundRectShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        roundRectShapeLayout.setVerticalGroup (
                roundRectShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        polygonShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout polygonShapeLayout = new javax.swing.GroupLayout (polygonShape);
        polygonShape.setLayout (polygonShapeLayout);
        polygonShapeLayout.setHorizontalGroup (
                polygonShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        polygonShapeLayout.setVerticalGroup (
                polygonShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        triangleShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout triangleShapeLayout = new javax.swing.GroupLayout (triangleShape);
        triangleShape.setLayout (triangleShapeLayout);
        triangleShapeLayout.setHorizontalGroup (
                triangleShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        triangleShapeLayout.setVerticalGroup (
                triangleShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        rightArrowShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout rightArrowShapeLayout = new javax.swing.GroupLayout (rightArrowShape);
        rightArrowShape.setLayout (rightArrowShapeLayout);
        rightArrowShapeLayout.setHorizontalGroup (
                rightArrowShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        rightArrowShapeLayout.setVerticalGroup (
                rightArrowShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 29 , Short.MAX_VALUE)
        );

        hexagonShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout hexagonShapeLayout = new javax.swing.GroupLayout (hexagonShape);
        hexagonShape.setLayout (hexagonShapeLayout);
        hexagonShapeLayout.setHorizontalGroup (
                hexagonShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        hexagonShapeLayout.setVerticalGroup (
                hexagonShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        pentagonShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout pentagonShapeLayout = new javax.swing.GroupLayout (pentagonShape);
        pentagonShape.setLayout (pentagonShapeLayout);
        pentagonShapeLayout.setHorizontalGroup (
                pentagonShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        pentagonShapeLayout.setVerticalGroup (
                pentagonShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        diamondShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout diamondShapeLayout = new javax.swing.GroupLayout (diamondShape);
        diamondShape.setLayout (diamondShapeLayout);
        diamondShapeLayout.setHorizontalGroup (
                diamondShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        diamondShapeLayout.setVerticalGroup (
                diamondShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        rightTriangleShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout rightTriangleShapeLayout = new javax.swing.GroupLayout (rightTriangleShape);
        rightTriangleShape.setLayout (rightTriangleShapeLayout);
        rightTriangleShapeLayout.setHorizontalGroup (
                rightTriangleShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        rightTriangleShapeLayout.setVerticalGroup (
                rightTriangleShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        leftArrowShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout leftArrowShapeLayout = new javax.swing.GroupLayout (leftArrowShape);
        leftArrowShape.setLayout (leftArrowShapeLayout);
        leftArrowShapeLayout.setHorizontalGroup (
                leftArrowShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        leftArrowShapeLayout.setVerticalGroup (
                leftArrowShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 29 , Short.MAX_VALUE)
        );

        upArrowShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout upArrowShapeLayout = new javax.swing.GroupLayout (upArrowShape);
        upArrowShape.setLayout (upArrowShapeLayout);
        upArrowShapeLayout.setHorizontalGroup (
                upArrowShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        upArrowShapeLayout.setVerticalGroup (
                upArrowShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        downArrowShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout downArrowShapeLayout = new javax.swing.GroupLayout (downArrowShape);
        downArrowShape.setLayout (downArrowShapeLayout);
        downArrowShapeLayout.setHorizontalGroup (
                downArrowShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        downArrowShapeLayout.setVerticalGroup (
                downArrowShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        fourPointStarShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout fourPointStarShapeLayout = new javax.swing.GroupLayout (fourPointStarShape);
        fourPointStarShape.setLayout (fourPointStarShapeLayout);
        fourPointStarShapeLayout.setHorizontalGroup (
                fourPointStarShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        fourPointStarShapeLayout.setVerticalGroup (
                fourPointStarShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        fivePointStarShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout fivePointStarShapeLayout = new javax.swing.GroupLayout (fivePointStarShape);
        fivePointStarShape.setLayout (fivePointStarShapeLayout);
        fivePointStarShapeLayout.setHorizontalGroup (
                fivePointStarShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        fivePointStarShapeLayout.setVerticalGroup (
                fivePointStarShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        sixPointStarShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout sixPointStarShapeLayout = new javax.swing.GroupLayout (sixPointStarShape);
        sixPointStarShape.setLayout (sixPointStarShapeLayout);
        sixPointStarShapeLayout.setHorizontalGroup (
                sixPointStarShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        sixPointStarShapeLayout.setVerticalGroup (
                sixPointStarShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 29 , Short.MAX_VALUE)
        );

        roundedRectangleCalloutShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout roundedRectangleCalloutShapeLayout = new javax.swing.GroupLayout (roundedRectangleCalloutShape);
        roundedRectangleCalloutShape.setLayout (roundedRectangleCalloutShapeLayout);
        roundedRectangleCalloutShapeLayout.setHorizontalGroup (
                roundedRectangleCalloutShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        roundedRectangleCalloutShapeLayout.setVerticalGroup (
                roundedRectangleCalloutShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        ovalCalloutShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout ovalCalloutShapeLayout = new javax.swing.GroupLayout (ovalCalloutShape);
        ovalCalloutShape.setLayout (ovalCalloutShapeLayout);
        ovalCalloutShapeLayout.setHorizontalGroup (
                ovalCalloutShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        ovalCalloutShapeLayout.setVerticalGroup (
                ovalCalloutShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        cloudCalloutShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout cloudCalloutShapeLayout = new javax.swing.GroupLayout (cloudCalloutShape);
        cloudCalloutShape.setLayout (cloudCalloutShapeLayout);
        cloudCalloutShapeLayout.setHorizontalGroup (
                cloudCalloutShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        cloudCalloutShapeLayout.setVerticalGroup (
                cloudCalloutShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        heartShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout heartShapeLayout = new javax.swing.GroupLayout (heartShape);
        heartShape.setLayout (heartShapeLayout);
        heartShapeLayout.setHorizontalGroup (
                heartShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        heartShapeLayout.setVerticalGroup (
                heartShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        lightningShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout lightningShapeLayout = new javax.swing.GroupLayout (lightningShape);
        lightningShape.setLayout (lightningShapeLayout);
        lightningShapeLayout.setHorizontalGroup (
                lightningShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        lightningShapeLayout.setVerticalGroup (
                lightningShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        line.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout lineLayout = new javax.swing.GroupLayout (line);
        line.setLayout (lineLayout);
        lineLayout.setHorizontalGroup (
                lineLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        lineLayout.setVerticalGroup (
                lineLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 29 , Short.MAX_VALUE)
        );

        rectShape.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout rectShapeLayout = new javax.swing.GroupLayout (rectShape);
        rectShape.setLayout (rectShapeLayout);
        rectShapeLayout.setHorizontalGroup (
                rectShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        rectShapeLayout.setVerticalGroup (
                rectShapeLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout (jPanel4);
        jPanel4.setLayout (jPanel4Layout);
        jPanel4Layout.setHorizontalGroup (
                jPanel4Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (jPanel4Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel4Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup (jPanel4Layout.createSequentialGroup ()
                                                .addComponent (circleShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (squareShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (rectShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , 7 , Short.MAX_VALUE)
                                                .addComponent (roundRectShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (triangleShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (polygonShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (rightTriangleShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (diamondShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (pentagonShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (hexagonShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (rightArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (lightningShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup (jPanel4Layout.createSequentialGroup ()
                                                .addComponent (leftArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (upArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (downArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (fourPointStarShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (fivePointStarShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (sixPointStarShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (roundedRectangleCalloutShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (ovalCalloutShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (cloudCalloutShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (heartShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (line , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap (0 , 0 , Short.MAX_VALUE)))
                                .addContainerGap ())
        );
        jPanel4Layout.setVerticalGroup (
                jPanel4Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (jPanel4Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel4Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING , false)
                                        .addComponent (rightArrowShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (hexagonShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (pentagonShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (diamondShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (rightTriangleShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (lightningShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (polygonShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (triangleShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (roundRectShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (squareShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (circleShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (rectShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                .addGap (18 , 18 , 18)
                                .addGroup (jPanel4Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup (jPanel4Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING , false)
                                                .addComponent (heartShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (cloudCalloutShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (ovalCalloutShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (roundedRectangleCalloutShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (sixPointStarShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent (line , javax.swing.GroupLayout.Alignment.TRAILING , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup (jPanel4Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING , false)
                                                .addComponent (fivePointStarShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (fourPointStarShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (downArrowShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (upArrowShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (leftArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap (javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );

        jPanel3.setBackground (new java.awt.Color (204 , 204 , 204));

        pen.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout penLayout = new javax.swing.GroupLayout (pen);
        pen.setLayout (penLayout);
        penLayout.setHorizontalGroup (
                penLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        penLayout.setVerticalGroup (
                penLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        bucketOfPaint.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout bucketOfPaintLayout = new javax.swing.GroupLayout (bucketOfPaint);
        bucketOfPaint.setLayout (bucketOfPaintLayout);
        bucketOfPaintLayout.setHorizontalGroup (
                bucketOfPaintLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        bucketOfPaintLayout.setVerticalGroup (
                bucketOfPaintLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        eraser.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout eraserLayout = new javax.swing.GroupLayout (eraser);
        eraser.setLayout (eraserLayout);
        eraserLayout.setHorizontalGroup (
                eraserLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        eraserLayout.setVerticalGroup (
                eraserLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        colorPicker.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout colorPickerLayout = new javax.swing.GroupLayout (colorPicker);
        colorPicker.setLayout (colorPickerLayout);
        colorPickerLayout.setHorizontalGroup (
                colorPickerLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        colorPickerLayout.setVerticalGroup (
                colorPickerLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        text.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout textLayout = new javax.swing.GroupLayout (text);
        text.setLayout (textLayout);
        textLayout.setHorizontalGroup (
                textLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 31 , Short.MAX_VALUE)
        );
        textLayout.setVerticalGroup (
                textLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 27 , Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout (jPanel3);
        jPanel3.setLayout (jPanel3Layout);
        jPanel3Layout.setHorizontalGroup (
                jPanel3Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (jPanel3Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel3Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup (jPanel3Layout.createSequentialGroup ()
                                                .addComponent (pen , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent (bucketOfPaint , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent (eraser , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup (jPanel3Layout.createSequentialGroup ()
                                                .addComponent (text , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent (colorPicker , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap (javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup (
                jPanel3Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (jPanel3Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel3Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent (eraser , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent (bucketOfPaint , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent (pen , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup (jPanel3Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent (colorPicker , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent (text , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap (javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );

        isFill.setBackground (new java.awt.Color (204 , 204 , 204));
        isFill.setFont (new java.awt.Font ("Dubai" , 0 , 14)); // NOI18N
        isFill.setForeground (new java.awt.Color (0 , 0 , 0));
        isFill.setText ("Fill");

        btnColor.setFont (new java.awt.Font ("Dialog" , 0 , 12)); // NOI18N
        btnColor.setText ("Color");

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

        javax.swing.GroupLayout pWHXYLayout = new javax.swing.GroupLayout (pWHXY);
        pWHXY.setLayout (pWHXYLayout);
        pWHXYLayout.setHorizontalGroup (
                pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (javax.swing.GroupLayout.Alignment.TRAILING , pWHXYLayout.createSequentialGroup ()
                                .addContainerGap (javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                .addGroup (pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING , false)
                                        .addComponent (lHeight , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (lWidth , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                .addGap (8 , 8 , 8)
                                .addGroup (pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent (txtHeight , javax.swing.GroupLayout.PREFERRED_SIZE , 69 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent (txtWidth , javax.swing.GroupLayout.PREFERRED_SIZE , 69 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap (18 , 18 , 18)
                                .addGroup (pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup (javax.swing.GroupLayout.Alignment.TRAILING , pWHXYLayout.createSequentialGroup ()
                                                .addComponent (lX)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (txtX , javax.swing.GroupLayout.PREFERRED_SIZE , 69 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup (javax.swing.GroupLayout.Alignment.TRAILING , pWHXYLayout.createSequentialGroup ()
                                                .addComponent (lY)
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent (txtY , javax.swing.GroupLayout.PREFERRED_SIZE , 69 , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap (69 , 69 , 69))
        );
        pWHXYLayout.setVerticalGroup (
                pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (javax.swing.GroupLayout.Alignment.TRAILING , pWHXYLayout.createSequentialGroup ()
                                .addContainerGap (18 , Short.MAX_VALUE)
                                .addGroup (pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup (pWHXYLayout.createSequentialGroup ()
                                                .addGroup (pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent (lWidth)
                                                        .addComponent (txtWidth , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup (pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent (lHeight)
                                                        .addComponent (txtHeight , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup (pWHXYLayout.createSequentialGroup ()
                                                .addGroup (pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent (txtX , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent (lX))
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup (pWHXYLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent (txtY , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent (lY))))
                                .addContainerGap ())
        );

        lblCursorPoint.setBackground (new java.awt.Color (204 , 204 , 204));
        lblCursorPoint.setFont (new java.awt.Font ("Dialog" , 0 , 12)); // NOI18N
        lblCursorPoint.setForeground (new java.awt.Color (0 , 0 , 0));
        lblCursorPoint.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        lblCursorPoint.setText ("X = 0 , Y = 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout (jPanel1);
        jPanel1.setLayout (jPanel1Layout);
        jPanel1Layout.setHorizontalGroup (
                jPanel1Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addComponent (jPanel4 , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap (32 , 32 , 32)
                                .addComponent (jPanel3 , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup (jPanel1Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent (isFill)
                                        .addComponent (btnColor))
                                .addGap (33 , 33 , 33)
                                .addComponent (pWHXY , javax.swing.GroupLayout.PREFERRED_SIZE , 251 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup (jPanel1Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                .addGap (60 , 60 , 60)
                                                .addGroup (jPanel1Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , 16 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent (thickness , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent (jLabel1))
                                                .addContainerGap (15 , Short.MAX_VALUE))
                                        .addGroup (javax.swing.GroupLayout.Alignment.TRAILING , jPanel1Layout.createSequentialGroup ()
                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent (lblCursorPoint , javax.swing.GroupLayout.PREFERRED_SIZE , 129 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap ())))
        );
        jPanel1Layout.setVerticalGroup (
                jPanel1Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (jPanel1Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                .addGroup (jPanel1Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                                .addComponent (isFill)
                                                                .addGap (18 , 18 , 18)
                                                                .addComponent (btnColor))
                                                        .addComponent (jPanel3 , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap (javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                .addGroup (jPanel1Layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING , false)
                                                        .addComponent (pWHXY , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup (jPanel1Layout.createSequentialGroup ()
                                                                .addComponent (thickness , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent (jLabel1)
                                                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                                .addComponent (lblCursorPoint , javax.swing.GroupLayout.PREFERRED_SIZE , 31 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent (jPanel4 , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap (0 , 12 , Short.MAX_VALUE))))
        );

        whiteBoard.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout whiteBoardLayout = new javax.swing.GroupLayout (whiteBoard);
        whiteBoard.setLayout (whiteBoardLayout);
        whiteBoardLayout.setHorizontalGroup (
                whiteBoardLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 0 , Short.MAX_VALUE)
        );
        whiteBoardLayout.setVerticalGroup (
                whiteBoardLayout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap (0 , 451 , Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout (getContentPane ());
        getContentPane ().setLayout (layout);
        layout.setHorizontalGroup (
                layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (javax.swing.GroupLayout.Alignment.TRAILING , layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addGroup (layout.createParallelGroup (javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent (whiteBoard , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent (jPanel1 , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                .addContainerGap ())
        );
        layout.setVerticalGroup (
                layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addComponent (jPanel1 , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent (whiteBoard , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                .addContainerGap ())
        );

        pack ();
    }// </editor-fold>

    // Variables declaration - do not modify
    private JButton btnColor;
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

    // End of variables declaration
}
