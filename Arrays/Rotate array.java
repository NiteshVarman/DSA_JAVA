import java.util.*;
public class arrays
{
    public static void rotate(int a[],int target)
    {
        int b[]=new int [a.length];
        int c=0;
        for(int i=target;i<=a.length-1;i++)
        {
            b[c]=a[i];
            c++;
        }

        for(int i=0;i<target;i++)
        {
            b[c]=a[i];
            c++;
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.println(b[i]);
        }
    }
    public static void main(String args[])
    {
        int a[]={0,1,2,4,5,6,7};
        int target=2;
        rotate(a,target);

    }
}