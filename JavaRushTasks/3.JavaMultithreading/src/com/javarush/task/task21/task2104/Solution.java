package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(!(obj instanceof Solution)){
            return false;
        }

        Solution sol = (Solution) obj;

        if((first != null || Objects.equals(first, sol.first)) == (last != null || Objects.equals(last, sol.last))){
            return true;
        } else {
            return false;
        }

    }

    public int hashCode() {
        int result = 1;

        if(first != null){
            result = result * 31 + first.hashCode();
        }

        if(last != null){
            result = result * 31 + last.hashCode();
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
