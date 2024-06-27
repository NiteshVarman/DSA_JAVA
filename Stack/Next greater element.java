import java.util.*;
public class stack {
    public static void main(String args[]) {
        int a[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nxtgreater[] = new int[a.length];

        for( int i = a.length-1; i >= 0; i--) {
            while(!s.isEmpty() && a[s.peek()] <= a[i]) {
                s.pop();
            }

        if(s.isEmpty()) {
            nxtgreater[i] = -1;
        } else {
            nxtgreater[i] = a[s.peek()];
        }
        s.push(i);
        }

        for(int i=0; i<nxtgreater.length; i++) {
            System.out.println(nxtgreater[i]+" ");
        }
        System.out.println();
    }
}