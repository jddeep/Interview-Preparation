/*
Finding LCA is an algo of finding the Lowest Common Ancestor of two nodes
in a Binary Search Tree(BST). LCA is the node which is the last/closest common node
to both the given nodes. If both the given nodes lie on the same path(left/right), then either
of the two nodes which is above the other node in the tree is the LCA.
*/

// Define your Tree and Node classes

class Solution {

Node findLca(TreeNode root, TreeNode left, TreeNode right){

if(root == null) return null; //base condition

if(root.data == left.data || root.data == right.data){
return root;
}

Node left_lca = findLca(root.left, left, right);
Node right_lca = findLca(root.right, left, right);

if(left_lca != null && right_lca != null) return root; //if both nodes lie on different subtrees/paths in the tree
else if(left_lca != null) return left_lca; //if both nodes lie on the same path/left path
else return right_lca; //if both nodes lie on the same path/right path OR A LCA doesnt exist in that case right_lca will be null

}

void main(){
// Call findLca() with root and the two nodes as required after defining the tree and its nodes.
}

}
