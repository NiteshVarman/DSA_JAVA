import java.util.*;
public class patterns
{
    public static void main(String args [])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n/2;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i>=j || j>=n-i+1)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i=(n/2)+1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(j>=i || i<=n-j+1)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
    }
}