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

    public static boolean isIdentical(node node, node subroot) {
        if(node == null && subroot == null) {
            return true;
        }
        else if(node == null || subroot == null || node.data != subroot.data) {
            return false;
        }

        if(!isIdentical(node.left, subroot.left)) {
            return false;
        }
        if(!isIdentical(node.right, subroot.right)) {
            return false;
        }
        return true;
    }
    public static boolean subtree(node root, node subroot) {
        if(root == null) {
            return false;
        }

        if(root.data == subroot.data) {
            if(isIdentical(root, subroot)) {
                return true;
            }
        }

        return subtree(root.left, subroot) || subtree(root.right, subroot);
    }

    public static void main(String args[]) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        node subroot = new node(2);
        subroot.left = new node(4);
        subroot.right = new node(5);

        System.out.println(subtree(root, subroot));
    }
}