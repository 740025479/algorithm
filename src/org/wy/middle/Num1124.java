package org.wy.middle;

public class Num1124 {

    public static int longestWPI(int[] hours) {

        boolean[] input = new boolean[hours.length];
        int num = 0;
        for (int i = 0; i < hours.length; i++) {
            input[i]=hours[i]>8?true:false;
            num+=hours[i]>8?1:0;
        }
        if (num==0)return 0;
        int res=0;
        for (int i = 0; i < hours.length; i++) {
            if (i>0&&input[i-1])num--;
            int temp = num;
            for (int j = hours.length-1; j >=0 ; j--) {
                if (temp<=0)break;
                if (temp*2>j-i+1)res=Math.max(res,j-i+1) ;
                if (input[j])temp--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{6,6,9};
        longestWPI(input);
    }

}
