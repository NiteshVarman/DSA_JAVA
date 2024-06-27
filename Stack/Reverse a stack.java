import java.util.*;
public class stackoperations {
        public static void push(Stack<Integer> s, int data) {
            if(s.isEmpty()) {
                s.push(data);
                return;
            }
            int top = s.pop();
            push(s, data);
            s.push(top);
        }

        public static void reverse(Stack<Integer> s) {
            if(s.isEmpty()) {
                return;
            }
            int top = s.pop();
            reverse(s);
            push(s, top);
        }
        
        public static void print(Stack <Integer> s) {
            while(!s.isEmpty()) {
                System.out.println(s.pop());
            }

        }
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverse(s);
        print(s);
    }
}