import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        HashMap<Integer, Integer> h = new HashMap<>();

        int sum = 0, len = 0;
        for(int j=0; j<arr.length; j++) {   //O(n)
            sum += arr[j];
            if(h.containsKey(sum)) {
                len = Math.max(len, j - h.get(sum));
            }
            else {
                h.put(sum, j);
            }
        }

        System.out.println("Largest subarray with sum 0 = " + len);

    }
}