public class linkedlist{
    public static class node{
        int data;
        node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static node head;
    public static node tail;
    public static int size;

    public void addfirst(int data){     //O(1)
        node newnode = new node(data);
        size++;
        if(head == null){
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public static boolean cycle() {
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true; //cycle exists
            }
        }
        return false;
    }

    public static void removecycle() {
        node slow = head;
        node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }
        if(cycle == false) {
            return;
        }
        //find meeting point
        slow = head;
        node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle
        prev.next = null;
    }

    public static void main(String args[]){
        head = new node(1);
        node temp = new node(2);
        head.next = temp;
        head.next.next = new node(3);
        head.next.next.next = temp;
        System.out.println(cycle());
        removecycle();
        System.out.println(cycle());
    }
}
