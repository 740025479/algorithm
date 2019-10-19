package org.wy.dataStructure.tree.dicTree;

import java.util.*;

public class Num720 {


    public String longestWord(String[] words) {

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Set<String> set = new HashSet<>();
        String res = "";
        set.add(res);
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("b", "a");
        map.put("aa", "b");
        map.put("a", "a");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

}
