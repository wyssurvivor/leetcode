package com.ssdut.wys.clrschap15;

/**
 * Created by Ryan on 17/3/25.
 */
public class LCS {
    public int getLCS(String str1, String str2) {
        int[][] count=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<count[0].length;i++) {
            count[0][i] = 0;
        }

        for(int i=0;i<count.length;i++) {
            count[i][0] = 0;
        }

        for(int i=1;i<count.length;i++) {
            for(int j=1;j<count[i].length;j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    count[i][j] = count[i-1][j-1]+1;
                } else {
                    count[i][j] = Math.max(count[i-1][j],count[i][j-1]);
                }
            }
        }

        return count[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String str1 = "abcbdab";
        String str2 = "bdcaba";
        LCS lcs = new LCS();
        System.out.println(lcs.getLCS(str1, str2));
    }
}
