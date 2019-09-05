package org.wy.string;

import java.util.Arrays;

public class Num14 {

    public String longestCommonPrefix(String[] strs) {

        if (!checkValid(strs)) {
            return "";
        }

        Arrays.sort(strs);
        StringBuilder res = new StringBuilder();
        int length = Math.min(strs[0].length(), strs[strs.length - 1].length());
        for (int i = 0; i < length; i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return res.toString();
    }

    private boolean checkValid(String[] strs) {
        if (strs==null || strs.length==0) return false;
        for (String str : strs) {
            if (str == null || "".equals(str)) {
                return false;
            }
        }
        return true;
    }

}
