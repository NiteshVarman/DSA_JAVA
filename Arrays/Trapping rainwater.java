import java.util.*;
public class arrays
{
        public static int trappedwater(int height[])
        {
            int n=height.length;

            int leftmax[]=new int[n];
            leftmax[0]=height[0];
            for(int i=1;i<n;i++)
            {
                leftmax[i]=Math.max(height[i],leftmax[i-1]);
            }

            int rightmax[]=new int [n];
            rightmax[n-1]=height[n-1];
            for(int i=n-2;i>=0;i--)
            {
                rightmax[i]=Math.max(height[i],rightmax[i+1]);
            }

            int t=0;
            for(int i=0;i<n;i++)
            {
                int waterlevel=Math.min(leftmax[i],rightmax[i]);
                t+=waterlevel-height[i];
            }
            return t;
        }
    public static void main(String args[])
    {
        int height[]={4,2,0,6,3,2,5};
        System.out.println(trappedwater(height));
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // int[] a=new int[n];
        // int b[]=new int[n];
        // for(int i=0;i<=n-1;i++)
        // {
        //     a[i]=sc.nextInt();
        // }
        // int m=0,d=0,d1=0,d2=0;
        // for(int i=0;i<=n-1;i++)
        // {
        //     if(m<a[i])
        //     {
        //         m=a[i];
        //         d=i;
        //     }
        // }
        // int s=0,e=d,m1=0,m2=0;
        // for(int i=s;i<=e-1;i++)
        // {
        //     if(m1<a[i])
        //     {
        //         m1=a[i];
        //         d1=i;
        //     }
        // }
        // for(int i=e+1;i<=n-1;i++)
        // {
        //     if(m2<a[i])
        //     {
        //         m2=a[i];
        //         d2=i;
        //     }
        // }
        // for(int i=d1;i<=e-1;i++)
        // {
        //     b[i]=m1-a[i];
        // }
        // for(int i=e+1;i<=d2;i++)
        // {
        //     b[i]=m2-a[i];
        // }
        // int sum=0;
        // for(int i=0;i<=n-1;i++)
        // {
        //     sum=sum+b[i];
        // }
        // System.out.print(sum);
    }
}