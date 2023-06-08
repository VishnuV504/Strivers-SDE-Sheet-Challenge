import java.util.*;
import java.io.*;

public class Solution {

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {
        // Write your code here.
        int V = vertices;
        int S = source;
        int ans[] = new int[V];
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        Arrays.fill(ans, Integer.MAX_VALUE);
        q.add(new Pair(0, 0));
        ans[0] = 0;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<ArrayList<Integer>>());
        for (int i = 0; i < edges; i++) {
            int a = vec.get(i).get(0);
            int b = vec.get(i).get(1);
            int c = vec.get(i).get(2);
            ArrayList<Integer> ok = new ArrayList<>();
            ok.add(b);
            ok.add(c);
            adj.get(a).add(new ArrayList<>(ok));
            ok.clear();
            ok.add(a);
            ok.add(c);
            adj.get(b).add(new ArrayList<>(ok));

        }
        while (!q.isEmpty()) {
            int now = q.peek().curr;
            int dis = q.peek().dis;
            q.remove(); // System.out.println("ok");
            for (int i = 0; i < adj.get(now).size(); i++) {
                int go = adj.get(now).get(i).get(0);
                int currDis = adj.get(now).get(i).get(1) + dis;
                if (ans[go] > currDis) {
                    ans[go] = currDis;
                    q.add(new Pair(go, currDis));
                }
            }
        }
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < ans.length; i++)
            y.add(ans[i]);
        return y;
    }
}

class Pair {
    int curr;
    int dis;

    Pair(int curr, int dis) {
        this.curr = curr;
        this.dis = dis;
    }
}
