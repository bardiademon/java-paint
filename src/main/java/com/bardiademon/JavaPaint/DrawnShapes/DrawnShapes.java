package com.bardiademon.JavaPaint.DrawnShapes;

import com.bardiademon.JavaPaint.PaintView;
import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public final class DrawnShapes extends JFrame
{
    private final PaintView paintView;
    private final List <WhiteBoard.ArrangePainting> arrangePaintings;

    public DrawnShapes (final PaintView _PaintView)
    {
        this.paintView = _PaintView;

        arrangePaintings = paintView.getWhiteBoard ().getArrangePaintings ();

        initComponents ();
        setVisible (true);

        listDrawnShapes.add ();
        scroll.setPreferredSize (new Dimension (scroll.getWidth () , scroll.getHeight ()));
    }

    public void repaint ()
    {
        paintView.getWhiteBoard ().repaint ();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents ()
    {
        // Variables declaration - do not modify
        JLabel lblDrawnShapes = new JLabel ();
        listDrawnShapes = new ListDrawnShapes (paintView.getWhiteBoard ().getTools () , arrangePaintings , () -> paintView.getWhiteBoard ().repaint ());
        scroll = new JScrollPane (listDrawnShapes , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        lblDrawnShapes.setFont (new java.awt.Font ("Dialog" , Font.PLAIN , 18)); // NOI18N
        lblDrawnShapes.setText ("Drawn Shapes");

        scroll.setBackground (new java.awt.Color (255 , 255 , 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout (getContentPane ());
        getContentPane ().setLayout (layout);
        layout.setHorizontalGroup (
                layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (layout.createSequentialGroup ()
                                .addGap (14 , 14 , 14)
                                .addComponent (lblDrawnShapes , javax.swing.GroupLayout.PREFERRED_SIZE , 348 , javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup (layout.createSequentialGroup ()
                                .addContainerGap ()
                                .addComponent (scroll , javax.swing.GroupLayout.PREFERRED_SIZE , 342 , javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup (
                layout.createParallelGroup (javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup (javax.swing.GroupLayout.Alignment.TRAILING , layout.createSequentialGroup ()
                                .addGap (14 , 14 , 14)
                                .addComponent (lblDrawnShapes)
                                .addPreferredGap (javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent (scroll , javax.swing.GroupLayout.PREFERRED_SIZE , 652 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap (javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE))
        );

        pack ();
    }// </editor-fold>

    public interface WhiteBoardRepaint
    {
        void repaint ();
    }

    // Start of variables declaration
    private ListDrawnShapes listDrawnShapes;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration
}
