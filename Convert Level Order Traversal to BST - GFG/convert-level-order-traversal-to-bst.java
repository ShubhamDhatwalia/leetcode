//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java

class GFG 
{
    class Pair{
        Node parent;
        int l;
        int r;
        Pair(Node parent, int l, int r){
            this.parent = parent;
            this.l = l;
            this.r = r;
        }
    }
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        Queue<Pair> q = new LinkedList<>();
        
        Node root = new Node(arr[0]);
        
        q.add(new Pair(root, Integer.MIN_VALUE, root.data - 1));
        q.add(new Pair(root, root.data + 1, Integer.MAX_VALUE));
        
        int indx = 1;
        
        while(indx < arr.length){
            Pair curr = q.remove();
            
            if(arr[indx] < curr.l || arr[indx] > curr.r) continue;
            
            Node nn = new Node(arr[indx]);
            
            if(nn.data < curr.parent.data) curr.parent.left = nn;
            else curr.parent.right = nn;
            
            indx++;
            
            q.add(new Pair(nn, curr.l, nn.data - 1));
            q.add(new Pair(nn, nn.data + 1, curr.r));
        }
        return root;
    }
}