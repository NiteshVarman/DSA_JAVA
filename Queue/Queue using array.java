public class queueoperations {
    static class queue {
        static int a[];
        static int size;
        static int rear;

        queue(int n) {
            a = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        //add
        public static void add(int data) {   //O(1)
            if(rear == size-1) {
                System.out.println("queue is full");
                return;
            }

            rear = rear+1;
            a[rear] = data;
        }

        //remove
        public static int remove() {     //O(n)
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int front = a[0];
            for(int i = 0; i < rear; i++) {
                a[i] = a[i+1];
            }
            rear = rear - 1;
            return front;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return a[0];
        }
    }
    public static void main(String args[]) {
        queue q = new queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}