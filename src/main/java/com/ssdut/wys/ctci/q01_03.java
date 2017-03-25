package com.ssdut.wys.ctci;

/**
 * Created by Ryan on 17/3/19.
 */

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer
 * NOTE: One or two additional variables are  ne An extra copy of the array is not
 */
public class q01_03 {

    public void removeDuplicateChars(char[] val) {
        if(val==null||val.length<2) {
            return;
        }

        int tail = 1;
        for(int i=1;i<val.length;i++) {
            int j=0;
            for(;j<tail;j++) {
                if(val[j] == val[i]) {
                    break;
                }
            }
            if(j==tail) {
                val[tail++]=val[i];
            }
        }

        val[tail]=0;
    }
}
