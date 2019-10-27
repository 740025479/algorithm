package org.wy.middle;

public class Num1201 {

    public int nthUglyNumber(int n, int a, int b, int c) {

        long chengA = 1;
        long chengB = 1;
        long chengC = 1;
        int index = 0;
        long res = 0;
        while (index < n) {
            if (a*chengA < b*chengB) {
                if (a*chengA < c*chengC) {
                    res = a*chengA;
                    chengA++;
                }else if (a*chengA==c*chengC){
                    res = a*chengA;
                    chengA++;
                    chengC++;
                }else {
                    res = c*chengC;
                    chengC++;
                }
            }else if (a*chengA==b*chengB){
                if (a*chengA < c*chengC) {
                    res = a*chengA;
                    chengA++;
                    chengB++;
                }else if (a*chengA==c*chengC){
                    res = a*chengA;
                    chengA++;
                    chengC++;
                    chengB++;
                }else {
                    res = c*chengC;
                    chengC++;
                }
            }else {
                if (b*chengB<c*chengC){
                    res = b*chengB;
                    chengB++;
                }else if (b*chengB==c*chengC){
                    res = b*chengB;
                    chengB++;
                    chengC++;
                }else {
                    res = c*chengC;
                    chengC++;
                }
            }
            index++;
        }
        return (int) res;
    }


}
