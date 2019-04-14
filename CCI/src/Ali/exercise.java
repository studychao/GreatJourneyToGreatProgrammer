package Ali;

public class exercise {
    static int memo[] = new int[100];

    public static int fib(int n)
    {
        if (n == 0)
        {
            return 1;
        }
        if (n == 1)
        {
            return 1;
        }
        if (memo[n]> 0)
        {
            return memo[n];
        }
        memo[n]=fib(n-1) + fib(n-2);
        return memo[n];
    }

    public static void main (String[] args)
    {
        for(int i =0;i<20;i++)
        {
            System.out.print(fib(i));
            System.out.print(" ");
        }
    }
}
