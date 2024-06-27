import java.util.*;
public class linkedlist {
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

    public node getmid(node head) {
        node slow = head;
        node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static node merge(node head1, node head2) {
        node mergell = new node(-1);
        node temp = mergell;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 !=null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 !=null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergell.next;
    }
    public node mergesort(node head) {
        if(head == null || head.next == null) {
            return head;
        }
        //find mid
        node mid = getmid(head);
        //left and right ms
        node righthead = mid.next;
        mid.next = null;
        node newleft = mergesort(head);
        node newright = mergesort(righthead);
        //merge
        return merge(newleft, newright);
    }

    public void print() {        //O(n)
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

    public static void main(String args[]) {
        linkedlist ll = new linkedlist();
        ll.addfirst(1);
        ll.addfirst(2);
        ll.addfirst(3);
        ll.addfirst(4);
        ll.addfirst(5);
        ll.print();
        ll.head = ll.mergesort(ll.head);
        ll.print();
    }
}