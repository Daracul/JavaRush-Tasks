package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("D:\\pack\\1.txt");
            InputStream inputStream = new FileInputStream("D:\\pack\\1.txt");

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(new User());
            javaRush.users.get(0).setFirstName("Alexey");
            javaRush.users.get(0).setLastName("Malakhov");
            Calendar date = new GregorianCalendar(1987,2,31);
            javaRush.users.get(0).setBirthDate(date.getTime());
            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
            javaRush.users.get(0).setMale(true);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            int length=users.size();
            writer.println(users.size());
            if (users!=null){
                for (User u:users){
                    writer.println(u.getFirstName());
                    writer.println(u.getLastName());
                    writer.println(u.getBirthDate().getTime());
                    writer.println(u.getCountry());
                    writer.println(u.isMale());
                }
            }
            writer.flush();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int userslength = Integer.parseInt(reader.readLine());
            System.out.println(userslength);
            if (userslength>0){
                while (reader.ready()){
                    for (int i=0;i<userslength;i++){
                        users.add(new User());
                        users.get(i).setFirstName(reader.readLine());
                        users.get(i).setLastName(reader.readLine());
                        users.get(i).setBirthDate(new Date(Long.parseLong(reader.readLine())));
                        users.get(i).setCountry(User.Country.valueOf(reader.readLine()));
                        users.get(i).setMale(Boolean.parseBoolean(reader.readLine()));
                    }
                }
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
