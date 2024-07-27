
class Main{
	public static void main(String[] args) {
	
		Stack s = new Stack();
		s.push(5);
		s.push(3);
		s.push(3);
		System.out.println("peeked element is : "+s.peek());
		System.out.println("popped element is : "+s.pop());
		s.display();
		s.pop();
		s.pop();
		s.pop();
		s.display();
	}

}

