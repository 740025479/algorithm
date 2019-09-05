package org.wy.azl397985856;

public class Num0026 {


    public int rmDuplicates(int[] a){

        int resNode = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i]!=a[resNode]){
                resNode++;
                a[resNode] = a[i];
            }
        }

        return resNode+1;

    }

}
