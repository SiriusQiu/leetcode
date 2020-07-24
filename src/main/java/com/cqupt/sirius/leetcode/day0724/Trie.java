package com.cqupt.sirius.leetcode.day0724;

public class Trie {
    static class Node{
        int count = 0;
        Node[] childs = new Node[26];
    }
    Node head = null;
    int nullCount = 0;
    /** Initialize your data structure here. */
    public Trie() {
        head = new Node();
        head.count = -1;

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0 ) {
            nullCount++;
            return;
        }
        char[] chars = word.toCharArray();
        Node cur = head;
        for (int i = 0; i < chars.length;i++){
            Node node = cur.childs[chars[i]-'a'];
            if (node==null){
                node = new Node();
                cur.childs[chars[i]-'a'] = node;
            }
            cur = node;
        }
        cur.count++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0 ) {
            return nullCount>0;
        }
        char[] chars = word.toCharArray();
        Node cur = head;
        for (int i = 0; i < chars.length;i++){
            Node node = cur.childs[chars[i]-'a'];
            if (node==null){
                return false;
            }
            cur = node;
        }
        return cur.count>0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0 ) {
            return true;
        }
        char[] chars = prefix.toCharArray();
        Node cur = head;
        for (int i = 0; i < chars.length;i++){
            Node node = cur.childs[chars[i]-'a'];
            if (node==null){
                return false;
            }
            cur = node;
        }
        return true;
    }
}
