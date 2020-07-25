/*
Diameter of Binary Tree is the maximum distance between two leaf nodes through the node.
We find the diameter by finding height of left subtree and right subtree, adding them + 1(root),
then comparing for the maximum between diameter of left and right subtrees. 
*/

class Solution {

/*
 The function Compute the "height" of a tree. Height is the
 number f nodes along the longest path from the root node
 down to the farthest leaf node.
 */
int height(Node root){
if (root == null) return 0;

return 1+Math.max(height(root.left, root.right));
}

// Function to fintd the diameter of the BT
int diameter(Node root){
if(root == null) return 0;

int lHeight = height(root.left);
int rHeight = height(root.right);

int lDiameter = diameter(root.left);
int rDiameter = diameter(root.right);

return Math.max(1+lHeight+rHeight, Math.max(lDiameter, rDiameter));
}

void main(){
// Call the diameter(root) after defining and creating your Tree and Nodes.
}

}
