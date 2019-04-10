package BestTimeToBuy2;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit[] = new int[n-1];
        int maxprofit=0;
        for (int i = 0;i < n-1;i++)
        {
            profit[i] = prices[i+1]-prices[i];
        }
        for (int i=0;i<n-1;i++)
        {
            if (profit[i] >0)
            {
                maxprofit = maxprofit + profit[i];
            }
        }
        return maxprofit;

    }
}