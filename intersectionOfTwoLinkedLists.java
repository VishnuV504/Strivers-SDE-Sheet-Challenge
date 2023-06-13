/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node {
 * public int data;
 * public Node next;
 * 
 * Node()
 * {
 * this.data = 0;
 * this.next = null;
 * }
 * Node(int data)
 * {
 * this.data = data;
 * this.next = null;
 * }
 * Node(int data, Node next)
 * {
 * this.data = data;
 * this.next = next;
 * }
 * }
 * 
 *****************************************************************/

public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        // Write your code here
        int count1 = 0;
        int count2 = 0;
        Node A = firstHead;
        Node B = secondHead;
        while (firstHead != null) {
            count1++;
            firstHead = firstHead.next;
        }
        while (secondHead != null) {
            count2++;
            secondHead = secondHead.next;
        }
        // System.out.println(count1 +" "+count2);
        if (count1 > count2) {
            while (count1 - count2 != 0) {
                count1--;
                A = A.next;
            }
            while (A != B) {
                A = A.next;
                B = B.next;
            }
            return A.data;
        } else {
            while (count2 - count1 != 0) {
                count2--;
                B = B.next;
                // System.out.println(B.val);
            }
            while (A != B) {
                A = A.next;
                B = B.next;
            }
            return B.data;

        }
    }
}