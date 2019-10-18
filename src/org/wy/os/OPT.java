package org.wy.os;

import java.util.*;

/**
 * 操作系统页面置换算法
 * 最佳置换算法，其所选择的被淘汰的页面将是以后永不使用的，或是在最长（未来）时间内不再被访问的页面。
 */
public class OPT {

    static int swapFrequency;
    public static void opt(int[] src,int capacity) {

        Set<Integer> exist = new HashSet<>(capacity);
        for (int i = 0; i < src.length; i++) {
            if (exist.contains(src[i])) continue;
            if (exist.size() < capacity) {
                exist.add(src[i]);
            } else {
                Set<Integer> copy = new HashSet<>(capacity);
                for (Integer e : exist) {
                    copy.add(e);
                }
                int j = i + 1;
                while (copy.size() > 1 && j < src.length) {
                    if (copy.contains(src[j])) copy.remove(src[j]);
                    j++;
                }

                Iterator iterator = copy.iterator();
                exist.remove(iterator.next());
                exist.add(src[i]);
                swapFrequency++;
            }


        }
    }



    public static void main(String[] args) {
        int[] test = new int[]{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        System.out.println(test.length);
        opt(test,3);
        System.out.println(swapFrequency);
    }

}
