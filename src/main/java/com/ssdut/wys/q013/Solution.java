package com.ssdut.wys.q013;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryan on 17/4/6.
 */
public class Solution {
    Map<Character, Integer> romanToIntMap = new HashMap<Character, Integer>();
    public Solution() {
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        int sum=romanToIntMap.get(s.charAt(0));

        for(int i=1;i<s.length();i++) {
            if(romanToIntMap.get(s.charAt(i-1))<romanToIntMap.get(s.charAt(i))) {
                sum+=romanToIntMap.get(s.charAt(i))-2 * romanToIntMap.get(s.charAt(i-1));
            } else {
                sum+=romanToIntMap.get(s.charAt(i));
            }
        }

        return sum;
    }

    public static void main(String [] args) {
        Solution solution = new Solution();
        String s = "XCIX";
        System.out.println(solution.romanToInt(s));
    }
}
