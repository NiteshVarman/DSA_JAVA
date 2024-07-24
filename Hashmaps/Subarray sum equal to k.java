import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        int arr[] = {10, -2, 2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> h = new HashMap<>();

        h.put(0, 1);
        int sum = 0, ans = 0;
        
        for(int j=0; j<arr.length; j++) {   //O(n)
            sum += arr[j];
            if(h.containsKey(sum - k)) {
                ans += h.get(sum - k);
            }
            h.put(sum, h.getOrDefault(sum, 0) + 1);
        }

        System.out.println(ans);
    }
}