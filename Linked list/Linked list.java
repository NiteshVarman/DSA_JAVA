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

    public void add(int idx, int data){
        if(head == null){
            addfirst(data);
            return;
        }
        node newnode = new node(data);
        size++;
        node temp = head;
        int i = 0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newnode.next = temp.next;
        temp.next = newnode;

    }

    public int removefirst(){
        if (size == 0){
            System.out.print("LL is empty");
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removelast(){
        if (size == 0){
            System.out.print("LL is empty");
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public void deletenfromend(int n){
        int sz = 0;
        node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next;
            return;   //remove first
        }

        node prev = head;
        int i = 1;
        while(i < sz-n){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public int search(int key){     //O(n)
        node temp = head;
        int i=0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public int recsearch(int key){
        return helper(head, key);
    }

    public int helper(node head, int key){
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }

        int j = helper(head.next, key);
        if(j == -1){
            return -1;
        }
        return j+1;
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

    public void reverse(){      //O(n)
        node prev = null;
        node curr = tail = head;
        node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String args[]){
        linkedlist ll = new linkedlist();
        ll.addfirst(2);
        ll.addfirst(1);
        ll.addlast(4);
        ll.addlast(5);
        ll.add(2,3);
        ll.removefirst();
        ll.print();
        ll.removelast();
        ll.print();
        System.out.println(ll.search(4));
        System.out.println(ll.search(9));
        System.out.println(ll.size);
        ll.deletenfromend(2);
        ll.print();
        ll.reverse();
        ll.print();
    }
}
