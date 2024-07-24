import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        HashSet<Integer> h = new HashSet<>();

        //union
        for(int i=0; i<arr1.length; i++) { 
            h.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) { 
            h.add(arr2[i]);
        }

        System.out.println("Union = " + h.size());

        //intersection
        h.clear();

        for(int i=0; i<arr1.length; i++) { 
            h.add(arr1[i]);
        }

        int c = 0;
        for(int i=0; i<arr2.length; i++) { 
            if(h.contains(arr2[i])) {
                c++;
                h.remove(arr2[i]);
            }
        }
        System.out.println("Intersection = " + c);
    }
}