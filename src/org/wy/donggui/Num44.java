package org.wy.donggui;

import java.util.ArrayList;
import java.util.List;

public class Num44 {

    public boolean isMatch(String s, String p) {
        int length1 = s.length();
        int length2 = p.length();
        boolean[][] dp = new boolean[length1+1][length2+1];
        dp[0][0] = true;
        for (int i = 1; i < length2+1; i++) {
//            dp[0][i]=dp[0][i-1]&p.charAt(i-1)=='*';
            if (p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*'){
                    /** 星号分为两种用途，1是代表一个或多个字符，2是代表空字符 */
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[length1][length2];
    }

}
