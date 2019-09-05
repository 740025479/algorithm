package org.wy.azl397985856;

import java.util.Stack;

/**
 * 判断字符串是否满足规则
 */
public class Num0020 {


    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (isLeft(aChar)){
                stack.push(aChar);
            }else {
                if (stack.isEmpty()){return false;}
                if (!isMatch(stack.pop(),aChar)){return false;}
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(char a){
        if ('{' == a || '['==a || '('==a){return true;}
        return false;
    }

    private boolean isMatch(char left,char right){
        if ((left=='{'&&right=='}')||(left=='['&&right==']')||(left=='('&&right==')')){return true;}
        return false;
    }

}
