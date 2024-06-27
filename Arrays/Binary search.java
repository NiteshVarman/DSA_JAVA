import java.util.*;
public class arrays
{
    public static int binarysearch(int a[],int k,int n)
    {
        int s=0,e=n-1;
        while(s<=e)
        {
            int m=(s+e)/2;
            if(a[m]==k)
            {
                return m;
            }
            if(a[e]<k)
            {
                s=m+1;
            }
            else
            {
                e=m-1;
            }
        }
        return -1;
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
        int k=sc.nextInt();
        int ind=binarysearch(a,k,n);
        if (ind==-1)
        {
            System.out.print("Not Found");
        }
        else
        {
            System.out.print(ind);
        }
    }
}