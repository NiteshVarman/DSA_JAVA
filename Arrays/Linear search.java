import java.util.*;
public class arrays
{
    public static int linearsearch(int a[],int k,int n)
    {
        for(int i=0;i<=n-1;i++)
        {
            if (a[i]==k)
            {
                return i;
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
        int ind=linearsearch(a,k,n);
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