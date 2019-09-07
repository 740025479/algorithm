package org.wy.binarySearch;

/**
 * 二分查找
 * 1.如何取mid，取左中位数还是右中位数
 * 2.如何根据mid更新left和right
 */
public class Num69 {

    public int mySqrt(int x) {

        if (x==0){return 0;}
        if (x<4){return 1;}
        long right = x/2;
        long left = 0;
        while (left<right){
            /** 一定要取右中位数 , 因为left＝mid 如果取左中位数，然后左区间不推进，就无限循环*/
            long mid = left + (right-left)/2 +1;

            long ji = mid*mid;
            if (ji==x){return (int)mid;}
            if (ji<x){
                left = mid ;
            }else {
                right = mid -1;
            }
        }
        return (int)left;
    }

    public static void main(String[] args) {
        int x1 = 100000;
        long x2 = 100000;
        long k = x1*x2;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(k);
    }
}
