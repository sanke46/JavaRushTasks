package com.javarush.task.task20.task2002;

import sun.java2d.pipe.SpanShapeRenderer;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
//        try {
            File your_file_name = File.createTempFile("/Users/Tanya/name.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

//            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            User user = new User();
//            user.setFirstName("Vasya");
//            user.setLastName("Batareikin");
//            user.setBirthDate(format.parse("01 04 1989"));
//            user.setMale(true);
//            user.setCountry(User.Country.RUSSIA);
//            javaRush.users.add(user);
//            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));


            outputStream.close();
            inputStream.close();

//        } catch (IOException e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with my file");
//        } catch (Exception e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with save/load method");
//        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);

            for(User x : users){
                pw.println(x.getFirstName());
                pw.println(x.getLastName());
                pw.println(Long.parseLong(String.valueOf(x.getBirthDate())));
                pw.println(x.isMale());
                pw.println(x.getCountry());
            }
            pw.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String fName = reader.readLine();
            String lName = reader.readLine();
            long birthday = Long.valueOf(reader.readLine());
            boolean male = Boolean.parseBoolean(reader.readLine());
            String country = reader.readLine();

            User user = new User();
            user.setFirstName(fName);
            user.setLastName(lName);
            user.setBirthDate(new Date(birthday));
            user.setMale(male);
            if(country.equals("Ukraine")){
                user.setCountry(User.Country.UKRAINE);
            } else if(country.equals("Russia")){
                user.setCountry(User.Country.RUSSIA);
            } else {
                user.setCountry(User.Country.OTHER);
            }
            users.add(user);
            }

        }

    }

