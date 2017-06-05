package com.ssdut.wys.q006;

/**
 * Created by Ryan on 17/4/2.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        String[] rows = new String[numRows];
        for(int i=0;i<s.length();i++) {
            int interIndex = i%(2*(numRows-1));
            int rowIndex = -1;
            if(interIndex<numRows) {
                rowIndex = interIndex;
            } else {
                rowIndex = 2*(numRows-1)-interIndex;
            }
            if(rows[rowIndex]==null) {
                rows[rowIndex] = "";
            }
            rows[rowIndex] += s.charAt(i);
        }

        String result = "";
        for(int i=0;i<numRows;i++) {
            if(rows[i]!=null) {
                result+=rows[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s="abcdefghijklmnopqrstuvwxyz";
        int numRows = 1;
        Solution solution = new Solution();
        System.out.println(solution.convert(s, numRows));
    }
}
