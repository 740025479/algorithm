package org.wy.middle;

public class Num8 {

    public static int myAtoi(String str) {
        if (str.length() == 0)
            return 0;
        boolean first = true;
        boolean zhengShu = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (first) {
                first = false;
                if (Character.isDigit(cur)) sb.append(cur);
                else if (cur == '-') zhengShu = false;
                else if (cur != '+') return 0;
            } else {
                if (Character.isDigit(cur)) sb.append(cur);
                else break;
            }
            if (cur == ' ') continue;
        }
        if (sb.length() == 0)
            return 0;
        int count = 0;
        while (count<sb.length()&&sb.charAt(count)=='0'){
            count++;
        }
        if (count==sb.length())return 0;
        String res = sb.substring(count);
        if (res.length() > 10) {
            if (zhengShu) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        long sum = 0;
        for (int i = 0; i < res.length(); i++) {
            sum = sum*10 + (res.charAt(i) - '0') ;
        }
        if (zhengShu) {
            if (sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else return (int) sum;
        }
        if (sum-1 > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        else return (int) -sum;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE+1);
        long a = Integer.MAX_VALUE+(long)1;
        System.out.println(a);
    }

}
