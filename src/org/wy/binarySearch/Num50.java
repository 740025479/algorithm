package org.wy.binarySearch;


/**
 * 注意负数除法
 */

public class Num50 {


    public double myPow(double x, int n) {

        double res =1 ;
        for (int i = n; i!=0  ; i/=2) {
            if (n%2!=0){
                res*=x;
            }
            x*=x;
        }
        return n>0?res:1/res;

    }


    public static void main(String[] args) {
        System.out.println((-3)/2);
        System.out.println((-3)%2);
        System.out.println((-4)/2);
        System.out.println((-5)/2);
        System.out.println((-1)/2);
    }

}
