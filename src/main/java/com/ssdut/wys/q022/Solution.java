package com.ssdut.wys.q022;

/**
 * Created by Ryan on 17/4/16.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate("", result, 0, 0, n);
        return result;
    }

    private void generate(String par, List<String> result, int lcount, int rcount, int n) {
        if(lcount==n&&rcount==n) {
            if(!par.equals(""))
                result.add(par);
            return;
        }

        if(lcount<n) {
            generate(par+"(", result, lcount+1, rcount, n);
        }
        if(rcount<n && rcount<lcount) {
            generate(par+")", result, lcount, rcount+1, n);
        }
    }

    public void printList(List<String> list) {
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args ) {
        int n=0;
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(n);
        solution.printList(result);
    }
}
