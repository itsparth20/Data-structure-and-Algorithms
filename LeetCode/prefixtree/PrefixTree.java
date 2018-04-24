package com.leetcode.prefixtree;

import java.util.HashMap;
import java.util.Map;

/*
208. Implement Trie (Prefix Tree)
https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
public class PrefixTree {

    static class TrieNode {
        public Character value;
        public Map<Character, TrieNode> next = new HashMap<>();
        public boolean end = false;

        public TrieNode(Character value) {
            this.value = value;
        }
    }

    public TrieNode root;

    /** Initialize your data structure here. */
    public PrefixTree() {
        root = new TrieNode('\u0000');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        int index = 0;

        while (index < word.length()) {
            if (current.next.containsKey(word.charAt(index))) {
                current = current.next.get(word.charAt(index));
            } else {
                TrieNode node = new TrieNode(word.charAt(index));
                current.next.put(word.charAt(index), node);
                current = node;
            }
            index++;
        }
        current.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        current = isExist(word, current);
        return current == null ? false : current.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        return isExist(prefix, current) == null ? false : true;
    }

    private TrieNode isExist(String prefix, TrieNode current) {
        int index = 0;
        while (index < prefix.length()) {
            if (!current.next.containsKey(prefix.charAt(index))) {
                return null;
            } else {
                current = current.next.get(prefix.charAt(index));
            }
            index++;
        }
        return current;
    }
}

/**
 * Your PrefixTree object will be instantiated and called as such:
 * PrefixTree obj = new PrefixTree();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */