import java.util.*;
public class arrays
{
    public static void printpairs(int a[],int n)
    {
        for(int i=0;i<=n-1;i++)
        {
            int c=a[i];
            for(int j=i+1;j<n;j++)
            {
                System.out.print("("+c+","+a[j]+")");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<=n-1;i++)
        {
            a[i]=sc.nextInt();
        }
        printpairs(a,n);
    }
}