import java.util.*;
public class heaps {
    static class heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { //O(logn)
            //add at last index
            arr.add(data);

            int x = arr.size()-1;   //child index
            int par = (x-1)/2;  //par index

            while(arr.get(x) < arr.get(par)) {  
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public void heapify(int i) {
            int l = 2*i+1;
            int r = 2*i+2;
            int min = i;

            if(l < arr.size() && arr.get(l) < arr.get(min)) {
                min = l;
            }

            if(r < arr.size() && arr.get(r) < arr.get(min)) {
                min = r;
            }

            if(min != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);

                heapify(min);
                
            }
        } 

        public int remove() {
            int data = arr.get(0);
            //swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            //delete last
            arr.remove(arr.size()-1);
            //heapify
            heapify(0);
            return data;
        }

        public boolean isempty() {
            return arr.size() == 0;
        }
    }

    public static void main(String args[]) {
        heap h = new heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isempty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}