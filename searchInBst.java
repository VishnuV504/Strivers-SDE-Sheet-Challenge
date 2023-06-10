import java.util.*;
import java.io.*;
/*
    Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
*/

public class Solution {
    public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
        // Write your code here.
        return solve(root, x);
    }

    public static Boolean solve(BinaryTreeNode<Integer> root, int x) {
        if (root == null)
            return false;
        Boolean ans = false;
        if (root.data == x)
            return true;
        ans |= solve(root.left, x);
        ans |= solve(root.right, x);
        return ans;

    }
}