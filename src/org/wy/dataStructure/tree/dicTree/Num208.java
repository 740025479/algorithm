package org.wy.dataStructure.tree.dicTree;

public class Num208 {

    private class Node {
        private boolean isWord;
        private int prefix_num;//包括自己
        private int dul_num;
        private Node[] children;

        public Node(boolean isWord, int prefix_num, int dul_num, Node[] children) {
            this.isWord = isWord;
            this.prefix_num = prefix_num;
            this.dul_num = dul_num;
            this.children = children;
        }

        public Node() {
            isWord = false;
            prefix_num = 0;
            dul_num = 0;
            children = new Node[26];
        }
    }

    private Node root;


    /**
     * Initialize your data structure here.
     */
    public Num208() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node cur = root;
        char[] words = word.toLowerCase().toCharArray();
        for (int i = 0; i < words.length; i++) {
            int index = words[i] - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur.children[index].prefix_num++;
            if (i == words.length - 1) {
                cur.children[index].dul_num++;
                cur.children[index].isWord = true;
            }

            cur = cur.children[index];
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node cur = root;
        char[] words = word.toLowerCase().toCharArray();
        for (int i = 0; i < words.length; i++) {
            int index = words[i]-'a';
            if (cur.children[index]==null)return false;
            if (i==words.length-1 && cur.children[index].isWord==false){
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node cur = root;
        char[] words = prefix.toLowerCase().toCharArray();
        for (int i = 0; i < words.length; i++) {
            int index = words[i]-'a';
            if (cur.children[index]==null)return false;
            cur = cur.children[index];
        }
        return true;
    }
}
