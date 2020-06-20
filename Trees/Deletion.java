class Solution
{
    /*
    The concept behind deleting a node in a BinaryTree is,
    we find the node with the value/key to be deleted and
    replace its value with the value of the last rightmost node
    in the tree. After the value is replaced, we delete the
    rightmost node in the tree.
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
        
        void deleteDeepest(Node deepNode){
            if(deepNode == null) return;
            
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            
            while(!q.isEmpty()){
                Node temp = q.poll();
                
                if(temp.left != null){
                    if(temp.left == deepNode){
                        temp.left = null;
                        deepNode = null;
                        return;
                    }else q.add(temp.left);
                } 
                
                if(temp.right != null){
                    if(temp.right == deepNode){
                        temp.right = null;
                        deepNode = null;
                        return;
                    }else q.add(temp.right);
                } 
            }
            if(root == deepNode) root = null;
        }
        void delete(int key){
            if(root == null) return;
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            
            Node temp = null; // Will contain the deepest/rightmost node of the tree
            Node del = null; // Will contain the node wich has to be deleted
            
            while(!q.isEmpty()){
                temp = q.poll();
                
                if(temp.data == key){
                    del = temp;
                }
                
                if(temp.left != null) q.add(temp.left);
                
                if(temp.right != null) q.add(temp.right);
            }
            
            // Swapping/Replacing the value of the node to be deleted
            // with tha value of the rightmost/deepest node
            int x = temp.data;
            del.data = x;
            //Deleting the rightmost/deepest node after value have been swapped
            deleteDeepest(temp);
        }
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	      // Creating the following Binary Tree:
        //            10
        //         /      \
        //        11       9
        //       /  \     / \
        //      7    12  15  8 
		    BinaryTree tree = new BinaryTree(10);
        tree.root.left = new Node(11); 
        tree.root.left.left = new Node(7); 
        tree.root.left.right = new Node(12);
        tree.root.right = new Node(9);  
        tree.root.right.left = new Node(15); 
        tree.root.right.right = new Node(8); 
        
        System.out.println("Before Deletion: ");
        tree.inorder(tree.root);
        
        tree.delete(11);
        // After deleting the Binary Tree:
        //            10
        //         /      \
        //        8       9
        //       /  \     /
        //      7    12  15   
        
        System.out.println(""); // Empty Line
        System.out.println("After Deletion: ");
        tree.inorder(tree.root);

	}
}
