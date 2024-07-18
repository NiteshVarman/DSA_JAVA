import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        //insert    O(1)
        hm.put("India", 100);
        hm.put("USA", 200);
        hm.put("UK", 300);
        hm.put("China", 400);

        System.out.println(hm);

        //get   O(1)
        int population = hm.get("India");
        System.out.println(population);

        System.out.println(hm.get("Indonesia"));

        //containskey   O(!)
        System.out.println(hm.containsKey("India"));

        //Remove    O(1)
        System.out.println(hm.remove("USA"));
        System.out.println(hm);

        //size
        System.out.println(hm.size());

        //isempty
        System.out.println(hm.isEmpty());

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for(String k : keys) {
            System.out.println("keys = " + k + " value =" + hm.get(k));
        }
    }
}