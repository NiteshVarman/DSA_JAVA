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

    public static boolean search(String key) {    
        node curr = root;
        for (int i=0; i<key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static void main(String args[]) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("thee"));
        System.out.println(search("thor"));
        
    }
}