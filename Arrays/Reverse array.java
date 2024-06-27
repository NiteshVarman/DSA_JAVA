import java.util.*;
public class arrays
{
    public static void reverse(int a[],int n)
    {
        int f=0,l=n-1;
        while(f<l)
        {
            int temp=a[l];
            a[l]=a[f];
            a[f]=temp;
            f++;
            l--;
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
        reverse(a,n);
        for(int i=0;i<=n-1;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}