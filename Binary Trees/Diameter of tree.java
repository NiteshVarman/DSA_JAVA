import java.util.*;

public class Tree {
    static class node {
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(node root) {
        if(root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    // Approach-1 O(n^2)
    public static int diameter1(node root) { 
        if(root == null) {
            return 0;
        }

        int ld = diameter1(root.left);
        int lh = height(root.left);
        int rd = diameter1(root.right);
        int rh = height(root.right);
        int selfdiam = lh + rh + 1;
        return Math.max(selfdiam, Math.max(ld, rd));
    }

    // Approach-2 O(n)
    static class info {
        int diam;
        int ht;

        public info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static info diameter2(node root) {
        if(root == null) {
            return new info(0, 0);
        }

        info linfo = diameter2(root.left);
        info rinfo = diameter2(root.right);
        
        int diam = Math.max(Math.max(linfo.diam, rinfo.diam), linfo.ht + rinfo.ht + 1);
        int ht = Math.max(linfo.ht, rinfo.ht) + 1;

        return new info(diam, ht);
    }

    public static void main(String args[]) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        System.out.println(diameter1(root)); // Using Approach-1
        System.out.println(diameter2(root).diam); // Using Approach-2
        System.out.println(diameter2(root).ht);
    }
}
