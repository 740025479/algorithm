package org.wy.string;

import java.util.HashSet;

public class Num409 {

    public int longestPalindrome(String s) {

        int count = 0;
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])){
                count++;
                set.remove(chars[i]);
            }else {
                set.add(chars[i]);
            }
        }
        return set.isEmpty()?count*2:count*2+1;
    }





    public int longestPalindrome2(String s) {
        int res = 0;
        int[] count = new int[57];
        for (char c : s.toCharArray()) {
            count[c-65]++;
        }
        for (int i = 0; i < count.length; i++) {
            res+=count[i]/2*2;
            if (res%2==0 && count[i]%2==1){
                res++;
            }
        }
        return res;
    }


}
