package org.wy.dataStructure.graph;

import java.util.List;

public class Num841 {



    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int roomNum = rooms.size();
        if (roomNum<2){return true;}
        boolean[] visited = new boolean[roomNum];
        visited[0]=true;
        digui(rooms,rooms.get(0),visited);
        for (boolean b : visited) {
            if (b==false){return false;}
        }
        return true;
    }


    /**
     * 此递归写的很不好看，因为乍一看没有结束条件
     * @param rooms
     * @param cur
     * @param visited
     */
    private static void digui(List<List<Integer>> rooms,List<Integer> cur,boolean[] visited){

        for (int i = 0; i < cur.size(); i++) {
            int temp = cur.get(i);
            if (visited[temp]==false){
                visited[temp]=true;
                digui(rooms,rooms.get(temp),visited);
            }
        }

    }

    /**
     * 好看的递归，并且思路清晰，而且最好把方法名换成方法对应的作用，方法名改为visit比较不错
     * @param rooms
     * @param roomIndex
     * @param visited
     */
    private static void digui2(List<List<Integer>> rooms,int roomIndex,boolean[] visited){
        if (visited[roomIndex]){return;}
        visited[roomIndex]=true;
        for (int i = 0; i < rooms.get(roomIndex).size(); i++) {
            digui2(rooms,rooms.get(roomIndex).get(i),visited);
        }
    }


}
