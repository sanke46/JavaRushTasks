package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //System.out.println(new Solution(4));
        FileOutputStream outStream = new FileOutputStream(new File("/Users/Tanya/name.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(outStream);
        Solution solOne = new Solution(7);
        oos.writeObject(solOne);

        oos.close();

        FileInputStream fileInputStream = new FileInputStream(new File("/Users/Tanya/name.txt"));
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Solution solTwo = new Solution(12);
        solTwo = (Solution) ois.readObject();

        if((solTwo.toString()).equals(solOne.toString())){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
