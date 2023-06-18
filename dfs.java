import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < v; i++)
            g.add(new ArrayList<>());
        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);
            g.get(a).add(b);
            g.get(b).add(a);
        }
        boolean visited[] = new boolean[v];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> li = new ArrayList<>();
            if (visited[i] == false) {
                dfs(i, g, li, visited);
                ans.add(new ArrayList<>(li));
            }
        }
        return ans;
    }

    public static void dfs(int curr, ArrayList<ArrayList<Integer>> g, ArrayList<Integer> ans, boolean visited[]) {
        visited[curr] = true;
        ans.add(curr);
        for (int i = 0; i < g.get(curr).size(); i++) {
            int now = g.get(curr).get(i);
            if (visited[now] == false)
                dfs(now, g, ans, visited);
        }
    }
}