import java.util.*;
public class Arrays
{
    public static void insertionsort(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            int key=a[i];
            int j=i-1;
            while(j>=0 && a[j]>key)
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
    public static void main(String args[])
    {
        int a[]={7,1,3,5,6,4};
        insertionsort(a);
    }
}