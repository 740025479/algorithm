package org.wy.dataStructure.graph;

import java.util.*;

public class Num310 {

    /**
     * 用的别人的思路，从叶子节点开始扒洋葱
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] du = new int[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            du[edge[0]]++;
            du[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (du[i] == 1) {
                queue.offer(i);
            }
        }

        int rest = n;
        while (rest > 2) {
            int size = queue.size();
            while (size-- > 0) {
                int temp = queue.poll();
                rest--;
                for (Integer integer : graph.get(temp)) {
                    du[integer]--;
                    if (du[integer] == 1) {
                        queue.offer(integer);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }


}
