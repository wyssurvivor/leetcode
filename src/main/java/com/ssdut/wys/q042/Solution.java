package com.ssdut.wys.q042;

/**
 * Created by Ryan on 17/5/9.
 */

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[n1.length()+n2.length()];
        for(int i=0; i<n1.length(); i++){
            for(int j=0; j<n2.length(); j++){
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<d.length; i++){
            int digit = d[i]%10;
            int carry = d[i]/10;
            if(i+1<d.length){
                d[i+1] += carry;
            }
            sb.insert(0, digit);
        }

        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public long multiply(String num, int multi) {
        long result = 0;
        int jw = 0;
        for(int i = num.length()-1;i>=0;i--) {
            int number = num.charAt(i) - '0';
            int left = (number*multi)%10 + jw;
            jw = (number*multi)/10;
            result+=left*Math.pow(10,num.length()-i-1);
        }

        if(jw > 0) {
            result+=jw*Math.pow(10, num.length());
        }

        return result;
    }

    public String itoa(long num) {
        String result = "";
        while(num > 0) {
            long left = num%10;
            result=(char)(left+'0')+result;
            num = num/10;
        }
        if(result == "") {
            return "0";
        }
        return result;
    }

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";
        int multi = 2;
        Solution solution = new Solution();
        System.out.println(solution.multiply(num1, num2));
    }
}
