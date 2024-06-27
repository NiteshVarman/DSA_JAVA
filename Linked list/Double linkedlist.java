public class linkedlist{
    public static class node{
        int data;
        node next;
        node prev;

        public node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
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
        head.prev = newnode;
        head = newnode;
    }


    public int removefirst(){
        if (head == null){
            System.out.print("LL is empty");
        }

        if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
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

    public void reverse() {
        node curr = head;
        node prev = null;
        node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String args[]){
        linkedlist ll = new linkedlist();
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);
        ll.removefirst();
        ll.print();
        ll.reverse();
        ll.print();
        System.out.println(ll.size);
    }
}
