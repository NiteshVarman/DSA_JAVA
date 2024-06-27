public class arrays {
    
    public static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int a[], int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = s + (e - s) / 2;
        sort(a, s, mid);
        sort(a, mid + 1, e);
        merge(a, s, mid, e);
    }

    public static void merge(int a[], int s, int mid, int e) {
        int temp[] = new int[e - s + 1];
        int i = s;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= e) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }

        // For leftover elements of the first sorted part
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        // For leftover elements of the second sorted part
        while (j <= e) {
            temp[k++] = a[j++];
        }

        // Copy temp to the original array
        for (k = 0, i = s; k < temp.length; k++, i++) {
            a[i] = temp[k];
        }
    }

    public static void main(String args[]) {
        int a[] = {6, 3, 9, 5, 2, 8};
        sort(a, 0, a.length - 1);
        print(a);
    }
}
