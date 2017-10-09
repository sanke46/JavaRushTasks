package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties pr = new Properties();

        try {
            Path path = Paths.get(fileName);
            if (path.getFileName().toString().toLowerCase().endsWith(".xml")) {
                pr.loadFromXML(new FileInputStream(path.toFile()));
            } else {
                pr.load(new FileInputStream(path.toFile()));
            }
        } catch (Exception e) { }

        return pr;
    }
}
