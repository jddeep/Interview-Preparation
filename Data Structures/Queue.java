class Node{
int val;
Node next;
Node(int data){
this.val = data;
this.next = null;
}
}

class Queue{

Node front;
Node rear;

Queue(int data){
this.front = new Node(data);
this.rear = this.front;
}

void add(int data){
Node newNode = new Node(data);
this.rear.next = newNode;
this.rear = newNode;
}

void delete(){
Node delNode = this.front;
this.front = delNode.next;
}

int peekFirst(){
return this.front.val;
}

int peekLast(){
return this.rear.val;
}

}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Queue q = new Queue(5);
		System.out.println(q.peekFirst());
		System.out.println(q.peekLast());
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);
		q.add(6);
		q.delete();
		q.delete();
		System.out.println(q.peekFirst());
		System.out.println(q.peekLast());
	}
}
