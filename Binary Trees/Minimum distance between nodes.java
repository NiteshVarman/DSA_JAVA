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

    public static boolean getpath(node root, int n, ArrayList<node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n) {
            return true;
        }

        boolean foundleft = getpath(root.left, n, path);
        boolean foundright = getpath(root.right, n, path);

        if(foundleft || foundright) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static node lca(node root, int n1, int n2) { //O(n)
        ArrayList<node> path1 = new ArrayList<>();
        ArrayList<node> path2 = new ArrayList<>();

        getpath(root, n1, path1);
        getpath(root, n2, path2);

        //last common ancestor
        int i = 0;
        for(; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        //last equal node
        node lca = path1.get(i-1);
        return lca;
    }

    public static int lcadist(node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftdist = lcadist(root.left, n);
        int rightdist = lcadist(root.right, n);

        if(leftdist == -1 && rightdist == -1) {
            return -1;
        }
        else if(leftdist == -1) {
            return rightdist+1;
        }
        else {
            return leftdist+1;
        }
    }

    public static int mindist(node root, int n1, int n2) {
        node lca = lca(root, n1, n2);
        return lcadist(lca, n1) + lcadist(lca, n2);
    }

    public static void main(String args[]) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        int n1 = 4, n2 = 6;
        System.out.println(mindist(root, n1, n2));
    }
}