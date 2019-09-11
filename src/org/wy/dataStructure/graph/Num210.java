package org.wy.dataStructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Num210 {


    /**
     * 基于广搜
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] rudu = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            rudu[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (rudu[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int tempCourse = queue.poll();
            res[index++] = tempCourse;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] != tempCourse) {
                    continue;
                }
                if (--rudu[prerequisite[0]] == 0) {
                    queue.offer(prerequisite[0]);
                }
            }
        }
        if (index == numCourses) {
            return res;
        }
        return new int[0];
    }


    /**
     * 基于深搜，配合栈
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {

        Stack<Integer> res = new Stack<>();
        int[][] graph = new int[numCourses][numCourses];

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]][prerequisite[0]] = 1;

        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {

            if (dfs(res, graph, i, visited)) {
                return new int[0];
            }

        }
        int count = 0;
        int[] ans = new int[numCourses];
        while (!res.isEmpty()) {
            ans[count] = res.pop();
            count++;
        }
        return ans;

    }

    /**
     * true表示有环，visited[]值为1表示在当前dfs访问中，为2表示之前dfs过了
     */
    private boolean dfs(Stack<Integer> res, int[][] graph, int index, int[] visited) {

        if (visited[index] == 1) {
            return true;
        }
        if (visited[index] == 2) {
            return false;
        }
        visited[index] = 1;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (dfs(res, graph, i, visited)) {
                    return true;
                }
            }
        }
        visited[index] = 2;
        res.push(index);
        return false;
    }


}
