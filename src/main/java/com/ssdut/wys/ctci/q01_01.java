package com.ssdut.wys.ctci;

/**
 * Created by Ryan on 17/3/19.
 */

/**
 * Implement an algorithm to determine if a string has all unique characters
 * What if you can not use additional data structures?
 */
public class q01_01 {
    public static boolean isUnique(String val) {
        int[] buckets = new int[26];
        for(int i = 0;i<val.length();i++) {
            buckets[val.charAt(i)-'a']++;
        }

        for(int i=0;i<buckets.length;i++) {
            if(buckets[i]>1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abc"));
        System.out.println(isUnique("fdfwoef"));
        System.out.println(isUnique(""));
    }
}
