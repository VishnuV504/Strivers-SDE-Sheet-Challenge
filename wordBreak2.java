import java.util.*;

class Node {
    Node links[] = new Node[26];
    boolean flag = false;

    boolean containsKey(Node root, char c) {
        return root.links[c - 'a'] != null;
    }

    void connect(Node root, char c, Node toBeConnected) {
        root.links[c - 'a'] = toBeConnected;
    }

    Node moveForward(Node root, char c) {
        return root.links[c - 'a'];
    }

    void setFlag(Node root) {
        root.flag = true;
    }

    boolean getFlag(Node root) {
        return root.flag;
    }
}

class Solution {

    public static ArrayList<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<String> ans = new ArrayList<>();
        Node root = new Node();
        Node dummy = new Node();
        int n = wordDict.size();
        dummy = root;
        for (int i = 0; i < n; i++) {
            String word = wordDict.get(i);
            root = dummy;
            for (int j = 0; j < word.length(); j++) {
                if (!root.containsKey(root, word.charAt(j)))
                    root.connect(root, word.charAt(j), new Node());
                root = root.moveForward(root, word.charAt(j));
            }
            root.setFlag(root);
        }
        solve(0, root = dummy, s, new StringBuilder(), ans, dummy);
        return ans;
    }

    public static void solve(int curr, Node root, String s, StringBuilder sb, ArrayList<String> ans, Node dummy) {
        if (curr >= s.length()) {
            if (root.getFlag(root))
                ans.add(sb.toString());
            return;
        }
        if (root.getFlag(root)) {
            Node temp = root;
            root = dummy;
            sb.append(" ");
            solve(curr, root, s, sb, ans, dummy);
            sb.deleteCharAt(sb.length() - 1);
            root = temp;
        }
        if (root.containsKey(root, s.charAt(curr))) {
            sb.append(s.charAt(curr));
            solve(curr + 1, root.moveForward(root, s.charAt(curr)), s, sb, ans, dummy);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }

}