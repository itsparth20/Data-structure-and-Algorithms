package com.leetcode.wordserachII;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

//212. Word Search II
//https://leetcode.com/problems/word-search-ii/description/

public class WordSearchII {

    class Indexes {
        int i;
        int j;
        char ch;
        List<Indexes> indexes = new ArrayList<>();

        public Indexes(int i, int j, char ch) {
            this.i = i;
            this.j = j;
            this.ch = ch;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        Set<String> uniqueInputWords = new HashSet<>();
        Map<Character, Indexes> indexesMap = generateMap(board);
        List<String> outputList = new ArrayList<>();
        Set<String> existingStrSet = new HashSet<>();
        boolean matchFound;
        for (String word : words) {
            if (!uniqueInputWords.add(word)) {
                continue;
            }
            if (!indexesMap.containsKey(word.charAt(0))) {
                continue;
            }
            if (existingStrSet.contains(word)) {
                outputList.add(word);
                continue;
            }
            List<Indexes> listOfIndexes = indexesMap.get(word.charAt(0)).indexes;
            for (Indexes index : listOfIndexes) {
                matchFound = doesWordExist(existingStrSet, board, word, 0, index.i, index.j, "");
                if (matchFound) {
                    existingStrSet.add(word);
                    outputList.add(word);
                    break;
                }
            }
        }
        return outputList;
    }

    private Map<Character, Indexes> generateMap(char[][] board) {
        Map<Character, Indexes> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Character ch = board[i][j];
                Indexes obj = new Indexes(i, j, ch);
                map.putIfAbsent(ch, obj);
                map.get(ch).indexes.add(obj);
            }
        }
        return map;
    }

    private boolean doesWordExist(Set<String> strSet, char[][] board, String word, int k, int i, int j, String fewLetter) {

        if (word.equals(fewLetter)) {
            return true;
        }
        strSet.add(fewLetter);
        int length = board.length;

        if (i < 0 || j < 0 || i >= length || j >= board[i].length) {
            return false;
        }

        char currentChar = board[i][j];

        if (k < word.length() && word.charAt(k) != currentChar) {
            return false;
        }

        fewLetter += currentChar;
        board[i][j] = '*';
        if (doesWordExist(strSet, board, word, k + 1, i, j + 1, fewLetter) ||
                doesWordExist(strSet, board, word, k + 1, i, j - 1, fewLetter) ||
                doesWordExist(strSet, board, word, k + 1, i + 1, j, fewLetter) ||
                doesWordExist(strSet, board, word, k + 1, i - 1, j, fewLetter)) {
            board[i][j] = currentChar;
            return true;
        }
        board[i][j] = currentChar;
        return false;
    }

    public WordSearchII obj = null;

    @Before
    public void setup() {
        obj = new WordSearchII();
    }

    @Test
    public void testWordSearchForTwoMatch() {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        List<String> expectedArray = Arrays.asList("eat", "oath");
        List<String> outputArray = obj.findWords(board, words);
        Collections.sort(expectedArray);
        Collections.sort(outputArray);
        assertEquals(expectedArray, outputArray);
    }

    @Test
    public void testWordSearchForVerticalArray() {
        String[] words = {"baa", "abba", "baab", "aba"};
        char[][] board = {
                {'b'},
                {'a'},
                {'b'},
                {'b'},
                {'a'}
        };
        List<String> expectedArray = Arrays.asList("abba");
        List<String> outputArray = obj.findWords(board, words);
        Collections.sort(expectedArray);
        Collections.sort(outputArray);
        assertEquals(expectedArray, outputArray);
    }

    @Test
    public void testWordSearchForMixedCharacter() {
        String[] words = {"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        char[][] board = {
                {'a', 'b', 'c'},
                {'a', 'e', 'd'},
                {'a', 'f', 'g'}
        };
        List<String> expectedArray = Arrays.asList("abcdefg", "befa", "eaabcdgfa", "gfedcbaaa");
        List<String> outputArray = obj.findWords(board, words);
        Collections.sort(expectedArray);
        Collections.sort(outputArray);
        assertEquals(expectedArray, outputArray);
    }


/*
easy sweet solution
    public List<String> findWord(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                for (String word : words) {
                    if (exist(board, i, j, word, 0) && !res.contains(word))
                        res.add(word);
                }
            }
        return res;
    }

    private boolean exist(char[][] board, int i, int j, String word, int ind) {
        if (ind == word.length()) return true;
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
            return false;
        board[i][j] = '*';
        boolean result = exist(board, i - 1, j, word, ind + 1) ||
                exist(board, i, j - 1, word, ind + 1) ||
                exist(board, i, j + 1, word, ind + 1) ||
                exist(board, i + 1, j, word, ind + 1);
        board[i][j] = word.charAt(ind);
        return result;
    }
*/

}
