import java.util.*;
public class strings
{
    
    public static void main(String args[])
    {
        String str="racecar";
        int n=str.length();
        int f=0;
        for(int i=0;i<n/2;i++)
        {
            if(str.charAt(i)!=str.charAt(n-1-i))
            {
                f=1;
            }
        }
        if(f==1)
        {
            System.out.print("Not a palindrome");
        }
        else
        {
            System.out.print("Palindrome");
        }
    }
}