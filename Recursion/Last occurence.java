class Recursion {
    public static int last(int a[],int k,int i) {
        if ( i==a.length ) {
            return -1;
        }
        int f = last(a,k,i+1);
        if(f==-1 && a[i] == k) {
            return i;
        }
        
        return f;
    }

public static void main(String args[]) {
        int a[] = {8,3,6,9,5,10,2,5,3};
        System.out.print(last(a,5,0));
    }
}
