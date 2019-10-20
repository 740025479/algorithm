package org.wy.dataStructure.tree.dicTree;

public class Num211 {

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

    /** Initialize your data structure here. */
    public Num211() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root,word);
    }

    private boolean search(Node cur,String word){

        if (word==null || word.length()==0)return false;
        char[] words = word.toLowerCase().toCharArray();
        for (int i = 0; i < words.length; i++) {
            if (words[i]=='.'){
                boolean res = false;
                for (Node child : cur.children) {
                    if (child!=null){
                        if (i==words.length-1){
                            res |= child.isWord;
                        }else
                        res |= search(child,word.substring(i+1));
                    }
                }
                return res;
            }
            int index = words[i]-'a';
            if (cur.children[index]==null)return false;
            if (i==words.length-1 && cur.children[index].isWord==false){
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Num211 num211 = new Num211();
        num211.addWord("bad");
        num211.search("b..");
    }

}
