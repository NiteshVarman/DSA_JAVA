public class backtracking {
    public static void subsets(String str, String ans, int i) {   //O(n * 2^n)
       //base case
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.println("null");
            }
            else {
                System.out.println(ans);
            }
            return;
        }

       //recursion
       subsets(str, ans+str.charAt(i), i+1);

       subsets(str, ans, i+1);
    }

    public static void main(String args[]) {
        String str = "abc";
        subsets(str, "", 0);
    }
}