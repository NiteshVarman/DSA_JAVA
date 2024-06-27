import java.util.*;
public class arrays
{
    public static void spiral(int a[][])
    {
        int sr=0;
        int sc=0;
        int er=a.length-1;
        int ec=a[0].length-1;
        while(sr<=er && sc<=ec)
        {
            //left
            for(int j=sc;j<=ec;j++)
            {
                System.out.print(a[sr][j]+" ");
            }

            //right
            for(int i=sr+1;i<=er;i++)
            {
                System.out.print(a[i][ec]+" ");
            }

            //bottom
            for(int j=ec-1;j>=sc;j--)
            {
                if(sr==er)
                {
                    break;
                }
                System.out.print(a[er][j]+" ");
            }

            //left
            for(int i=er-1;i>=sr+1;i--)
            {
                if(sc==ec)
                {
                    break;
                }
                System.out.print(a[i][sc]+" ");
            }
            sc++;
            sr++;
            ec--;
            er--;
        }
    }
    public static void main(String args[])
    {
        int a[][]={{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
        spiral(a);
    }
}