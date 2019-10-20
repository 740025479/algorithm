package org.wy.dataStructure.tree.dicTree;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class Node{
        private boolean isLeaf;
        private int dul_num;//重复的字符串数
        private int prefix_num;//包含此前缀的字符串数，当前节点也算
        private Map<Character,Node> children;

        public Node() {
            isLeaf = false;
            dul_num = 0;
            prefix_num = 0;
            children = new HashMap<>();
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word){
        Node cur = root;
        char[] words = word.toLowerCase().toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (cur.children.get(words[i])==null){
                cur.children.put(words[i],new Node());
            }
            Node node = cur.children.get(words[i]);
            node.prefix_num++;
            cur = node;
            if (i==word.length()-1){
                node.dul_num++;
                node.isLeaf = true;
            }
        }
    }
    public boolean search(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Node node = cur.children.get(word.charAt(i));
            if (node==null)return false;
            cur = node ;
            if (i==word.length()-1&& !node.isLeaf)return false;
        }
        return true;
    }
    public boolean startsWith(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            Node node = cur.children.get(prefix.charAt(i));
            if (node==null)return false;
            cur = node ;
        }
        return true;
    }

}
