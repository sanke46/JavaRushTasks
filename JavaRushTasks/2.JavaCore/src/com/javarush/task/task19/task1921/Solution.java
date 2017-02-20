package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat sdf = new SimpleDateFormat("d MM yyyy");

        while(fileReader.ready()) {
            String[] line = fileReader.readLine().split(" ");
            String name = "";

            int hit = line.length - 3;

            if(hit == 1) {
                name = line[0];
            } else if(hit == 2){
                name = line[0] + " " + line[1];
            } else if(hit == 3){
                name = line[0] + " " + line[1] + " " + line[2];
            }

            int day = Integer.parseInt(line[hit]);
            int month = Integer.parseInt(line[hit + 1]);
            int year = Integer.parseInt(line[hit + 2]);

            String birthday = day + " " + month + " " + year;
            PEOPLE.add(new Person(name,sdf.parse(birthday)));
        }

        fileReader.close();
    }
}
