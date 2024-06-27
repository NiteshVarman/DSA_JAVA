public class arrays {
    public static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int a[], int s, int e) {
        if(s >= e) {
            return;
        }
        int pidx = partition(a, s, e);
        sort(a, s, pidx-1); //left
        sort(a, pidx+1, e); //right
    }

    public static int partition(int a[], int s, int e) {
        int pivot = a[e];
        int i = s-1;
        
        for(int j=s; j<e; j++) {
            if(a[j] <= pivot) {
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        a[e] = a[i];
        a[i] = temp;
        return i;
    }


    public static void main(String args[]) {
        int a[] = {6, 3, 9, 5, 2, 8};
        sort(a, 0, a.length - 1);
        print(a);
    }
}
