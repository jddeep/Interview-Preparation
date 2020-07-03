/*
Example:
Input:
2
1 3 2  
10 20 30 40 60 
Output:
1 3 2
10 20 30 60 40 

Explanation:
Testcase1: The tree is
        1
     /      \
   3       2
So, the spiral level order would be 1 3 2
Testcase2: The tree is
                           10
                        /        \
                     20         30
                  /       \
               40       60
So, the spiral level order would be 10 20 30 60 40
*/

// The idea is to keep is two stacks, one for right-to-left starting from top/root
// and another for left-to-right. The pushing into both stacks is logical - when we are
// printing from right to left we push the curr node's children in left-to-right stack
// which would be printed for next level in that order.
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Spiral
{
      void printSpiral(Node node) 
      {
           if(node == null) return;
           Stack<Node> rtl = new Stack<Node>();
           Stack<Node> ltr = new Stack<Node>();
           
           rtl.push(node);
           
            while(!rtl.isEmpty()||!ltr.isEmpty()){
                
                while(!rtl.isEmpty()){
                    Node temp = rtl.peek();
                    rtl.pop();
                    
                    if(temp != null){
                    System.out.print(temp.data + " ");
                }
                    if(temp.right != null) ltr.push(temp.right);
                    if(temp.left != null) ltr.push(temp.left);
                }
                
                while(!ltr.isEmpty()){
                    Node temp = ltr.peek();
                    ltr.pop();
                    
                    if(temp != null){
                    System.out.print(temp.data + " ");
                }
                    if(temp.left != null) rtl.push(temp.left);
                    if(temp.right != null) rtl.push(temp.right);
                }
                
            }
      }
}
