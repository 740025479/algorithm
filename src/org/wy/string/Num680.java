package org.wy.string;

public class Num680 {

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int p = 0;
        int q = chars.length-1;
        int deleteCount = 1;
        while (p<q){
            if (chars[p]!=chars[q]){
                /** 逻辑有问题，为什么先判断p+1再判断q-1，人为地添加了顺序 */
                if (chars[p+1]==chars[q] && deleteCount>0){
                    p+=2;
                    q--;
                    deleteCount--;
                }else if (chars[p]==chars[q-1] && deleteCount>0){
                    q-=2;
                    p++;
                    deleteCount--;
                }else {
                    return false;
                }
            }else {
                p++;
                q--;
            }
        }
        return true;
    }


    public boolean validPalindrome3(String s) {
        char[] chars = s.toCharArray();
        int p = 0;
        int q = chars.length-1;
        for (;p<q;p++,q--){
            if (chars[p]!=chars[q]){
                return  (isPalindrome(s,p+1,q) || isPalindrome(s,p,q-1));
            }
        }
        return true;
    }

    private boolean isPalindrome(String s,int p,int q){
        char[] chars = s.toCharArray();
        for (;p<q;p++,q--){
            if (chars[p]!=chars[q]){
                return false;
            }
        }
        return true;
    }








    public boolean validPalindrome2(String s) {
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0,i)+s.substring(i+1,s.length());
            if (isPalindrome(temp)){
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        int p = 0;
        int q = chars.length-1;
        while (p<q){
            if (chars[p]!=chars[q]){
                return false;
            }else {
                p++;
                q--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcd";
        System.out.println(a.substring(0,0)+a.substring(4,4));
    }


}
