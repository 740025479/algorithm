package org.wy.dataStructure.graph;

import java.util.*;

/**
 * 一个连通有向图G有欧拉路径，指存在一个顶点，从它出发，沿着有向边的方向，可以不重复地遍历图中所有的边
 */
public class Num332 {

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (graph.get(from) == null) {
                List<String> list = new LinkedList<>();
                list.add(to);
                graph.put(from, list);
            } else {
                graph.get(from).add(to);
            }
        }


        for (List<String> value : graph.values()) {
            Collections.sort(value);
        }

        List<String> res = new LinkedList<>();
        visit("JFK",graph,res);
        return res;

    }


    private void visit(String start, Map<String,List<String>> graph, List<String> res){
        List<String> list = graph.get(start);
        while (list!=null&&list.size()>0){
            String temp = list.remove(0);
            visit(temp,graph,res);
        }
        res.add(0,start);
    }


    static class Compare implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            List<String> list1 = (List<String>)o1;
            List<String> list2 = (List<String>)o2;
            for (int i = 0; i < list1.size(); i++) {
                String s1 = list1.get(i);
                String s2 = list2.get(i);
                if (s1.equals(s2))continue;
                for (int j = 0; j < s1.length(); j++) {
                    if (s1.charAt(j)==s2.charAt(j))continue;
                   int res = s1.charAt(j)>s2.charAt(j)? 1: 0;
                   return res;
                }
            }
            return 0;
        }
    }

    private static void digui(List<List<String>> res, String start, List<String> chosen, Map<String,List<String>> graph,int total){
        if (chosen.size()== total){
            res.add(chosen);
            return;
        }
        List<String> list = graph.get(start);
        if (list==null)return;
        for (int i = 0; i<list.size();i++) {
            List<String> temp = new ArrayList<>();
            for (String s1 : chosen) {
                temp.add(s1);
            }
            temp.add(list.get(i));
            list.remove(list.get(i));
            digui(res,list.get(i),temp,graph,total);
            list.add(list.get(i));
        }
    }

}
