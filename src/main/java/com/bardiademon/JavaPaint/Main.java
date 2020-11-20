package com.bardiademon.JavaPaint;

import java.io.File;

public class Main
{

    public static final String PATH_ICON = System.getProperty ("user.dir") + File.separator + "Icon" + File.separator;

    public static void main (String[] args)
    {
        new PaintView ();
    }

    public static File getFile (String name)
    {
        File file = new File (PATH_ICON + name + ".png");
        if (file.exists ()) return file;
        else return null;
    }
}
