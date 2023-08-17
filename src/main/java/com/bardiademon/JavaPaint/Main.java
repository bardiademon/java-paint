package com.bardiademon.JavaPaint;

import java.io.File;

import java.net.URLDecoder;

import org.apache.commons.io.FilenameUtils;

@bardiademon
public final class Main {

    @bardiademon
    public static final String PATH_ICON = System.getProperty("user.dir") + File.separator + "Icon" + File.separator;

    @bardiademon
    public static void main(String[] args) {
        new PaintView();
    }

    @bardiademon
    public static File getFile(String name) {
        final String extension = FilenameUtils.getExtension(name);
        if (extension == null || extension.equals("")) name += ".png";
        final File file = new File(PATH_ICON + name);
        if (file.exists()) return file;
        else return null;
    }
}
