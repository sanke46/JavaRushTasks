package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            if (fileScanner.hasNext()) {
                String[] inputArray = fileScanner.nextLine().split(" ");
                Date birthDate = (new GregorianCalendar(Integer.parseInt(inputArray[5]),Integer.parseInt(inputArray[4]) - 1, Integer.parseInt(inputArray[3]))).getTime();
                return new Person(inputArray[1],inputArray[2],inputArray[0],birthDate);
            }
            return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
