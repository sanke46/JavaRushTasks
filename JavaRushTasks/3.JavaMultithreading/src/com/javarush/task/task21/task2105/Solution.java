package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if(this == o){
            return true;
        }

        if (!(o instanceof Solution)) {
            return false;
        }

        Solution n = (Solution) o;

        if((first != null || Objects.equals(first, n.first)) == (last != null || Objects.equals(last, n.last))){
            return true;
        } else {
            return false;
        }
    }

    public int hashCode(){
        int result = 1;

        if(first != null){
            result = result * 31 * first.hashCode();
        }

        if(last != null){
            result = result * 31 * last.hashCode();
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
