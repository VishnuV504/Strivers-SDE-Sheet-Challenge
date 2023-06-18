import java.util.*;
import java.io.*;
/*

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

*/

public class Solution {

    public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Ineger> p, TreeNode<Integer> q) {
        // Write your code here
        return solve(root, p, q);
    }

    private static TreeNode<Integer> solve(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode<Integer> left = solve(root.left, p, q);
        TreeNode<Integer> right = solve(root.right, p, q);
        if (left != null && right != null)
            return root;
        return (left == null) ? right : left;
    }
}