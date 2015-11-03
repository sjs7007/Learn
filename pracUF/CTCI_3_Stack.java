//simple stack using linked list

class Node {
	Object data;
	Node next;

	Node(Object x) {
		data=x;
	}
}
class Stack {
	Node top=null;

	Object pop() {
		Object temp=null;
		if(top!=null) {
			temp=top.data;
			top=top.next;
		} 
		return temp;
	}

	void push(Object x) {
		Node n = new Node(x);
		n.next = top;
		top = n;
	}

	Object peek() {
		return top.data;
	} 
}

class CTCI_3_Stack {
	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(4);
		System.out.println(s.peek());
		s.push(3); 
		System.out.println(s.peek());
		s.pop(); 
		System.out.println(s.peek());
	}
}