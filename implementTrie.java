class Trie {
    Node root = new Node();
    Node dummy = new Node();

    Trie() {
        dummy = root;
    }

    public void insert(String word) {
        int n = word.length();
        dummy = root;
        for (int i = 0; i < n; i++) {
            if (!dummy.containsKey(dummy, word.charAt(i)))
                dummy.put(dummy, word.charAt(i), new Node());
            dummy = dummy.go(dummy, word.charAt(i));
        }
        dummy.setFlag(dummy);
    }

    public boolean search(String word) {
        int n = word.length();
        dummy = root;
        for (int i = 0; i < n; i++) {
            if (!dummy.containsKey(dummy, word.charAt(i)))
                return false;
            dummy = dummy.go(dummy, word.charAt(i));
        }
        return dummy.getFlag(dummy);
    }

    public boolean startsWith(String word) {
        int n = word.length();
        dummy = root;
        for (int i = 0; i < n; i++) {
            if (!dummy.containsKey(dummy, word.charAt(i)))
                return false;
            dummy = dummy.go(dummy, word.charAt(i));
        }
        return true;
    }
}

class Node {
    Node links[];
    boolean flag;

    Node() {
        this.links = new Node[26];
        this.flag = false;
    }

    public void setFlag(Node dummy) {
        dummy.flag = true;
    }

    public boolean getFlag(Node dummy) {
        return dummy.flag;
    }

    public boolean containsKey(Node dummy, char c) {
        return (dummy.links[c - 'a'] == null) ? false : true;
    }

    public Node go(Node dummy, char c) {
        return dummy.links[c - 'a'];
    }

    public void put(Node dummy, char c, Node temp) {
        dummy.links[c - 'a'] = temp;
    }
}
