package com.solution;

import java.util.*;
/*
127. Word Ladder
https://leetcode.com/problems/word-ladder/description/
 */

public class WordLadder {
    int change = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        helper(beginWord, endWord, wordList, 0, -1, set);
        System.out.print((change == Integer.MAX_VALUE) ? 0 : change);
        return (change == Integer.MAX_VALUE) ? 0 : change;

    }

    private boolean helper(String beginWord, String endWord, List<String> wordList, int i, int k, Set<String> set) {
        if (endWord.equals(beginWord)) {
            change = Math.min(i + 1, change);
            return true;
        } else {
            for (int j = 0; j < wordList.size(); j++) {
                if (set.contains(wordList.get(j)) || j == k) continue;

                if (checkChange(beginWord, wordList.get(j))) {

                    if (set.add(wordList.get(j))) {
                        helper(wordList.get(j), endWord, wordList, i + 1, j, set);
                        set.remove(wordList.get(j));
                    }
                }
            }
        }
        return false;
    }

    private boolean checkChange(String s1, String s2) {
        boolean onceMatch = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (onceMatch) {
                    return false;
                }
                onceMatch = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordLadder obj = new WordLadder();
        List<String> lst = new ArrayList<>(Arrays.asList("hot", "dog"));
        /*
        "hot"
        "dog"
        ["hot","dog","dot"]
         */

        String begin = "hot";
        String end = "dog";

        List<String> lst1 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        String begin1 = "hit";
        String end1 = "cog";

        String begin2 = "hot";
        String end2 = "dog";
        List<String> lst2 = new ArrayList<>(Arrays.asList("hot", "dog", "dot"));

        String begin3 = "a";
        String end3 = "c";
        List<String> lst3 = new ArrayList<>(Arrays.asList("a", "b", "c"));
         obj.ladderLength(begin, end, lst);
//        obj.ladderLength(begin1, end1, lst1);
//        obj.ladderLength(begin2, end2, lst2);
//        obj.ladderLength(begin3, end3, lst3);

    }
}
