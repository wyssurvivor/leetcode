package com.ssdut.wys.q012;

/**
 * Created by wangyongshan on 17-3-14.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Subscribe to see which companies asked this question.
 */
public class Solution {
    private Map<Integer, String> characterMap;
    private List<Integer> romanList;
    public Solution() {
        romanList = new ArrayList<Integer>(Arrays.asList(1000, 100, 10, 1));
        characterMap = new HashMap<Integer, String>();
        characterMap.put(1000, "M");
        characterMap.put(500, "D");
        characterMap.put(100, "C");
        characterMap.put(50, "L");
        characterMap.put(10, "X");
        characterMap.put(5, "V");
        characterMap.put(1, "I");

    }
    //mine
    public String intToRoman(int num) {
        String result = "";
        while (num > 0) {
            int index = 0;
            for (; index < romanList.size(); index++) {
                if (num / romanList.get(index) > 0) {
                    break;
                }
            }

            String internalResult = "";
            int numDivide = num / romanList.get(index);
            int numLeft = num % romanList.get(index);
            if (numDivide == 9) {
                internalResult = characterMap.get(romanList.get(index)) + characterMap.get(romanList.get(index - 1));
            } else if (numDivide == 4) {
                internalResult = characterMap.get(romanList.get(index)) + characterMap.get(5 * romanList.get(index));
            } else {
                int numFiveLeft = numDivide % 5;
                if (numDivide / 5 > 0) {
                    internalResult = characterMap.get(5 * romanList.get(index));
                }

                for (int i = 0; i < numFiveLeft; i++) {
                    internalResult += characterMap.get(romanList.get(index));
                }
            }

            result += internalResult;
            num = num % romanList.get(index);
        }
        return result;
    }

    //solution from web
    public String intToRomanWeb(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3999));
    }
}
