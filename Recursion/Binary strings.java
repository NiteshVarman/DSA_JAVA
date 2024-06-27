//Print all Bianry strings of size N without consecutive ones.
//n = 3 ==> "000","001","010","100","101"
class Recursion {
    public static void binary(int n, int l, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }
        binary(n-1, 0, str+"0");

        if(l == 0) {
            binary(n-1, 1, str+"1");
        }
       }   
public static void main(String args[]) {
        binary(3,0,"");
    }
}
