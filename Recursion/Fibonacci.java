class Recursion {
    public static int fib(int n) {
        if (n == 0 || n==1) {
            return n;
        } 
        int f=fib(n-1)+fib(n - 2);
        return f;
    }

public static void main(String args[]) {
        int n = 25;
        System.out.print(fib(n));
    }
}
