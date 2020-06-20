class Solution
{
    /*
    For inserting a node in a given BinaryTree,
    we need to do level order traversal of the BinaryTree.
    If we find the left child of a node as null, we insert our 
    new node there or else if we have a right child empty of a node
    we insert it as the right child of that node.
    Note: Prefer to insert as a left child node
    */
    
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
        
        BinaryTree(int val){
            this.root = new Node(val);
        }
        
        void inorder(Node node){// To help in printing the tree elements
            if(node == null) return;
            
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
        
        // Insertion function
        void insert(Node root, Node newNode){
            if(root == null){
            // If tree is empty, the root of our tree will be the new node.
                root = newNode;
                return;
            }
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            
            while(!q.isEmpty()){
                Node temp = q.poll();
                
                if(temp.left == null){
                    temp.left = newNode;
                    return;
                }else q.add(temp.left);
                
                if(temp.right == null){
                    temp.right = newNode;
                    return;
                }else q.add(temp.left);
            }
        }
    }
        
	public static void main (String[] args) throws java.lang.Exception
	{
	    // Creating the following Binary Tree
        //          10
        //         /  \
        //        11   9
        //       /      \
        //      7        8
		BinaryTree tree = new BinaryTree(10);
        tree.root.left = new Node(11);
        tree.root.left.left = new Node(7); 
        tree.root.right = new Node(9);
        tree.root.right.left = new Node(15); 
        tree.root.right.right = new Node(8);
        
        System.out.println("Before Insertion: ");
        tree.inorder(tree.root);
        
        Node newNode = new Node(12);
        tree.insert(tree.root, newNode);
        
        System.out.println(""); // Empty Line
        System.out.println("After Insertion: ");
        tree.inorder(tree.root);
        
	}
}
