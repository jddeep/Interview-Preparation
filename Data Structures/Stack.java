class Node{

int val;
Node next;
Node(int data){
this.val = data;
this.next = null;
}
}

class LinkedList{
Node head;
LinkedList(int data){
this.head = new Node(data);
}
}

// Implementation of stack using LinkedList
class Stack{

LinkedList stack;

Stack(int data){
stack = new LinkedList(data);
}

void push(int value){

Node newNode = new Node(value);
newNode.next = stack.head;
stack.head = newNode;

}

int top(){
return stack.head.val;
}

void pop(){
Node delNode = stack.head;
stack.head = delNode.next;
}

}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Stack stack = new Stack(5);
		System.out.println(stack.top());
		stack.push(6);
		stack.push(8);
		stack.push(9);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.push(10);
		stack.push(11);
		stack.push(12);
		System.out.println(stack.top());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.top());
	}
}
