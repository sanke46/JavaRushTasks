package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        String name = f.getName();
        if (f.isDirectory()) {
            return true;
        }

        if (name.contains(".")) {
            String text = name.substring(name.indexOf("."));
            return text.equalsIgnoreCase(".html") || text.equalsIgnoreCase(".htm");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
