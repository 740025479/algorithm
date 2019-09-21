package org.wy.donggui;

import java.util.List;

public class Num120 {
    /**
     * 方法：递归，自顶向下
     * 思路：遍历所有
     * 缺陷：重复计算了
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        return min(0,0,triangle);
    }
    private int min(int level,int index,List<List<Integer>> triangle){

        if (level==triangle.size()-1){
            return triangle.get(level).get(index);
        }
        int left = min(level+1,index,triangle);
        int right = min(level+1,index+1,triangle);
        return Math.min(left,right)+triangle.get(level).get(index);
    }


    /**
     * 目的：改进上面重复计算的问题
     * 方法：记忆化搜索，即用某数据结构记录我们已经计算过的数值，下次再遇到就不再计算。这里我们用二维数组记录
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int[][] record = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        return min2(0,0,triangle,record);
    }
    private int min2(int level,int index,List<List<Integer>> triangle,int[][] record){
        if (record[level][index]!=0){return record[level][index];}
        if (level==triangle.size()-1){return record[level][index]=triangle.get(level).get(index);}
        int left = min2(level+1,index,triangle,record);
        int right = min2(level+1,index+1,triangle,record);
        record[level][index]=Math.min(left,right)+triangle.get(level).get(index);
        return record[level][index];
    }

    /**
     * 循环法
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int[] record = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >=0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                record[j]=Math.min(record[j],record[j+1])+triangle.get(i).get(j);
            }
        }
        return record[0];
    }


}
