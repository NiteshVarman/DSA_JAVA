import java.util.*;
public class arrays
{
    public static void diagonalsum(int a[][])
    {
        int sum=0;
        // for(int i=0;i<=a.length;i++) //O(n^2)
        // {
        //     for(int j=0;j<matrix[0].length;j++)
        //     {
        //         if(i==j)
        //         {
        //             sum+=a[i][j];
        //         }
        //         else if(i+j == a.length-1)
        //         {
        //             sum+=a[i][j];
        //         }
        //     }
        // }

        for(int i=0;i<a.length;i++)
        {
            sum+=a[i][i];
            if(i!=a.length-1-i)
            {
                sum+=a[i][a.length-i-1];
            }
        }
        System.out.print(sum);
    }
    public static void main(String args[])
    {
        int a[][]={{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
        diagonalsum(a);
    }
}