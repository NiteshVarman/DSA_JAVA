import java.util.*;
public class arrays
{
    public static boolean staircasesearch(int a[][],int k)
    {
        int r=0;
        int c=a[0].length-1;
        while(r<a.length && c>=0)
        {
            if(a[r][c]==k)
            {
                System.out.print("found at ("+r+","+c+")");
                return true;
            }
            else if(k<a[r][c])
            {
                c--;
            }
            else
            {
                r++;
            }
            
        }
        System.out.print("Not found");
        return false;
    }
    public static void main(String args[])
    {
        int a[][]={{10,20,30,40},
                    {15,25,35,45},
                    {27,29,37,48},
                    {32,33,39,50}};
        int k=33;
        staircasesearch(a,k);
    }
}