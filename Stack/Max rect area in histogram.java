import java.util.*;
public class stack {
    public static void maxarea(int a[]) {
        int max = 0;
        int nsr[] = new int[a.length];
        int nsl[] = new int[a.length];

        //Next smaller right
        Stack<Integer> s = new Stack<>();

        for(int i = a.length-1; i >= 0; i--) {
            while(!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = a.length;
            }
            else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next smaller left

        s = new Stack<>();

        for(int i = 0; i < a.length; i++) {
            while(!s.isEmpty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            }
            else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //Current area:width = j-i-1
        for(int i=0; i<a.length; i++) {
            int h = a[i];
            int w = nsr[i] - nsl[i] - 1;
            int area = h * w;
            max = Math.max(area, max);
        }

        System.out.println("Max area is " + max);
    }
    public static void main(String args[]) {
        int a[] = {2, 1, 5, 6, 2, 3};
        maxarea(a);
    }
}