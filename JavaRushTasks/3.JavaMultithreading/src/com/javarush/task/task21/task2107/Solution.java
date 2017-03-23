package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        for(Map.Entry<String, User> pair : users.entrySet()){
            solution.users.put(pair.getKey(),pair.getValue().clone());
        }

        return solution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }

        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || this.getClass()!=o.getClass()) return false;
            if (!(o instanceof User)) return false;
            if (age != ((User) o).age) return false;
            if (name != null ? !name.equals(((User) o).name) : ((User) o).name != null) return false;

            return true;
        }

        public int hashCode(){
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
