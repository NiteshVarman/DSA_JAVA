import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        HashSet<Integer> h = new HashSet<>();

        for(int i=0; i<num.length(); i++) { //O(n)
            h.add(num[i]);
        }

        System.out.println(h.size());
    }
}