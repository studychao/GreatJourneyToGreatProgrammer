package BestTimeToBuy;

public class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 0;
        int maxprofit = 0;
        int min = Integer.MAX_VALUE;
        int n = prices.length;
        for (i = 0; i< n;i++)
        {
            if (prices[i]<min)
            {
                min = prices[i];
            }
            else if (prices[i]-min >maxprofit)
            {
                maxprofit = prices[i]-min;
            }
        }
        return maxprofit;
    }
}
