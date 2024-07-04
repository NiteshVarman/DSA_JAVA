import java.util.*;
public class BinaryTreesB {
    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int i = -1;

        public static node buildtree(int nodes[]) {
            i++;
            if (i >= nodes.length || nodes[i] == -1) {
                return null;
            }

            node newnode = new node(nodes[i]);
            newnode.left = buildtree(nodes);
            newnode.right = buildtree(nodes);

            return newnode;
        }

        public static void levelorder(node root) { //O(n)
            if(root == null) {
                return;
            }
            Queue<node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                node temp = q.remove();
                if(temp == null) {
                    System.out.println();
                    if(q.isEmpty()) {
                        break;
                    }
                    else {
                        q.add(null);
                    }
                }
                else {
                    System.out.print(temp.data+" ");
                    if(temp.left != null) {
                        q.add(temp.left);
                    }
                    if(temp.right != null) {
                        q.add(temp.right);
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        BinaryTree tree = new BinaryTree();
        node root = tree.buildtree(nodes);
        tree.levelorder(root);
    }
}
