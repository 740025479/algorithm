package org.wy.dataStructure.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Num1042 {

    /**
     * 每一个变量或者对象或者方法，必须要清楚它的意义是什么
     * @param N
     * @param paths
     * @return
     */
    public int[] gardenNoAdj(int N, int[][] paths)  {

        /** map中value选择list还是set是有讲究的，根据需求来 */
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        /** 初始化 */
        for (int i = 0; i < N; i++) {
            graph.put(i,new ArrayList<>());
        }

        /** 根据paths赋值  注意：传入值为1时表示的是第一个花园，但是在map中，第一个花园对应的下标是0*/
        for (int[] path : paths) {
            graph.get(path[0]-1).add(path[1]-1);
            graph.get(path[1]-1).add(path[0]-1);
        }

        /** 此数组表示结果，如res[i]即表示第i+1个花园中哪种花 */
        int[] res = new int[N];
        /** 遍历，种花 */
        for (int i = 0; i < N; i++) {
            /** 此数组下标1-4表示1-4种花被使用的情况，因为每当种花之前，得看相邻的花园种了哪些花 */
            boolean[] used = new boolean[5];
            for (Integer integer : graph.get(i)) {
                used[res[integer]] = true;
            }
            for (int j = 1; j < used.length; j++) {
                if (!used[j]){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * main测试的结果为，null可以被当做元素加到链表中，并且链表的size会对应加一
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.size());
        list.add(null);
        System.out.println(list.size());

        List<Product> linkedList = new LinkedList<>();
        linkedList.add(new Product(1));
        System.out.println(linkedList.size());
        linkedList.add(null);
        System.out.println(linkedList.size());
        linkedList.add(new Product(2));
        System.out.println(linkedList.size());
        for (Product product : linkedList) {
            System.out.println(product.i);
        }

    }

}

class Product{
    int i;

    public Product(int i) {
        this.i = i;
    }
}
