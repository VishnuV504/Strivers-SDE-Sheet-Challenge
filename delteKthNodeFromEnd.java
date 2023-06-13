/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node {
 * public int data;
 * public Node next;
 * public Node prev;
 * 
 * Node()
 * {
 * this.data = 0;
 * this.next = null;
 * this.prev = null;
 * }
 * 
 * Node(int data)
 * {
 * this.data = data;
 * this.next = null;
 * this.prev = null;
 * }
 * 
 * Node(int data, Node next)
 * {
 * this.data = data;
 * this.next = next;
 * this.prev = next;
 * }
 * };
 * 
 *****************************************************************/

public class Solution {
    public static Node removeKthNode(Node head, int n) {
        // Write your code here.
        Node dummy = new Node(-1);
        n++;
        dummy.next = head;
        Node q = dummy;
        Node r = q;
        while (q != null) {
            if (q == r) {
                while (n != 0) {
                    q = q.next;
                    n--;
                }
            } else {
                q = q.next;
                r = r.next;
            }
        }
        r.next = r.next.next;
        return dummy.next;
    }
}