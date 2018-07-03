package com.freelance.stringmanipulation;// you can also use imports, for example:
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Solution {
    public String solution(String S) {
        // write your code in Java SE 8
        String[] row = S.split("\\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate newDate;
        
        LocalDate minDate = LocalDate.parse("18 Jul 2004", formatter);
        int maxSize = 81920;
        
        int i =0;
        for(String data : row){
            String date = data.substring(0, 11).trim();
            Integer size = Integer.valueOf(data.substring(12, 22).trim());
            String name = data.substring(23).trim();

            newDate = LocalDate.parse(date, formatter);

            if(newDate.isAfter(minDate)){
                if(maxSize > size){
                    if(name.endsWith(".txt") || name.endsWith(".html") || name.endsWith(".xml")){
                        i++;
                    }
                }
            }
        }
        
        return i > 0 ? String.valueOf(i) : "NO FILES";
    }
}