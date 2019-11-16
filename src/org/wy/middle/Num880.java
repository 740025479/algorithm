package org.wy.middle;

import java.util.Stack;

public class Num880 {

    /**
     * size必须是long类型，否则会越界！！！
     * @param S
     * @param K
     * @return
     */
    public static String decodeAtIndex(String S, int K) {
        long size = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            if (Character.isLetter(S.charAt(i))){
                size++;
            }else {
                size*=(S.charAt(i)-'0');
            }
        }
//        if (K>size)
        for (int i = length-1; i >=0 ; i--) {
//            K%=size;
            if (Character.isLetter(S.charAt(i))){
                if (K==0||K==size){return S.charAt(i)+"";}
                else size--;
            }else {
                size/=(S.charAt(i)-'0');
                K%=size;
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        System.out.println(decodeAtIndex("a2345678999999999999999",1));
    }
}
