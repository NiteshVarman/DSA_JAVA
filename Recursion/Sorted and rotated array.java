public class Recursion {
    public static int search(int a[], int tar, int s, int e) {
        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;

        //case found
        if(a[mid] == tar) {
            return mid;
        }

        if(a[s] <= a[mid]) {
            //case a : left
            if(a[s] <= tar && tar <= a[mid]) {
                return search(a, tar, s, mid-1);
            } else {
                //case b : right
                return search(a, tar, mid+1, e);
            }
        }

        //mid on L2
        else {
            //case c : right
            if(a[mid] <= tar && tar <= a[e]) {
                return search(a, tar, mid+1, e);
            } else {
                //case d : left
                return search(a, tar, s, mid-1);
            }
        }
    }


    public static void main(String args[]) {
        int a[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int taridx = search(a, target, 0, a.length-1);
        System.out.println(taridx);
    }
}
