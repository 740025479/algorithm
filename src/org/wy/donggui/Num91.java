package org.wy.donggui;

public class Num91 {

    /**
     * f(n)=f(n-1)+f(n-2)
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int length = s.length();

        int[] dp = new int[length+1];
        dp[0]=1;
        dp[1]= (s.charAt(0)=='0'?0:1);
        for (int i = 2; i < length+1; i++) {
//            int temp =Integer.valueOf(""+s.charAt(i-2)+s.charAt(i-1));
//            int temp2 = Integer.valueOf(""+s.charAt(i-1));
//            dp[i]=(temp2>0&&temp2<27?dp[i-1]:0)+('0'!=s.charAt(i-2)&&temp<27&&temp>0?dp[i-2]:0);

            if (s.charAt(i-1)=='0'){
                char temp = s.charAt(i-2);
                if (temp=='1'||temp=='2'){dp[i]=dp[i-2];}
            }else {
                if (s.charAt(i-2)=='1'||(s.charAt(i-2)=='2'&&(s.charAt(i-1))<'7')){
                    dp[i]=dp[i-1]+dp[i-2];
                }else {
                    dp[i]=dp[i-1];
                }
            }


        }
        return dp[length];
    }

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(Integer.valueOf(""+s.charAt(3-2)+s.charAt(3-1)));
        System.out.println(numDecodings("12"));
        System.out.println(Integer.valueOf('3'));
    }
}
