package org.wy.dataStructure.tree.dicTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Num212 {


    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.build(word,trie.root);
        }
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,trie.root,i,j,visited,set);
            }
        }
        res.addAll(set);
        return res;
    }


    private void dfs(char[][] board, Node root, int row, int col,boolean[][] visited, Set<String> set) {
        if (visited[row][col])return;
        char curChar = board[row][col];
        Node next = root.children[curChar-'a'];
        if (next==null)return;
        if (next.isWord){
            set.add(next.val);
        }
        visited[row][col]=true;
        if (row>0){
            dfs(board,next,row-1,col,visited,set);
        }
        if (row<board.length-1){
            dfs(board,next,row+1,col,visited,set);
        }
        if (col>0){
            dfs(board,next,row,col-1,visited,set);
        }
        if (col<board[0].length-1){
            dfs(board,next,row,col+1,visited,set);
        }
        visited[row][col]=false;
    }


    class Node{
        private boolean isWord;
        private String val;
        private Node[] children;
        private int childrenNum = 26;
        public Node() {
            isWord = false;
            children = new Node[childrenNum];
        }
    }

    class Trie{
        private Node root;

        public Trie() {
            root = new Node();
        }

        public void build(String word,Node cur){
            char[] chars = word.toLowerCase().toCharArray();
            for (char aChar : chars) {
                if (cur.children[aChar-'a']==null){
                    cur.children[aChar-'a']=new Node();
                }
                cur = cur.children[aChar-'a'];
            }
            cur.isWord = true;
            cur.val = word;
        }

    }


    public List<String> findWords2(char[][] board, String[] words) {
        int step = 0;
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> set = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(i,j,board,step,word,set,visited);
                }
            }
        }
        res.addAll(set);
        return res;
    }

    private void dfs(int i, int j, char[][] board, int step, String word, Set<String> res, boolean[][] visited) {
        if (visited[i][j])return;
        char cur = board[i][j];
        if (word.charAt(step)!=cur)return;
        if (step==word.length()-1){res.add(word);return;}
        visited[i][j]=true;
        if (i>0){dfs(i-1,j,board,step+1,word,res,visited);}
        if (i<board.length-1){dfs(i+1,j,board,step+1,word,res,visited);}
        if (j>0){dfs(i,j-1,board,step+1,word,res,visited);}
        if (j<board[0].length-1){dfs(i,j+1,board,step+1,word,res,visited);}
        visited[i][j]=false;
    }

}
