package org.wy.donggui;

public class Num62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[n-1][m-1];
    }

    int startIndex = 0;
    int resLength = 0;
    public String longestPalindrome(String s) {

        int length = s.length();
        if (length<2){return s;}
        for (int i = 0; i < length; i++) {
            find(s,i,i,length);
            find(s,i,i+1,length);
        }
        return s.substring(startIndex,startIndex+resLength);

    }

    private void find(String s,int left,int right,int length){

        while (left>=0&&right<length){
            if (s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        if (right-left-1>resLength){
            resLength=right-left-1;
            startIndex=left+1;
        }

    }


}
