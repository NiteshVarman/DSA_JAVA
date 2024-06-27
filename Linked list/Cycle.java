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

    public static void main(String args[]){
        head = new node(1);
        head.next = new node(2);
        head.next.next = new node(3);
        head.next.next.next = head;
        System.out.println(cycle());
    }
}
