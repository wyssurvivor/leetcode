package com.ssdut.wys.Solutions;

import org.junit.Test;

import java.util.*;

/**
 * Created by Ryan on 17/5/14.
 */
/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class q048 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i=0;i<strs.length;i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            List<String> strList = map.get(sortedStr);
            if(strList == null) {
                strList = new ArrayList<String>();
                strList.add(strs[i]);
                map.put(sortedStr, strList);
            } else {
                strList.add(strs[i]);
            }
        }

        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            result.add(map.get(key));
        }

        return result;
    }

    public void print(List<List<String>> result) {
        for(int i=0;i<result.size();i++) {
            for(int j=0;j<result.get(i).size();j++) {
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testSolution() {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        q048 solution = new q048();
        solution.print(solution.groupAnagrams(strs));
    }


}
