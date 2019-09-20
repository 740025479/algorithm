package org.wy.donggui;

public class Num96 {


    /**
     * f(n)表示长度为n的序列一共有f(n)种二叉搜索树
     * g(i,n)表示已第i个为根时，长度为n的序列有多少种二叉搜索树  g(i,n) = f(i-1)*f(n-i)
     * f(n)=g(1,n)+g(2,n)+```+g(n,n)
     * 写代码时先以实际意义为主，然后根据实际意义写代码
     * @param n
     * @return
     */
    public int numTrees(int n) {

        int[] res = new int[n+1];
        //因为递推公式为乘法
        res[0]=1;
        res[1]=1;
        for (int i = 2; i < n+1; i++) {
            int temp = 0;
            for (int j = 1; j < i+1; j++) {
                temp+=res[j-1]*res[i-j];
            }
            res[i]=temp;
        }
        return res[n];
    }

}
