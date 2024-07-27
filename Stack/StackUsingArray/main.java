package com.StackArr;

public class main {
	public static void main(String args[]) {
		Stack s = new Stack(5);
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.display();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.display();
		s.peek();
	}
}
