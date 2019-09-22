package org.wy;

/**
 * 关键点，弄清乘法运算的流程
 */
public class BigNum {

    public static String multiply(String s1,String s2){
        int length1 = s1.length();
        int length2 = s2.length();
        int[] res = new int[length1+length2];
        int[] i1 = new int[length1];
        int[] i2 = new int[length2];
        for (int i = 0; i < length1; i++) {
            i1[i]= s1.charAt(length1-1-i)-'0';
        }
        for (int i = 0; i < length2; i++) {
            i2[i]=s2.charAt(length2-1-i)-'0';
        }

        /**
         * 关键！
         */
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                res[i+j]+=i1[i]*i2[j];
            }
        }



//        int internal = 0;
//        for (int i = 0; i < res.length; i++) {
//            res[i]+=internal;
//            internal = res[i]/10;
//            res[i]%=10;
//        }
        for (int i = 0; i < res.length-1; i++) {
            res[i+1]+=res[i]/10;
            res[i]%=10;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = res.length-1; i >=0 ; i--) {
            ans.append(res[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("567","232"));
    }

}
