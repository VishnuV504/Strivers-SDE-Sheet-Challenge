import java.util.*;
import java.io.*;

/************************************************************
 * 
 * Following is the Binary Tree node structure:
 * 
 * class BinaryTreeNode<T> {
 * T data;
 * BinaryTreeNode<T> left;
 * BinaryTreeNode<T> right;
 * 
 * public BinaryTreeNode(T data) {
 * this.data = data;
 * }
 * }
 * 
 ************************************************************/

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        BinaryTreeNode<Integer> temp = root;
        solve(root, li);
        root = temp;
        ans.add(new ArrayList<>(li));
        li.clear();
        solve2(root, li);
        root = temp;
        ans.add(new ArrayList<>(li));
        li.clear();
        solve3(root, li);
        ans.add(new ArrayList<>(li));
        return ans;
    }

    public static void solve(BinaryTreeNode<Integer> root, List<Integer> li) {
        if (root == null)
            return;
        solve(root.left, li);
        li.add(root.data);
        solve(root.right, li);
    }

    public static void solve2(BinaryTreeNode<Integer> root, List<Integer> li) {
        if (root == null)
            return;
        li.add(root.data);
        solve2(root.left, li);
        solve2(root.right, li);
    }

    public static void solve3(BinaryTreeNode<Integer> root, List<Integer> li) {
        if (root == null)
            return;
        solve3(root.left, li);
        solve3(root.right, li);
        li.add(root.data);
    }
}
