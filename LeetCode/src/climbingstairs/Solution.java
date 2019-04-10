package climbingstairs;

//  Recursion with Memoization
class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        return climbStairs(0,n,memo);
    }
    public int climbStairs(int a, int b,int[] memo){
        if (a == b)
        {
            return 1;
        }
        if (a > b)
        {
            return 0;
        }
        if (memo[a] > 0)
        {
            return memo[a];
        }
        memo[a] = climbStairs(a+1,b,memo) + climbStairs(a+2,b,memo);
        return memo[a];
    }
}