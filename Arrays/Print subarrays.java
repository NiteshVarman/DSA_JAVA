import java.util.*;
public class arrays
{
    public static void printsubarrays(int a[],int n)
    {
        for(int i=0;i<=n-1;i++)
        {
            int s=i;
            for(int j=i;j<n;j++)
            {
                int e=j;
                for(int k=s;k<=e;k++)
                {
                    System.out.print(a[k]+" ");
                }
                System.out.println();
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
        printsubarrays(a,n);
    }
}