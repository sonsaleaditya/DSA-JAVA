public class Stack {
	Node top=null;
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

public boolean isEmpty() {
	if(top == null) {
		return true;
	}
	return false;
}

public void push(int data){
	
	if((isEmpty())) {
		top = new Node(data);
		
	}else {
	Node newnode= new Node(data);
	newnode.next = top;
	top = newnode;
	
	}
}

public int pop() {
	Node temp = null;
	if(isEmpty()) {
		System.out.println("stack is empty");
		return -1;
		
	}
	else {
		temp = top;
		if(top.next!=null) {
			top = top.next;
		}
		else {
			top = null;
		}
		
	}
	return temp.data;
}

public int peek() {
	if(isEmpty()) {
		System.out.println("stack is empty");
		return -1;
		
	}else {
		return top.data;
	}
}
public void delete() {
	if(isEmpty()) {
		System.out.println("stack is already empty");
		
	}
	top = null;
	System.out.println("stack is deleted");
}

public void display() {
	if(isEmpty()) {
		System.out.println("stack is empty !!");
	}
	Node temp = top;
	while(temp!=null) {
		System.out.print(temp.data+" ");
		temp = temp.next;
	}
	System.out.println();
	
}

}


