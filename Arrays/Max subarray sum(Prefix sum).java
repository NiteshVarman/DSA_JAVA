import java.util.*;
public class arrays
{
    public static void maxsubarraysum(int a[],int n)
    {
        int c=0;
        int prefix[]=new int[n];
        int m=Integer.MIN_VALUE;
        prefix[0]=a[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+a[i];
        }
        for(int i=0;i<=n-1;i++)
        {
            int s=i;
            for(int j=i;j<n;j++)
            {
                int e=j;
                c= s==0 ? prefix[e] : prefix[e]-prefix[s-1];
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