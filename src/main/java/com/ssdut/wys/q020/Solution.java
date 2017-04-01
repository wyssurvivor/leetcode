package com.ssdut.wys.q020;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 17/3/22.
 */
public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }

        List<Character> list = new ArrayList<Character>();
        for(int i=0;i<len;i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') {
                list.add(s.charAt(i));
            } else {
                if(list.size()==0) {
                    return  false;
                }
                char topChar = list.get(list.size()-1);
                if((topChar == '('&&s.charAt(i)==')')||
                        (topChar == '['&&s.charAt(i)==']')||
                        (topChar == '{'&&s.charAt(i)=='}')) {
                    list.remove(list.size()-1);
                } else {
                    return false;
                }
            }
        }

        if(list.size()==0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("("));
    }
}
