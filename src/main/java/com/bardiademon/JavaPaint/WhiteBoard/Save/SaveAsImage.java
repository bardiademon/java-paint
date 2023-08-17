package com.bardiademon.JavaPaint.WhiteBoard.Save;

import com.bardiademon.JavaPaint.WhiteBoard.WhiteBoard;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;

public final class SaveAsImage {
    private final WhiteBoard whiteBoard;
    private File oldPath;

    private boolean save;

    final JFileChooser chooser = new JFileChooser();

    public SaveAsImage(final WhiteBoard whiteBoard) {
        this.whiteBoard = whiteBoard;
        chooser.setFileFilter(new FileNameExtensionFilter("PNG" , ".png"));
    }

    public void save() {
        save(oldPath);
    }

    private void save(File file) {
        if (file != null) {
            if (FilenameUtils.getExtension(file.getPath()).equals(""))
                file = new File(file.getPath() + ".png");

            final BufferedImage image = new BufferedImage(whiteBoard.getWidth() , whiteBoard.getHeight() , BufferedImage.TYPE_4BYTE_ABGR);
            whiteBoard.print(image.getGraphics());
            try {
                ImageIO.write(image , "png" , file);
                oldPath = file;
                save = true;
            } catch (IOException e) {
                save = false;
            }
        } else saveAs();
    }

    public void saveAs() {
        File file = choose();
        if (file != null) save(file);
    }

    public boolean isSave() {
        return save;
    }

    private File choose() {
        chooser.setSelectedFile(oldPath);
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.OPEN_DIALOG) return chooser.getSelectedFile();
        else return null;
    }
}
