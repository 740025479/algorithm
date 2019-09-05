package org.wy.middle;

import java.util.ArrayList;
import java.util.List;

public class Num6 {


    /**
     * 找每一行字符对应的字符串下标的规律，然后逐行输出
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int gap = 2 * numRows - 2;

        for (int i = 0; i < numRows  && i < s.length(); i++) {

            int init = (2 * numRows - 2 - i);
            int start = i;
            while (start < s.length() || init < s.length()) {

                if (start < s.length()) {

                    res.append(s.charAt(start));
                    start += (2 * numRows - 2);
                }
                if (i!=init && init-i!=gap && init < s.length()) {
                    res.append(s.charAt(init));
                    init += (2 * numRows - 2);
                }
            }
        }
        return res.toString();

    }


    /**
     * 按照规则依次排字符串的字符，每次排字符时，把字符加到对应行的string
     *
     *
     * 收获：指针在一个范围内上下移动，到了顶点就往下，到了底部就往上
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if (numRows==1){return s;}
        List<StringBuilder> list = new ArrayList<>();
        int curNode = 0;
        int maxRow = Math.min(numRows,s.length());
        for (int i = 0; i < maxRow; i++) {
            list.add(new StringBuilder());
        }
        char[] chars = s.toCharArray();
        boolean reverse = false;
        for (char aChar : chars) {
            list.get(curNode).append(aChar);
            if (curNode==0||curNode==numRows-1){reverse=!reverse;}
            curNode+=(reverse==false?-1:1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : list) {
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();
    }


}
