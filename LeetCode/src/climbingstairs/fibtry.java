package climbingstairs;

public class fibtry {
    static int memo[] = new int[100];
    static int fib(int a)
    {
        if (a == 1)
            return 1;
        if (a == 0)
            return 0;
        if (memo[a]> 0 ) {
            return memo[a];

        }
        memo[a] =  fib(a-1) + fib(a-2);
        return memo[a];
    }
    public static void main(String[] args) {
        DynamicProgram a = new DynamicProgram();
        System.out.println(a.climbstairs(3));
    }
}
