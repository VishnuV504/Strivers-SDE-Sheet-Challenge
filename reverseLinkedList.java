public

import java.io.*;
import java.util.*;

/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		if(head==null || head.next==null)
            return head;
        if(head.next.next==null)
        {
            LinkedListNode<Integer> p= head;
            LinkedListNode<Integer> q= head.next;
            p.next=null;
            q.next=p;
            return q;
        }
        else
        {
            LinkedListNode<Integer> p=head;
            LinkedListNode<Integer> q= head.next;
            LinkedListNode<Integer> r= head.next.next;
            
            q.next =p;
            p.next=null;
            while(r!=null)
            {
                p=q;
                q=r;
                r=r.next;
                q.next=p;
            }
            return q;
        }
    }
}{

}
