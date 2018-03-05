package com.help.test;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1000; i > 0; i--) {
            set.add(i);
            map.put(i, i + 1);
        }
        List<Map.Entry<Integer, Integer>> lst = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
//        Collections.sort(lst, ((o1, o2) -> Integer.compare(o1.getValue(),o2.getValue())));
//        Collections.sort(lst, ((o1, o2) -> o1.getValue().compareTo(o2.getValue())));
        lst.stream().sorted(((o1, o2) -> o1.getValue().compareTo(o2.getValue())));
        System.out.println(lst);
    }
}
