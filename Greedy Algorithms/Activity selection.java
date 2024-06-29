import java.util.*;

public class greedy {
    public static void main(String args[]) {    //O(nlogn)
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //sort according to end time to get more activities
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //sorting is done according to column 2
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxact = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxact = 1;
        ans.add(activities[0][0]);
        int lastend = activities[0][2];
        for(int i=1; i<end.length; i++) {
            if(activities[i][1] >= lastend) {
                //activity select
                maxact++;
                ans.add(activities[i][0]);
                lastend = activities[i][2];
            }
        }

        System.out.println("max activities = " + maxact);
        for(int i=0; i<ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

}