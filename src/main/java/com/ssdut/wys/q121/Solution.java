package com.ssdut.wys.q121;

/**
 * Created by wangyongshan on 17-3-20.
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if(prices.length<2) {
            return 0;
        }
        int minprice = prices[0];
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            minprice = Math.min(minprice, prices[i]);
            maxprofit = Math.max(maxprofit, prices[i] - minprice);
        }

        return maxprofit;
    }
}
