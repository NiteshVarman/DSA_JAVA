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


    //slow-fast approach
    public node mid(node head){
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean palindrome(){
        
        if(head == null || head.next == null){
            return true;
        }
        //step -1 :find mid
        node midnode = mid(head);
        //step -2 :reverse 2nd half
        node prev = null;
        node curr = midnode;
        node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node right = prev;
        node left = head;
        //step -3 :check left half and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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

    public static void main(String args[]){
        linkedlist ll = new linkedlist();
        ll.addfirst(1);
        ll.addfirst(2);
        ll.addfirst(2);
        ll.addfirst(1);
        ll.print();
        System.out.println(ll.palindrome());
    }
}
