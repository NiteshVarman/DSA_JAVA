public class queueoperations {
    public static class node{
        int data;
        node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    static class queue {
        static node head;
        static node tail;
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        //add
        public static void add(int data) { 
            node newnode = new node(data);
            if(head == null) {
                head = tail = newnode;
                return;
            }
            tail.next = newnode;
            tail = newnode;
        }

        //remove
        public static int remove() {     //O(1)
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int front = head.data;
            if(tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String args[]) {
        queue q = new queue();
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