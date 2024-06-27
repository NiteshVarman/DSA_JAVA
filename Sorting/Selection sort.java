import java.util.*;
public class arrays
{
    public static void selectionsort(int a[])
    {
        for(int i=0;i<a.length-1;i++)
        {
            int min=i;
            for(int j=i+1;j<a.length;j++)
            {
                if(a[min]>a[j])
                {
                    min=j;
                }
            }
            int temp=a[min];
            a[min]=a[i];
            a[i]=temp;
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
    }
    public static void main(String args[])
    {
        int a[]={7,1,3,5,6,4};
        selectionsort(a);
    }
}