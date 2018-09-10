package com.leetcode.firstuniquecharacterinastring;

/*
387. First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 */
public class FirstUniqueCharacterInaString {

//     public int firstUniqChar(String s) {
//         if (s == null || s.trim().equals("")) return -1;
//         s = s.trim();
//         int l = s.length();
//         if (l == 1) return 0;
//         Map<Character, Integer> map = new HashMap<>();

//         for (int i = 0; i < l; i++){
//             map.merge(s.charAt(i), 1, (x,y)->x+y);
//         }

//         for (int i = 0; i < l; i++){
//             if (map.get(s.charAt(i)) == 1){
//                 return i;
//             }
//         }
//         return -1;
//     }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        int res = s.length();
        for (int i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            if (index == -1) continue;
            if (index == s.lastIndexOf(i))
                res = Math.min(res, index);
        }

        return res == s.length() ? - 1 : res;
    }
}

