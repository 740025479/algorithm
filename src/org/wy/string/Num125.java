package org.wy.string;

public class Num125 {


    public  boolean isPalindrome(String s) {

        char[] chars = s.toCharArray();
        int p =0;
        int q = chars.length-1;
        while (p<q){
            if (!Character.isLetterOrDigit(chars[p])){
                p++;
            }else if (!Character.isLetterOrDigit(chars[q])){
                q--;
            }else if (Character.toLowerCase(chars[p])!=Character.toLowerCase(chars[q])){
                return false;
            }else {
                p++;
                q--;
            }
        }
        return true;
    }

}
