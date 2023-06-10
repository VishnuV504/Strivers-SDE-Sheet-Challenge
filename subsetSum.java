import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList<Integer> ans = new ArrayList<>();
        solve(0, 0, num, ans);
        Collections.sort(ans);
        return ans;
    }

    public static void solve(int curr, int sum, int nums[], ArrayList<Integer> ans) {
        if (curr >= nums.length) {
            ans.add(sum);
            return;
        }
        solve(curr + 1, sum + nums[curr], nums, ans);
        solve(curr + 1, sum, nums, ans);
    }

}