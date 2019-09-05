package org.wy.string;

public class Num5 {


    int maxLength = 0;
    int index = 0;

    public String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            tryLongest(chars,i,i);
            tryLongest(chars,i,i+1);
        }
        return s.substring(index,index+maxLength);
    }

    private void tryLongest(char[] chars, int left, int right) {

        while (left>=0 && right<chars.length) {
            if (chars[left] == chars[right]) {

                left--;
                right++;
            }else {
                break;
            }
        }
        if (maxLength<right-left-1){
            maxLength=right-left-1;
            index = left+1;
        }

    }


}
