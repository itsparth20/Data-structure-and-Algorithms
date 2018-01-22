package com.solution;
import java.util.*;

public class NonConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(nonConsecutiveOnes(4));
    }

    public static List<String> nonConsecutiveOnes(int number) {
        List<String> lst = new ArrayList<>();
        if (number == 0) return lst;
        helper(number, "", lst);
        return lst;
    }

    public static void helper(int no, String s, List<String> lst) {
        int len = s.length();
        if (no == len) {
            lst.add(s);
            return;
        }
        helper(no, s + "0", lst);
        if ((len > 0 && s.charAt(len - 1) != '1') || (len == 0)) {
            helper(no, s + "1", lst);
        }
    }
}
