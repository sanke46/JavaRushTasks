package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream("/Users/ilafedoseev/name.txt");
        FileOutputStream writer = new FileOutputStream("/Users/ilafedoseev/name2.txt");

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        byte[] array = new byte[reader.available()];
        reader.read(array);
        String str = new String(array,utf8);
        array = str.getBytes(windows1251);
        writer.write(array);

        reader.close();
        writer.close();
    }
}
