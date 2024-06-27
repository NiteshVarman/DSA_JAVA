import java.util.*;
public class strings
{
    
    public static void main(String args[])
    {
        String str="aaabbcccdd";
        int n=str.length();
        String s="";
        for(int i=0;i<n;i++)
        {
            Integer c=1;
            while(i<n-1 && str.charAt(i)==str.charAt(i+1))
            {
                c++;
                i++;
            }
            s+=str.charAt(i);
            if(c>1)
            {
                s+=c.toString();
            }
        }
        System.out.print(s);
    }
}