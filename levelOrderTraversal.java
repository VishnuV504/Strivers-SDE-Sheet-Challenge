import java.util.*;
import java.io.*;
/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.ArrayList;

public class Solution {

    public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
        // Your code goes here
        ArrayList<Integer> li = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.peek();
            q.remove();
            if (curr != null) {
                li.add(curr.val);
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return li;
    }

}