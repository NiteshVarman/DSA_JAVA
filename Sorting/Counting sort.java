import java.util.*;
public class arrays
{
    public static void countingsort(int a[])
    {
        int l=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
        {
            l=Math.max(l,a[i]);
        }

        int count[]= new int[l+1];
        for(int i=0;i<a.length;i++)
        {
            count[a[i]]++;
        }

        int j=0;
        for(int i=0;i<count.length;i++)
        {
            while(count[i]>0)
            {
                a[j]=i;
                j++;
                count[i]--;
            }
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
    public static void main(String args[])
    {
        int a[]={7,1,3,5,6,4};
        countingsort(a);
    }
}