class Solution{
/* 
    There are four types of binary tree traversals:
    Note- Traversal signifies visiting a node of the tree.
    Inorder: Left -> Root -> Right (For each subtree in the tree)
    PreOrder: Root -> Left -> Right (For each subtree in the tree)
    PostOrder: Left -> Right -> Root (For each subtree in the tree)
    LevelOrder: Level wise visiting nodes of the tree - Level1 -> Level2...
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
        
        void inorder(Node node){
            if(node == null) return;
            
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
        
        void preorder(Node node){
            if(node == null) return;
            
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
        
        void postorder(Node node){
            if(node == null) return;
            
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
        
        void levelorder(Node node){
            if(node == null) return;
            Queue<Node> q = new LinkedList<Node>();
            q.add(node);
            
            while(!q.isEmpty()){
                Node temp = q.poll(); //pulls out the first element in the queue
                
                if(temp != null){
                    System.out.print(temp.data + " ");
                }
                
                if(temp.left != null)
                q.add(temp.left);
                
                if(temp.right != null)
                q.add(temp.right);
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
        BinaryTree tree = new BinaryTree(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Inorder traversal");
        tree.inorder(tree.root);
        System.out.println();
        System.out.println("PreOrder traversal");
        tree.preorder(tree.root);
        System.out.println();
        System.out.println("PostOrder traversal");
        tree.postorder(tree.root);
        System.out.println();
        System.out.println("LevelOrder traversal");
        tree.levelorder(tree.root);
        
	}
}
