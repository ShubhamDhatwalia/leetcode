//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node dummy0 = new Node(0);
		Node dummy1 = new Node(0);
		Node dummy2 = new Node(0);

		Node temp0 = dummy0, temp1 = dummy1, temp2 = dummy2 ,tmp = head;

		while(tmp!=null){
			if(tmp.data == 0){
				temp0.next = tmp;
				temp0 = temp0.next;
			}else if(tmp.data == 1){
				temp1.next = tmp;
				temp1 = temp1.next;
			}else if(tmp.data == 2){
				temp2.next = tmp;
				temp2 = temp2.next;
			}
			tmp = tmp.next; 
		}
		temp2.next = null;
		temp1.next = dummy2.next;
		temp0.next = dummy1.next;
		head = dummy0.next;
		return head;
		
    
    }
}

