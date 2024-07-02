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

    p

    public static void lca(node root, int n1, int n2) {
        Arraylist<Integer> path1 = new Arraylist<>();
        Arraylist<Integer> path2 = new Arraylist<>();

        getpath(root, n1, path1);
        getpath(root, n2, path2);

        //last common ancestor
        int i = 0;
        for(; i<path1.size() && path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        //last equal node
        node lca = path1.get(i-1);
    }
    public static void main(String args[]) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        int k = 3;
        klevel(root, 1, k);
    }
}