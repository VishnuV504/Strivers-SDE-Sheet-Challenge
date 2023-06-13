import java.io.*;
import java.util.*;

/************************************************************
 * 
 * Following is the linked list node structure:
 * 
 * class LinkedListNode<T> {
 * T data;
 * LinkedListNode<T> next;
 * 
 * public LinkedListNode(T data) {
 * this.data = data;
 * }
 * }
 * 
 ************************************************************/

public class Solution {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> list1, LinkedListNode<Integer> list2) {
        // Write your code here.
        LinkedListNode Dummy = new LinkedListNode(-1000); // dummy pointer
        LinkedListNode<Integer> ptr = Dummy;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }
        if (list1 != null)
            ptr.next = list1;
        else
            ptr.next = list2;
        return Dummy.next;
    }
}
