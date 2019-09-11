package org.wy.dataStructure.graph;

import java.util.*;

/**
 * 此题不用邻接列表表示图，用邻接矩阵,但是又不是直接邻接矩阵
 */
public class Num207 {


    /**
     * 广度优先搜索
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] rudu = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            rudu[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        /** 值和下标，注意区分 */
        for (int i = 0; i < numCourses; i++) {
            if (rudu[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int temp = queue.poll();
            numCourses--;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1]==temp){
                    rudu[prerequisite[0]]--;
                    if (rudu[prerequisite[0]]==0){
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }
        return numCourses==0;

    }


    /**
     * 深度优先搜索,通过DFS判断图中是否有环
     *
     * 根据别人的思路写的代码
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        int[] flags = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]][prerequisite[0]]=1;
        }
        for (int i = 0; i < numCourses; i++) {
            boolean temp = dfs(flags,i,graph);
            if (temp==false){
                return false;
            }
        }
        return true;
    }


    private boolean dfs(int[] flags,int index,int[][] graph){

        if (flags[index]==-1){return true;}
        if (flags[index]==1){return false;}
        flags[index]=1;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i]==1) {
                boolean temp = dfs(flags, i,graph);
                if (temp==false){return false;}
            }
        }
        flags[index]=-1;
        return true;
    }





}
