import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(0, 0, maze, ans, new boolean[n][n]);
        return ans;
    }

    public static void solve(int row, int col, int maze[][], ArrayList<ArrayList<Integer>> ans, boolean visited[][]) {
        if (row == maze.length - 1 && col == maze.length - 1) {
            visited[0][0] = true;
            if (maze[row][col] == 1) {
                visited[row][col] = true;
                ArrayList<Integer> li = new ArrayList<>();
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze.length; j++) {
                        if (visited[i][j])
                            li.add(1);
                        else
                            li.add(0);
                    }
                }
                visited[row][col] = false;
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < 4; i++) {
            int currRow = row + dir[i][0];
            int currCol = col + dir[i][1];
            if (currRow >= 0 && currCol >= 0 && currRow < maze.length && currCol < maze.length
                    && maze[currRow][currCol] == 1 && visited[currRow][currCol] == false) {
                visited[currRow][currCol] = true;
                solve(currRow, currCol, maze, ans, visited);
                visited[currRow][currCol] = false;
            }
        }
    }
}