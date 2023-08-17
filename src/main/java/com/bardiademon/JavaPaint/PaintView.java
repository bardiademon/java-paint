package com.bardiademon.JavaPaint;

import com.bardiademon.JavaPaint.DrawnShapes.DrawnShapes;
import com.bardiademon.JavaPaint.Shapes.BackgroundPaint;
import com.bardiademon.JavaPaint.WhiteBoard.MousePosition;
import com.bardiademon.JavaPaint.WhiteBoard.Save.SaveAsImage;
import com.bardiademon.JavaPaint.WhiteBoard.Tools.SelectedTool;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@bardiademon
public final class PaintView extends JFrame {

    public boolean saved = true;

    // C => Color
    public PreviousColors selectedPreviousColor_C;

    // BC => Background Color
    public PreviousColors selectedPreviousColor_BC;

    @bardiademon
    public static final BackgroundPaint BACKGROUND_PAINT = new BackgroundPaint();

    public interface PreviousColor {
        void onClick(Color color);
    }

    @bardiademon
    public PaintView() {
        initComponents();
        setVisible(true);

        txtThickness.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChangeTxtThickness();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChangeTxtThickness();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onChangeTxtThickness();
            }
        });

        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });
    }

    private void onChangeTxtThickness() {
        final String valTxtThickness = txtThickness.getText();
        if (valTxtThickness != null && !valTxtThickness.equals("")) {
            try {
                if (valTxtThickness.matches("[0-9]*")) {
                    int valThickness = Integer.parseInt(valTxtThickness);
                    if (valThickness <= thickness.getMaximum() && valThickness >= thickness.getMinimum())
                        thickness.setValue(valThickness);
                    else
                        throw new Exception();
                } else
                    throw new Exception();
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> txtThickness.setText(String.valueOf(thickness.getValue())));
            }
        }
    }


    public interface OnClickQuestionForSave {
        void Doing();
    }

    public void questionForSave(final OnClickQuestionForSave onClick) {
        if (!saved) {
            int result = JOptionPane.showOptionDialog(null ,
                    "Do you want to save?" ,
                    "Java paint" ,
                    JOptionPane.YES_NO_CANCEL_OPTION ,
                    JOptionPane.QUESTION_MESSAGE , null , new Object[]{
                            "Save" , "Don't Save" , "Cancel"
                    } , null);

            switch (result) {
                case 0:
                    actionMenuItem.fileSaveAs();
                    if (actionMenuItem.saveAsImage.isSave())
                        onClick.Doing();
                    break;
                case 1:
                    onClick.Doing();
                    break;
            }
        } else onClick.Doing();
    }

    @bardiademon
    public void setMousePosition(final Point mousePosition) {
        this.mousePosition.setPoint(mousePosition);
    }

    public PreviousColor getPreviousColor(final PreviousColors previousColor) {
        return color ->
        {

            if (previousColor.getColorFor().equals(PreviousColors.ColorFor.bgcolor)) {
                selectedPreviousColor_BC = previousColor;
                if (previousColor.isSetColor()) {
                    btnBGColor.setBackground(color);
                    WhiteBoard.SetBackgroundColor(color);
                }
            } else {
                selectedPreviousColor_C = previousColor;

                if (previousColor.isSetColor()) {
                    btnColor.setBackground(color);
                    WhiteBoard.SetColor(color);
                }

            }
        };
    }

    private void close() {
        questionForSave(() ->
        {
            whiteBoard.clear();
            dispose();
            System.gc();
            System.exit(0);
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jRadioButton1 = new JRadioButton();
        jPanel1 = new JPanel();
        jPanel4 = new JPanel();
        circleShape = new ToolsButtons(SelectedTool.circle);
        squareShape = new ToolsButtons(SelectedTool.square);
        roundRectShape = new ToolsButtons(SelectedTool.round_rect);
        polygonShape = new ToolsButtons(SelectedTool.polygon);
        triangleShape = new ToolsButtons(SelectedTool.triangle);
        rightArrowShape = new ToolsButtons(SelectedTool.right_arrow);
        hexagonShape = new ToolsButtons(SelectedTool.hexagon);
        pentagonShape = new ToolsButtons(SelectedTool.pentagon);
        diamondShape = new ToolsButtons(SelectedTool.diamond);
        rightTriangleShape = new ToolsButtons(SelectedTool.right_triangle);
        leftArrowShape = new ToolsButtons(SelectedTool.left_arrow);
        upArrowShape = new ToolsButtons(SelectedTool.up_arrow);
        downArrowShape = new ToolsButtons(SelectedTool.down_arrow);
        fourPointStarShape = new ToolsButtons(SelectedTool.four_point_star);
        fivePointStarShape = new ToolsButtons(SelectedTool.five_point_star);
        sixPointStarShape = new ToolsButtons(SelectedTool.six_point_star);
        roundedRectangleCalloutShape = new ToolsButtons(SelectedTool.rounded_rectangle_callout);
        ovalCalloutShape = new ToolsButtons(SelectedTool.oval_callout);
        cloudCalloutShape = new ToolsButtons(SelectedTool.cloud_callout);
        heartShape = new ToolsButtons(SelectedTool.heart);
        lightningShape = new ToolsButtons(SelectedTool.lightning);
        line = new ToolsButtons(SelectedTool.line);
        jPanel3 = new JPanel();
        pen = new ToolsButtons(SelectedTool.pen);
        bucketOfPaint = new ToolsButtons(SelectedTool.bucket_of_paint);
        eraser = new ToolsButtons(SelectedTool.eraser);
        colorPicker = new ToolsButtons(SelectedTool.color_picker);
        text = new ToolsButtons(SelectedTool.text);
        isFill = new JCheckBox();
        thickness = new JSlider();
        jLabel1 = new JLabel();
        rectShape = new ToolsButtons(SelectedTool.rect);

        txtX = new JTextField();
        lX = new JLabel();
        txtY = new JTextField();
        lY = new JLabel();
        txtHeight = new JTextField();
        txtWidth = new JTextField();
        lWidth = new JLabel();
        lHeight = new JLabel();
        pWHXY = new JPanel();

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        color1 = new PreviousColors(PreviousColors.ColorFor.color);
        color1.setPreviousColor(getPreviousColor(color1));

        color2 = new PreviousColors(PreviousColors.ColorFor.color);
        color2.setPreviousColor(getPreviousColor(color2));

        color3 = new PreviousColors(PreviousColors.ColorFor.color);
        color3.setPreviousColor(getPreviousColor(color3));

        color4 = new PreviousColors(PreviousColors.ColorFor.color);
        color4.setPreviousColor(getPreviousColor(color4));

        bgcolor3 = new PreviousColors(PreviousColors.ColorFor.bgcolor);
        bgcolor3.setPreviousColor(getPreviousColor(bgcolor3));

        bgcolor4 = new PreviousColors(PreviousColors.ColorFor.bgcolor);
        bgcolor4.setPreviousColor(getPreviousColor(bgcolor4));

        bgcolor2 = new PreviousColors(PreviousColors.ColorFor.bgcolor);
        bgcolor2.setPreviousColor(getPreviousColor(bgcolor2));

        bgcolor1 = new PreviousColors(PreviousColors.ColorFor.bgcolor);
        bgcolor1.setPreviousColor(getPreviousColor(bgcolor1));

        txtThickness = new javax.swing.JTextField();

        whiteBoard = new WhiteBoard(this);
        whiteBoard.setOpaque(true);
        whiteBoard.setBackground(Color.WHITE);

        mousePosition = new MousePosition(whiteBoard.getRobot());

        btnBGColor = new BtnColor(_Color ->
        {
            WhiteBoard.SetBackgroundColor(_Color);
            if (selectedPreviousColor_BC != null) {
                selectedPreviousColor_BC.setColor(_Color);
                selectedPreviousColor_BC = null;
            }
        });
        btnColor = new BtnColor(_Color ->
        {
            WhiteBoard.SetColor(_Color);
            if (selectedPreviousColor_C != null) {
                selectedPreviousColor_C.setColor(_Color);
                selectedPreviousColor_C = null;
            }

        });

        image = new ToolsButtons(whiteBoard , SelectedTool.image);

        colorsPanel = new JPanel();
        menu = new javax.swing.JMenuBar();

        btnColor.setBackground(Color.BLACK);
        btnColor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        initComponents2();
        afterInitComponents();
    }

    private void initComponents2() {

        setBackground(new java.awt.Color(204 , 204 , 204));

        jPanel1.setBackground(new java.awt.Color(204 , 204 , 204));
        jPanel1.setForeground(new java.awt.Color(204 , 204 , 204));

        jPanel4.setBackground(new java.awt.Color(204 , 204 , 204));

        circleShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout circleShapeLayout = new javax.swing.GroupLayout(circleShape);
        circleShape.setLayout(circleShapeLayout);
        circleShapeLayout.setHorizontalGroup(
                circleShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        circleShapeLayout.setVerticalGroup(
                circleShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        squareShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout squareShapeLayout = new javax.swing.GroupLayout(squareShape);
        squareShape.setLayout(squareShapeLayout);
        squareShapeLayout.setHorizontalGroup(
                squareShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        squareShapeLayout.setVerticalGroup(
                squareShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        roundRectShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout roundRectShapeLayout = new javax.swing.GroupLayout(roundRectShape);
        roundRectShape.setLayout(roundRectShapeLayout);
        roundRectShapeLayout.setHorizontalGroup(
                roundRectShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        roundRectShapeLayout.setVerticalGroup(
                roundRectShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        polygonShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout polygonShapeLayout = new javax.swing.GroupLayout(polygonShape);
        polygonShape.setLayout(polygonShapeLayout);
        polygonShapeLayout.setHorizontalGroup(
                polygonShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        polygonShapeLayout.setVerticalGroup(
                polygonShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        triangleShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout triangleShapeLayout = new javax.swing.GroupLayout(triangleShape);
        triangleShape.setLayout(triangleShapeLayout);
        triangleShapeLayout.setHorizontalGroup(
                triangleShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        triangleShapeLayout.setVerticalGroup(
                triangleShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        rightArrowShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout rightArrowShapeLayout = new javax.swing.GroupLayout(rightArrowShape);
        rightArrowShape.setLayout(rightArrowShapeLayout);
        rightArrowShapeLayout.setHorizontalGroup(
                rightArrowShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        rightArrowShapeLayout.setVerticalGroup(
                rightArrowShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 29 , Short.MAX_VALUE)
        );

        hexagonShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout hexagonShapeLayout = new javax.swing.GroupLayout(hexagonShape);
        hexagonShape.setLayout(hexagonShapeLayout);
        hexagonShapeLayout.setHorizontalGroup(
                hexagonShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        hexagonShapeLayout.setVerticalGroup(
                hexagonShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        pentagonShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout pentagonShapeLayout = new javax.swing.GroupLayout(pentagonShape);
        pentagonShape.setLayout(pentagonShapeLayout);
        pentagonShapeLayout.setHorizontalGroup(
                pentagonShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        pentagonShapeLayout.setVerticalGroup(
                pentagonShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        diamondShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout diamondShapeLayout = new javax.swing.GroupLayout(diamondShape);
        diamondShape.setLayout(diamondShapeLayout);
        diamondShapeLayout.setHorizontalGroup(
                diamondShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        diamondShapeLayout.setVerticalGroup(
                diamondShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        rightTriangleShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout rightTriangleShapeLayout = new javax.swing.GroupLayout(rightTriangleShape);
        rightTriangleShape.setLayout(rightTriangleShapeLayout);
        rightTriangleShapeLayout.setHorizontalGroup(
                rightTriangleShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        rightTriangleShapeLayout.setVerticalGroup(
                rightTriangleShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        leftArrowShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout leftArrowShapeLayout = new javax.swing.GroupLayout(leftArrowShape);
        leftArrowShape.setLayout(leftArrowShapeLayout);
        leftArrowShapeLayout.setHorizontalGroup(
                leftArrowShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        leftArrowShapeLayout.setVerticalGroup(
                leftArrowShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 29 , Short.MAX_VALUE)
        );

        upArrowShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout upArrowShapeLayout = new javax.swing.GroupLayout(upArrowShape);
        upArrowShape.setLayout(upArrowShapeLayout);
        upArrowShapeLayout.setHorizontalGroup(
                upArrowShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        upArrowShapeLayout.setVerticalGroup(
                upArrowShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        downArrowShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout downArrowShapeLayout = new javax.swing.GroupLayout(downArrowShape);
        downArrowShape.setLayout(downArrowShapeLayout);
        downArrowShapeLayout.setHorizontalGroup(
                downArrowShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        downArrowShapeLayout.setVerticalGroup(
                downArrowShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        fourPointStarShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout fourPointStarShapeLayout = new javax.swing.GroupLayout(fourPointStarShape);
        fourPointStarShape.setLayout(fourPointStarShapeLayout);
        fourPointStarShapeLayout.setHorizontalGroup(
                fourPointStarShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        fourPointStarShapeLayout.setVerticalGroup(
                fourPointStarShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        fivePointStarShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout fivePointStarShapeLayout = new javax.swing.GroupLayout(fivePointStarShape);
        fivePointStarShape.setLayout(fivePointStarShapeLayout);
        fivePointStarShapeLayout.setHorizontalGroup(
                fivePointStarShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        fivePointStarShapeLayout.setVerticalGroup(
                fivePointStarShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        sixPointStarShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout sixPointStarShapeLayout = new javax.swing.GroupLayout(sixPointStarShape);
        sixPointStarShape.setLayout(sixPointStarShapeLayout);
        sixPointStarShapeLayout.setHorizontalGroup(
                sixPointStarShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        sixPointStarShapeLayout.setVerticalGroup(
                sixPointStarShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 29 , Short.MAX_VALUE)
        );

        roundedRectangleCalloutShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout roundedRectangleCalloutShapeLayout = new javax.swing.GroupLayout(roundedRectangleCalloutShape);
        roundedRectangleCalloutShape.setLayout(roundedRectangleCalloutShapeLayout);
        roundedRectangleCalloutShapeLayout.setHorizontalGroup(
                roundedRectangleCalloutShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        roundedRectangleCalloutShapeLayout.setVerticalGroup(
                roundedRectangleCalloutShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        ovalCalloutShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout ovalCalloutShapeLayout = new javax.swing.GroupLayout(ovalCalloutShape);
        ovalCalloutShape.setLayout(ovalCalloutShapeLayout);
        ovalCalloutShapeLayout.setHorizontalGroup(
                ovalCalloutShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        ovalCalloutShapeLayout.setVerticalGroup(
                ovalCalloutShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        cloudCalloutShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout cloudCalloutShapeLayout = new javax.swing.GroupLayout(cloudCalloutShape);
        cloudCalloutShape.setLayout(cloudCalloutShapeLayout);
        cloudCalloutShapeLayout.setHorizontalGroup(
                cloudCalloutShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        cloudCalloutShapeLayout.setVerticalGroup(
                cloudCalloutShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        heartShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout heartShapeLayout = new javax.swing.GroupLayout(heartShape);
        heartShape.setLayout(heartShapeLayout);
        heartShapeLayout.setHorizontalGroup(
                heartShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        heartShapeLayout.setVerticalGroup(
                heartShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        lightningShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout lightningShapeLayout = new javax.swing.GroupLayout(lightningShape);
        lightningShape.setLayout(lightningShapeLayout);
        lightningShapeLayout.setHorizontalGroup(
                lightningShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        lightningShapeLayout.setVerticalGroup(
                lightningShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        line.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout lineLayout = new javax.swing.GroupLayout(line);
        line.setLayout(lineLayout);
        lineLayout.setHorizontalGroup(
                lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        lineLayout.setVerticalGroup(
                lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 29 , Short.MAX_VALUE)
        );

        rectShape.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout rectShapeLayout = new javax.swing.GroupLayout(rectShape);
        rectShape.setLayout(rectShapeLayout);
        rectShapeLayout.setHorizontalGroup(
                rectShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        rectShapeLayout.setVerticalGroup(
                rectShapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        isFill.setBackground(new java.awt.Color(204 , 204 , 204));
        isFill.setFont(new java.awt.Font("Dubai" , 0 , 14)); // NOI18N
        isFill.setForeground(new java.awt.Color(0 , 0 , 0));
        isFill.setText("Fill");

        jPanel3.setBackground(new java.awt.Color(204 , 204 , 204));

        pen.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout penLayout = new javax.swing.GroupLayout(pen);
        pen.setLayout(penLayout);
        penLayout.setHorizontalGroup(
                penLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        penLayout.setVerticalGroup(
                penLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 27 , Short.MAX_VALUE)
        );

        bucketOfPaint.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout bucketOfPaintLayout = new javax.swing.GroupLayout(bucketOfPaint);
        bucketOfPaint.setLayout(bucketOfPaintLayout);
        bucketOfPaintLayout.setHorizontalGroup(
                bucketOfPaintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        bucketOfPaintLayout.setVerticalGroup(
                bucketOfPaintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 27 , Short.MAX_VALUE)
        );

        eraser.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout eraserLayout = new javax.swing.GroupLayout(eraser);
        eraser.setLayout(eraserLayout);
        eraserLayout.setHorizontalGroup(
                eraserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        eraserLayout.setVerticalGroup(
                eraserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 27 , Short.MAX_VALUE)
        );

        colorPicker.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout colorPickerLayout = new javax.swing.GroupLayout(colorPicker);
        colorPicker.setLayout(colorPickerLayout);
        colorPickerLayout.setHorizontalGroup(
                colorPickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        colorPickerLayout.setVerticalGroup(
                colorPickerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 27 , Short.MAX_VALUE)
        );

        text.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout textLayout = new javax.swing.GroupLayout(text);
        text.setLayout(textLayout);
        textLayout.setHorizontalGroup(
                textLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        textLayout.setVerticalGroup(
                textLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 27 , Short.MAX_VALUE)
        );

        image.setBackground(new java.awt.Color(255 , 255 , 255));

        javax.swing.GroupLayout imageLayout = new javax.swing.GroupLayout(image);
        image.setLayout(imageLayout);
        imageLayout.setHorizontalGroup(
                imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 31 , Short.MAX_VALUE)
        );
        imageLayout.setVerticalGroup(
                imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 27 , Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(pen , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bucketOfPaint , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(eraser , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0 , 0 , Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(text , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(colorPicker , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent(image , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(eraser , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bucketOfPaint , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pen , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18 , 18 , 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(colorPicker , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(text , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(image , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20 , Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(circleShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(squareShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rectShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(roundRectShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(triangleShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(polygonShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rightTriangleShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(diamondShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pentagonShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(hexagonShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rightArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lightningShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(leftArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(downArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fourPointStarShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fivePointStarShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sixPointStarShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(roundedRectangleCalloutShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ovalCalloutShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cloudCalloutShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(heartShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(line , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(isFill)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3 , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING , false)
                                        .addComponent(rightArrowShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(hexagonShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(pentagonShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(diamondShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(rightTriangleShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(lightningShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(polygonShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(triangleShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(roundRectShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(squareShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(circleShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(rectShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                .addGap(18 , 18 , 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING , false)
                                                        .addComponent(heartShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent(cloudCalloutShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent(ovalCalloutShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent(roundedRectangleCalloutShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent(sixPointStarShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(line , javax.swing.GroupLayout.Alignment.TRAILING , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING , false)
                                                        .addComponent(fivePointStarShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent(fourPointStarShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent(downArrowShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent(upArrowShape , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                        .addComponent(leftArrowShape , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(isFill))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING , jPanel4Layout.createSequentialGroup()
                                .addGap(0 , 1 , Short.MAX_VALUE)
                                .addComponent(jPanel3 , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        thickness.setBackground(new java.awt.Color(255 , 255 , 255));
        thickness.setForeground(new java.awt.Color(0 , 0 , 0));
        thickness.setMinimum(1);
        thickness.setValue(1);

        jLabel1.setBackground(new java.awt.Color(255 , 255 , 255));
        jLabel1.setForeground(new java.awt.Color(0 , 0 , 0));
        jLabel1.setText("Thickness");

        pWHXY.setBackground(new java.awt.Color(204 , 204 , 204));
        pWHXY.setForeground(new java.awt.Color(204 , 204 , 204));

        lX.setFont(new java.awt.Font("Dialog" , 0 , 14)); // NOI18N
        lX.setForeground(new java.awt.Color(0 , 0 , 0));
        lX.setText("X");

        lY.setFont(new java.awt.Font("Dialog" , 0 , 14)); // NOI18N
        lY.setForeground(new java.awt.Color(0 , 0 , 0));
        lY.setText("Y");

        lWidth.setFont(new java.awt.Font("Dialog" , 0 , 14)); // NOI18N
        lWidth.setForeground(new java.awt.Color(0 , 0 , 0));
        lWidth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lWidth.setText("Width");

        lHeight.setFont(new java.awt.Font("Dialog" , 0 , 14)); // NOI18N
        lHeight.setForeground(new java.awt.Color(0 , 0 , 0));
        lHeight.setText("Height");

        javax.swing.GroupLayout pWHXYLayout = new javax.swing.GroupLayout(pWHXY);
        pWHXY.setLayout(pWHXYLayout);
        pWHXYLayout.setHorizontalGroup(
                pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pWHXYLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING , false)
                                        .addComponent(lHeight , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(lWidth , javax.swing.GroupLayout.PREFERRED_SIZE , 40 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8 , 8 , 8)
                                .addGroup(pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHeight , javax.swing.GroupLayout.PREFERRED_SIZE , 69 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtWidth , javax.swing.GroupLayout.PREFERRED_SIZE , 69 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18 , 18 , 18)
                                .addGroup(pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING , pWHXYLayout.createSequentialGroup()
                                                .addComponent(lX)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtX , javax.swing.GroupLayout.PREFERRED_SIZE , 69 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING , pWHXYLayout.createSequentialGroup()
                                                .addComponent(lY)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtY , javax.swing.GroupLayout.PREFERRED_SIZE , 69 , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(14 , Short.MAX_VALUE))
        );
        pWHXYLayout.setVerticalGroup(
                pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pWHXYLayout.createSequentialGroup()
                                .addGroup(pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pWHXYLayout.createSequentialGroup()
                                                .addGroup(pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lWidth)
                                                        .addComponent(txtWidth , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lHeight)
                                                        .addComponent(txtHeight , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pWHXYLayout.createSequentialGroup()
                                                .addGroup(pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtX , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lX))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pWHXYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtY , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lY))))
                                .addGap(0 , 18 , Short.MAX_VALUE))
        );

        mousePosition.setBackground(new java.awt.Color(204 , 204 , 204));
        mousePosition.setFont(new java.awt.Font("Dialog" , 0 , 12)); // NOI18N
        mousePosition.setForeground(new java.awt.Color(0 , 0 , 0));
        mousePosition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mousePosition.setText("X = 0 , Y = 0");

        btnBGColor.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout btnBGColorLayout = new javax.swing.GroupLayout(btnBGColor);
        btnBGColor.setLayout(btnBGColorLayout);
        btnBGColorLayout.setHorizontalGroup(
                btnBGColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 35 , Short.MAX_VALUE)
        );
        btnBGColorLayout.setVerticalGroup(
                btnBGColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 35 , Short.MAX_VALUE)
        );

        btnColor.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout btnColorLayout = new javax.swing.GroupLayout(btnColor);
        btnColor.setLayout(btnColorLayout);
        btnColorLayout.setHorizontalGroup(
                btnColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 56 , Short.MAX_VALUE)
        );
        btnColorLayout.setVerticalGroup(
                btnColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 54 , Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("DialogInput" , 0 , 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0 , 0 , 0));
        jLabel2.setText("Color");

        jLabel3.setFont(new java.awt.Font("DialogInput" , 0 , 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0 , 0 , 0));
        jLabel3.setText("BGcolor");

        txtThickness.setFont(new java.awt.Font("Dialog" , 0 , 14)); // NOI18N
        txtThickness.setText("0");

        colorsPanel.setBackground(new java.awt.Color(204 , 204 , 204));

        color1.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout color1Layout = new javax.swing.GroupLayout(color1);
        color1.setLayout(color1Layout);
        color1Layout.setHorizontalGroup(
                color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );
        color1Layout.setVerticalGroup(
                color1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        color2.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout color2Layout = new javax.swing.GroupLayout(color2);
        color2.setLayout(color2Layout);
        color2Layout.setHorizontalGroup(
                color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );
        color2Layout.setVerticalGroup(
                color2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        color3.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout color3Layout = new javax.swing.GroupLayout(color3);
        color3.setLayout(color3Layout);
        color3Layout.setHorizontalGroup(
                color3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );
        color3Layout.setVerticalGroup(
                color3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        color4.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout color4Layout = new javax.swing.GroupLayout(color4);
        color4.setLayout(color4Layout);
        color4Layout.setHorizontalGroup(
                color4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );
        color4Layout.setVerticalGroup(
                color4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );

        bgcolor4.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout bgcolor4Layout = new javax.swing.GroupLayout(bgcolor4);
        bgcolor4.setLayout(bgcolor4Layout);
        bgcolor4Layout.setHorizontalGroup(
                bgcolor4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );
        bgcolor4Layout.setVerticalGroup(
                bgcolor4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );

        bgcolor3.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout bgcolor3Layout = new javax.swing.GroupLayout(bgcolor3);
        bgcolor3.setLayout(bgcolor3Layout);
        bgcolor3Layout.setHorizontalGroup(
                bgcolor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );
        bgcolor3Layout.setVerticalGroup(
                bgcolor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        bgcolor2.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout bgcolor2Layout = new javax.swing.GroupLayout(bgcolor2);
        bgcolor2.setLayout(bgcolor2Layout);
        bgcolor2Layout.setHorizontalGroup(
                bgcolor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );
        bgcolor2Layout.setVerticalGroup(
                bgcolor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        bgcolor1.setPreferredSize(new java.awt.Dimension(60 , 60));

        javax.swing.GroupLayout bgcolor1Layout = new javax.swing.GroupLayout(bgcolor1);
        bgcolor1.setLayout(bgcolor1Layout);
        bgcolor1Layout.setHorizontalGroup(
                bgcolor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 25 , Short.MAX_VALUE)
        );
        bgcolor1Layout.setVerticalGroup(
                bgcolor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0 , 0 , Short.MAX_VALUE)
        );

        javax.swing.GroupLayout colorsPanelLayout = new javax.swing.GroupLayout(colorsPanel);
        colorsPanel.setLayout(colorsPanelLayout);
        colorsPanelLayout.setHorizontalGroup(
                colorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(colorsPanelLayout.createSequentialGroup()
                                .addComponent(bgcolor1 , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bgcolor2 , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bgcolor3 , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bgcolor4 , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(colorsPanelLayout.createSequentialGroup()
                                .addComponent(color1 , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(color2 , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(color3 , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(color4 , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        colorsPanelLayout.setVerticalGroup(
                colorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(colorsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(colorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING , false)
                                        .addComponent(color2 , javax.swing.GroupLayout.Alignment.LEADING , javax.swing.GroupLayout.DEFAULT_SIZE , 25 , Short.MAX_VALUE)
                                        .addComponent(color1 , javax.swing.GroupLayout.Alignment.LEADING , javax.swing.GroupLayout.DEFAULT_SIZE , 25 , Short.MAX_VALUE)
                                        .addComponent(color3 , javax.swing.GroupLayout.Alignment.LEADING , javax.swing.GroupLayout.DEFAULT_SIZE , 25 , Short.MAX_VALUE)
                                        .addComponent(color4 , javax.swing.GroupLayout.Alignment.LEADING , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED , 18 , Short.MAX_VALUE)
                                .addGroup(colorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING , false)
                                        .addComponent(bgcolor2 , javax.swing.GroupLayout.Alignment.TRAILING , javax.swing.GroupLayout.DEFAULT_SIZE , 25 , Short.MAX_VALUE)
                                        .addComponent(bgcolor1 , javax.swing.GroupLayout.Alignment.TRAILING , javax.swing.GroupLayout.DEFAULT_SIZE , 25 , Short.MAX_VALUE)
                                        .addComponent(bgcolor3 , javax.swing.GroupLayout.DEFAULT_SIZE , 25 , Short.MAX_VALUE)
                                        .addComponent(bgcolor4 , javax.swing.GroupLayout.PREFERRED_SIZE , 25 , javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4 , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0 , 0 , 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING , false)
                                        .addComponent(jLabel2 , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(btnColor , javax.swing.GroupLayout.PREFERRED_SIZE , 56 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBGColor , javax.swing.GroupLayout.PREFERRED_SIZE , 35 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3 , javax.swing.GroupLayout.PREFERRED_SIZE , 67 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(colorsPanel , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(59 , 59 , 59)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(thickness , javax.swing.GroupLayout.PREFERRED_SIZE , 129 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtThickness , javax.swing.GroupLayout.PREFERRED_SIZE , 60 , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED , 38 , Short.MAX_VALUE)
                                                .addComponent(pWHXY , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING , jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                                .addComponent(mousePosition , javax.swing.GroupLayout.PREFERRED_SIZE , 129 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnColor , javax.swing.GroupLayout.PREFERRED_SIZE , 54 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnBGColor , javax.swing.GroupLayout.PREFERRED_SIZE , 35 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel3 , javax.swing.GroupLayout.PREFERRED_SIZE , 28 , javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(colorsPanel , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(thickness , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(txtThickness , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0 , 0 , Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING , jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(pWHXY , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(mousePosition , javax.swing.GroupLayout.PREFERRED_SIZE , 31 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0 , 0 , Short.MAX_VALUE))
                                                        .addComponent(jPanel4 , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                                .addContainerGap())))
        );

        whiteBoard.setBackground(new java.awt.Color(255 , 255 , 255));

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel1 , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE)
                                        .addComponent(whiteBoard , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31 , 31 , 31)
                                .addComponent(jPanel1 , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(whiteBoard , javax.swing.GroupLayout.DEFAULT_SIZE , 477 , Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    private void afterInitComponents() {
        final int defaultThickness = 3;
        thickness.setValue(defaultThickness);
        txtThickness.setText(String.valueOf(defaultThickness));

        setMenu();
    }

    private ActionMenuItem actionMenuItem;

    private void setMenu() {
        actionMenuItem = new ActionMenuItem();

        final JMenu menuFile = new JMenu("File");

        final JMenuItem menuFileNew = new JMenuItem();
        setActionMenu(menuFileNew , KeyStroke.getKeyStroke(KeyEvent.VK_N , KeyEvent.CTRL_DOWN_MASK) , new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionMenuItem.createNew();
            }
        });
        menuFileNew.setText("Create new");

        final JMenuItem menuFileOpenImage = new JMenuItem();
        setActionMenu(menuFileOpenImage , KeyStroke.getKeyStroke(KeyEvent.VK_O , KeyEvent.CTRL_DOWN_MASK) , new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionMenuItem.fileOpenImage();
            }
        });
        menuFileOpenImage.setText("Open image");


        final JMenuItem menuFileSave = new JMenuItem();
        setActionMenu(menuFileSave , KeyStroke.getKeyStroke(KeyEvent.VK_S , KeyEvent.CTRL_DOWN_MASK) , new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionMenuItem.fileSave();
            }
        });
        menuFileSave.setText("Save");

        final JMenuItem menuFileSaveAs = new JMenuItem();
        setActionMenu(menuFileSaveAs , null , new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionMenuItem.fileSaveAs();
            }
        });
        menuFileSaveAs.setText("Save as");

        final JMenuItem menuFileExit = new JMenuItem();
        setActionMenu(menuFileExit , null , new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        menuFileExit.setText("Exit");

        menuFile.add(menuFileNew);
        menuFile.add(menuFileOpenImage);
        menuFile.add(menuFileSave);
        menuFile.add(menuFileSaveAs);
        menuFile.add(menuFileExit);

        final JMenu menuEdit = new JMenu("Edit");

        final JMenuItem menuEditUndo = new JMenuItem();
        setActionMenu(menuEditUndo , null , new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionMenuItem.editUndo();
            }
        });
        menuEditUndo.setText("Undo");

        menuEdit.add(menuEditUndo);


        final JMenuItem drawnShapes = new JMenuItem(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionMenuItem.drawnShapes();
            }
        });
        drawnShapes.setText("Drawn Shapes");

        menu.add(menuFile);
        menu.add(menuEdit);
        menu.add(drawnShapes);
    }

    private void setActionMenu(JMenuItem menuItem , final Object value , Action action) {
        if (value != null) action.putValue(Action.ACCELERATOR_KEY , value);
        menuItem.setAction(action);
    }

    private final class ActionMenuItem {
        private final SaveAsImage saveAsImage;

        public ActionMenuItem() {
            saveAsImage = new SaveAsImage(whiteBoard);
        }

        private void createNew() {
            questionForSave(() -> whiteBoard.clear());
        }

        private void fileOpenImage() {
            whiteBoard.setBackground();
        }

        private void fileSave() {
            saveAsImage.save();
            if (saveAsImage.isSave()) {
                saved = true;
                mousePosition.text("Saved!" , Color.GREEN);
            }
        }

        private void fileSaveAs() {
            saveAsImage.saveAs();
            if (saveAsImage.isSave()) {
                saved = true;
                mousePosition.text("Saved!" , Color.GREEN);
            }
        }

        private void editUndo() {
            whiteBoard.ctrlZ();
        }

        private void drawnShapes() {
            new DrawnShapes(PaintView.this);
        }
    }

    // </editor-fold>

    public WhiteBoard getWhiteBoard() {
        return whiteBoard;
    }

    @bardiademon
    // Variables declaration - do not modify
    private ToolsButtons bucketOfPaint;
    private ToolsButtons circleShape;
    private ToolsButtons cloudCalloutShape;
    private ToolsButtons colorPicker;
    private ToolsButtons diamondShape;
    private ToolsButtons downArrowShape;
    private ToolsButtons eraser;
    private ToolsButtons fivePointStarShape;
    private ToolsButtons fourPointStarShape;
    private ToolsButtons heartShape;
    private JPanel hexagonShape;
    public JCheckBox isFill;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JRadioButton jRadioButton1;
    public JSlider thickness;
    private ToolsButtons leftArrowShape;
    private ToolsButtons lightningShape;
    private ToolsButtons line;
    private ToolsButtons ovalCalloutShape;
    private WhiteBoard whiteBoard;
    private ToolsButtons pen;
    private ToolsButtons pentagonShape;
    private ToolsButtons polygonShape;
    private ToolsButtons rectShape;
    private ToolsButtons rightArrowShape;
    private ToolsButtons rightTriangleShape;
    private ToolsButtons roundRectShape;
    private ToolsButtons roundedRectangleCalloutShape;
    private ToolsButtons sixPointStarShape;
    private ToolsButtons squareShape;
    private ToolsButtons text;
    private ToolsButtons triangleShape;
    private ToolsButtons upArrowShape;


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

    public MousePosition mousePosition;

    private ToolsButtons image;


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

    private JPanel colorsPanel;

    private JMenuBar menu;
    // End of variables declaration
}
