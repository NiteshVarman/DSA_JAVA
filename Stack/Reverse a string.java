import java.util.*;
public class stackoperations {
        public static String reverse(String str) {
            Stack<Character> s = new Stack<>();
            int i = 0;
            while(i < str.length()) {
                s.push(str.charAt(i));
                i++;
            }

            StringBuilder r = new StringBuilder("");
            while(!s.isEmpty()) {
                char curr = s.pop();
                r.append(curr);
            }
            return r.toString();
        }
    public static void main(String args[]) {
        String str = "abc";
        String r = reverse(str);
        System.out.println(r);
    }
}