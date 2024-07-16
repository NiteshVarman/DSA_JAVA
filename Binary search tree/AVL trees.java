import java.util.*;
public class bst {
    static class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        
        return root.height;
    } 

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int getbal(Node root) {
        if(root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node insert(Node root, int key) {  
        if(root == null) {
            return new Node(key);
        }

        if(key < root.data) {
            root.left = insert(root.left, key);
        }
        else if(key > root.data) {
            root.right = insert(root.right, key);
        }
        else {
            return root;    //duplicates not allowed
        }

        //update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        //get root balance factor
        int b = getbal(root);

        //left left case
        if(b > 1 && key < root.left.data) 
            return rightRotate(root);
        
        //right right case
        if(b < -1 && key > root.right.data)
            return leftRotate(root);

        //left right case
        if(b > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //right left case
        if(b < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        //rotation
        y.left = x;
        x.right = t2;

        //update heights
        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        //rotation
        x.right = y;
        y.left = t2;

        //update heights
        y.height = 1 + max(height(y.left), height(y.right));
        x.height = 1 + max(height(x.left), height(x.right));

        return x;
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {
       root = insert(root, 10);
       root = insert(root, 20);
       root = insert(root, 30);
       root = insert(root, 40);
       root = insert(root, 50);
       root = insert(root, 25);

       preorder(root);
    }
}