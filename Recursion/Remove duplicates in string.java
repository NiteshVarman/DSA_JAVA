class Recursion {
    public static void duplicates(String str, int i, StringBuilder s, boolean map[]) {
              if(i == str.length()) {
                System.out.println(s);
                return;
              }

              char c = str.charAt(i);
              if(map[c-'a'] == true) {
                duplicates(str, i+1, s, map);
              } else {
                map[c-'a'] = true;
                duplicates(str, i+1, s.append(c), map);
              }

       }   
public static void main(String args[]) {
        String str="abcdabcad";
        duplicates(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
