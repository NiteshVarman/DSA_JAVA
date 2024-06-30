import java.util.*;
public class greedy {
    public static void main(String args[]) {    //O(nlogn)
        int pairs[][] = {{1, 2}, {2, 3}, {3, 4}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainlen = 1;
        int chainend = pairs[0][1]; //Last selected pair end //chain end

        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] >= chainend) {
                chainlen++;
                chainend = pairs[i][1];
            }
        }
        System.out.println("Max length of chain = " + chainlen);
    }
}

