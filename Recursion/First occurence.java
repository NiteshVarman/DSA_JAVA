class Recursion {
    public static int first(int a[],int k,int i) {
        if(i==a.length) {
            return -1;
        }
        if (a[i] == k) {
            return i;
        } 
        return first(a,k,i+1);
    }

public static void main(String args[]) {
        int a[] = {8,3,6,9,5,10,2,5,3};
        System.out.print(first(a,5,0));
    }
}
