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
    public static Node findMiddle(Node head) {
        // Write your code here.
        Node dummy = new Node(-1);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;
        while (second != null) {
            first = first.next;
            second = second.next;
            if (second != null)
                second = second.next;
        }
        return first;
    }
}