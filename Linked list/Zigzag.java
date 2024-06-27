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

    public void addlast(int data){     //O(1)
        node newnode = new node(data);
        size++;
        if(head == null){
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }


    public void print(){        //O(n)
        if(head == null){
            System.out.print("LL is empty");
            return;
        }
        node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("Null");
    }


    public void zigzag() {
        //find mid
        node slow = head;
        node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        node mid = slow;

        //reverse 2nd half
        node curr = mid.next;
        mid.next = null;
        node prev = null;
        node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node left = head;
        node right = prev;
        node nextl, nextr;

        //zig-zag merge
        while(left != null && right != null) {
            nextl = left.next;
            left.next = right;
            nextr = right.next;
            right.next = nextl;

            left = nextl;
            right = nextr;
        }
    }
    public static void main(String args[]){
        linkedlist ll = new linkedlist();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.print();
        ll.zigzag();
        ll.print();
    }
}
