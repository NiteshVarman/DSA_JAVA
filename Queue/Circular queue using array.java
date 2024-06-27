public class queueoperations {
    static class queue {
        static int a[];
        static int size;
        static int rear;
        static int front;

        queue(int n) {
            a = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isfull() {
            return (rear + 1) % size == front;
        }
        //add
        public static void add(int data) {   //O(1)
            if(isfull()) {
                System.out.println("queue is full");
                return;
            }
            if(front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            a[rear] = data;
        }

        //remove
        public static int remove() {     //O(1)
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int r = a[front];
            if(rear == front) {
                rear = front = -1;
            }else {
                front = (front + 1) % size;
            }
            return r;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return a[front];
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