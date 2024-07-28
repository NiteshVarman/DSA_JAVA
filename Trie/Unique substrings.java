public class trie {
    static class node {
        node children[] = new node[26];
        boolean eow = false;
    
        node() {
            for (int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static node root = new node();

    public static void insert(String word) {    //O(Length of largest word)
        node curr = root;
        for (int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }


    public static int countnodes(node root) {
        if (root == null) return 0;
        int count = 0;
        for (int i=0; i<26; i++) {
            if (root.children[i] != null) {
                count += countnodes(root.children[i]);
            }
        }
        return count+1;
    }

    public static void main(String args[]) {
        String str = "ababa";
        for(int i=0; i<str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countnodes(root));
    }
}