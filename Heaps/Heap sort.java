import java.util.*;
public class heaps {

        public static void heapify(int arr[], int i, int size) {
            int l = 2*i+1;
            int r = 2*i+2;
            int max = i;

            if(l < size && arr[l] > arr[max]) {
                max = l;
            }

            if(r < size && arr[r] > arr[max]) {
                max = r;
            }

            if(max != i) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;

                heapify(arr, max, size);
                
            }
        } 

        public static void heapsort(int arr[]) {    //O(nlogn)
            //step 1 - build maxheap
            int n = arr.length;
            for(int i = n/2-1; i >= 0; i--) {
                heapify(arr, i, n);
            }

            //step 2
            for(int i = n-1; i >= 0; i--) {
                //swap largest first with last
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, 0, i);
            }
        }

    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 5, 3};
        heapsort(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
}