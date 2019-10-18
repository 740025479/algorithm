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

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,0},{1,2},{1,3}};
        System.out.println(test[2][1]);
        List<Integer> res = findMinHeightTrees2(4,test);
        System.out.println(res);
        test = new int[][]{{0,3},{1,3},{2,3},{4,3},{4,5}};
        res = findMinHeightTrees2(6,test);
        System.out.println(res);
    }

    /**
     * 暴力：以每个点为根，求得对应的树高，然后将最短的树高对应的根序号添加至结果
     *
     * @param n
     * @param edges
     * @return
     */
    public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int minHeight = n;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];
            int h = getHeightByRoot(i, graph, 0,visited);
            if (h < minHeight) {
                res.clear();
                res.add(i);
                minHeight=h;
            } else if (h == minHeight) {
                res.add(i);
            }
        }
        return res;
    }

    private static int getHeightByRoot(int rootIndex, Map<Integer, List<Integer>> graph, int h, int[] visited) {
        List<Integer> list = graph.get(rootIndex);
        boolean end = true;
        for (Integer check : list) {
            if (visited[check] == 0) {
                end = false;
                break;
            }
        }
        if (end)return h;
        visited[rootIndex] = 1;
        int height = 0;
        for (Integer level : list) {
            if (visited[level]!=1)
            height = Math.max(height, getHeightByRoot(level, graph, h + 1,visited));
        }
        return height;
    }

}
