import java.util.*;
public class arrays
{
    public static void maxsubarraysum(int a[],int n)
    {
        int c=0;
        int m=Integer.MIN_VALUE;
        for(int i=0;i<=n-1;i++)
        {
            int s=i;
            for(int j=i;j<n;j++)
            {
                int e=j;
                c=0;
                for(int k=s;k<=e;k++)
                {
                    c=c+a[k];
                }
                if(m<c)
                {
                    m=c;
                }
            }
        }
        System.out.println(m);
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
        maxsubarraysum(a,n);
    }
}