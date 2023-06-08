import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        // Write your code here.
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        List<Integer> res = new ArrayList<>();
        solve(0, arr, target, res, ans);
        return ans;

    }

    private static void solve(int curr, ArrayList<Integer> arr, int k, List<Integer> res,
            ArrayList<ArrayList<Integer>> ans) {
        if (k == 0)
            ans.add(new ArrayList<>(res));
        if (curr >= arr.size())
            return;
        for (int i = curr; i < arr.size(); i++) {
            if (i > 0 && arr.get(i) == arr.get(i - 1) || arr.get(i) == -1 || k < arr.get(i))
                continue;
            int temp = arr.get(i);
            res.add(temp);
            arr.set(i, -1);
            solve(i + 1, arr, k - temp, res, ans);
            res.remove(res.size() - 1);
            arr.set(i, temp);

        }
    }
}
