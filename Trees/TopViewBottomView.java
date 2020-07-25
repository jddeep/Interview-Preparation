/*
Consider the Below Binary Tree:

                           1
                         /   \
                        2     3
                       / \   / \
                      4   5 6   7
                      
Left View of above Tree will be: 1, 2, 4
Right View of above Tree will be: 1, 3, 7
Top View of above Tree will be: 4, 2, 1, 3, 7
Bottom View of above Tree will be: 4, 5, 6, 7
*/
public class Solution
{
    
     static class Node{
        int data;
        Node left, right;
        
        Node(int val){
            this.data = val;
            left = right = null;
        }
    }
    
    static class BinaryTree{
        Node root;
        HashMap<Integer, Integer> hm;
        
        BinaryTree(int val){
            this.root = new Node(val);
            hm = new HashMap<>();
        }
        
        // First Node of each Horizontal Distance hd
        void topLevel(Node root, int hd){
            if(root == null) return;
            
            if(!hm.containsKey(hd)){
                hm.put(hd, root.data);
            }
            
            topLevel(root.left, hd-1);
            topLevel(root.right, hd+1);
        }
        
        // Basically requires to print leaf nodes, nothing to do with hd.
        void bottomLevel(Node root, int hd){
            if(root == null) return;
            
            if(root.left == null && root.right == null){
                hm.put(root.data, root.data);
            }
            
            bottomLevel(root.left, hd-1);
            bottomLevel(root.right, hd+1);
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BinaryTree tree = new BinaryTree(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        tree.bottomLevel(tree.root, 0);
        ArrayList<Integer> keys = new ArrayList<Integer>(tree.hm.keySet());
        Collections.sort(keys);
        for(int key: keys){
            System.out.print(tree.hm.get(key)+", ");
        }
	}
}
