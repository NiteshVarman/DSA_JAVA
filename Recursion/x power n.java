class Recursion {
    // public static int pow(int x,int n) {     //O(n)
    //     if ( n == 0 ) {
    //         return 1;
    //     }
    //     return x * pow(x, n-1);
    // }
    public static int pow(int x,int n) {        //O(log n)
        if(n == 0) {
            return 1;
        }
        int h = pow(x, n/2);
        int p = h * h;
        if(n %2 != 0) {
            p = x * p;
        }
        return p;
       }   
public static void main(String args[]) {
        System.out.print(pow(2,10));
    }
}
