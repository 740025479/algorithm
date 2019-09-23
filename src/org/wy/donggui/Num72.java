package org.wy.donggui;

public class Num72 {

    /**
     * 要求每次只能三种操作，可由此为切入点思考状态转移方程，
     * 二维dp数组的意义是什么，dp[i][j]标识源字符串前i位到目标字符串第j位的最短距离
     * 那么dp[i][j]=Math.min(dp[i][j-1]+1, dp[i-1][j]+1, src.CharAt(i-1)==tar.CharAt(j-1)?dp[i-1][j-1]:dp[i-1][j-1]+1)
     * 状态转移方程中min函数的三个元素分别代表插入，删除，(是否)替换
     */
    public int minDistance(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();
        int[][] res = new int[length1+1][length2+1];
        for (int i = 0; i < length1+1; i++) {
            res[i][0]=i;
        }
        for (int i = 0; i < length2+1; i++) {
            res[0][i]=i;
        }
        for (int i = 1; i < length1+1; i++) {
            for (int j = 1; j < length2+1; j++) {
                int temp = res[i-1][j-1];
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    res[i][j]=Math.min(temp,Math.min(res[i-1][j]+1,res[i][j-1]+1));
                }else {
                    res[i][j]=Math.min(temp+1,Math.min(res[i-1][j]+1,res[i][j-1]+1));
                }
            }
        }
        return res[length1][length2];

    }
}
