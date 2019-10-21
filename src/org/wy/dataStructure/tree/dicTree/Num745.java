package org.wy.dataStructure.tree.dicTree;

import java.util.*;

/**
 * 字典树每个节点存储经过该节点的字符串的权重，即下标
 */
public class Num745 {

    private class Node{
        private List<Integer> weights;
        private Node[] nexts;

        public Node(List<Integer> weights, Node[] nexts) {
            this.weights = weights;
            this.nexts = nexts;
        }

        public Node() {
            weights = new ArrayList<>();
            nexts = new Node[26];
        }
    }


    private Node prefix;
    private Node suffix;


    public Num745(String[] words) {
        prefix = new Node();
        suffix = new Node();
        /** map去重 */
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],i);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            buildTree(entry.getKey(),prefix,entry.getValue());
            buildTree(new StringBuilder(entry.getKey()).reverse().toString(),suffix,entry.getValue());
        }

    }

    private void buildTree(String word,Node node,int weight){
        char[] chars = word.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i==0)node.weights.add(weight);
            if (node.nexts[chars[i]-'a']==null){
                node.nexts[chars[i]-'a'] = new Node();
            }
            node.nexts[chars[i]-'a'].weights.add(weight);
            node = node.nexts[chars[i]-'a'];
        }
    }

    private void buildTree(String word,int index, Node node , int weight){
        if (index==word.length())return;
        if (node.nexts[word.charAt(index)-'a']==null){
            node.nexts[word.charAt(index)-'a'] = new Node();
        }
        node.nexts[word.charAt(index)-'a'].weights.add(weight);
        buildTree(word,index+1,node.nexts[word.charAt(index)-'a'],weight);
    }

    public int f(String prefix, String suffix) {
        int res = -1;
        List<Integer> preList = search(prefix,this.prefix);
        if (preList==null)return res;
        List<Integer> sufList = search(new StringBuilder(suffix).reverse().toString(),this.suffix);
        if (sufList==null)return res;
        Set<Integer> set = new HashSet<>();
        set.addAll(sufList);
        for (Integer element : preList) {
            if (set.contains(element)){
                res = Math.max(res,element);
            }
        }
        return res;
    }

    private List<Integer> search(String word,Node node){
        for (int i = 0; i < word.length(); i++) {
            if (node.nexts[word.charAt(i)-'a']==null)return null;
            node = node.nexts[word.charAt(i)-'a'];
        }
        return node.weights;
    }


    public static void main(String[] args) {
        Num745 num745 = new Num745(new String[]{"apple"});
        num745.f("a","e");
    }

}

