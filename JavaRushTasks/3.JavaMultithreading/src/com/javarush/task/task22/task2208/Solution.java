package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE

"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"

*/
public class Solution {
    public static void main(String[] args) {
//        Map<String, String> map1 = new HashMap();
//
//        map1.put("city","Kiev");
//        map1.put("country","Ukraine");
//        map1.put("name","Ivanova");
//
//        System.out.println(getQuery(map1));
    }

    public static String getQuery(Map<String, String> params){
        StringBuilder str = new StringBuilder();
        int count = 0;

        for(Map.Entry<String,String> pair : params.entrySet()){
            if(pair.getValue() != null){
                count++;
                str.append(pair.getKey()).append(" = ").append("\'").append(pair.getValue()).append("\'");

                if(count < params.size() ){
                    str.append(" and ");
                }
            }
        }
        return str.toString();
    }
}
