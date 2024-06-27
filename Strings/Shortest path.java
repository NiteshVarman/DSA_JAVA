import java.util.*;
public class strings
{
    
    public static void main(String args[])
    {
        String str="WNEENESENNN";
        int n=str.length(),x=0,y=0;
        
        for(int i=0;i<n;i++)
        {
            char c=str.charAt(i);
            if(c=='S')
            {
                y--;
            }
            else if(c=='N')
            {
                y++;
            }
            else if(c=='W')
            {
                x--;
            }
            else
            {
                x++;
            }
        }
        int a=x*x;
        int b=y*y;
        System.out.print(Math.sqrt(a+b));
    }
}