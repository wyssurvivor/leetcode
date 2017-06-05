package com.ssdut.wys.q017;

/**
 * Created by Ryan on 17/4/15.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {
    private Map<Integer, String> digitToCharMap = new HashMap<Integer, String>();
    public Solution() {
        digitToCharMap.put(2, "abc");
        digitToCharMap.put(3, "def");
        digitToCharMap.put(4, "ghi");
        digitToCharMap.put(5, "jkl");
        digitToCharMap.put(6, "mno");
        digitToCharMap.put(7, "pqrs");
        digitToCharMap.put(8, "tuv");
        digitToCharMap.put(9, "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        combinations(digits, 0, "", result);
        return result;
    }

    private void combinations(String digits, int index, String comb, List<String> result) {
        if(index>=digits.length()) {
            if(!comb.equals("")) {
                result.add(comb);
            }
            return ;
        }

        int digit = digits.charAt(index)-'0';
        String chars = digitToCharMap.get(digit);
        for(int i=0;i<chars.length();i++) {
            combinations(digits, index+1, comb+chars.charAt(i), result);
        }
    }

    public void printList(List<String> list) {
        for(int i=0;i<list.size();i++) {
            if(list.get(i).equals("")) {
                System.out.println("empty");
            } else {
                System.out.println(list.get(i));
            }

        }
    }

    public static void main(String[] args) {
        String digits = "234";
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations(digits);
        solution.printList(result);
    }
}
