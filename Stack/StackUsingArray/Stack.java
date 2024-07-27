package com.StackArr;

public class Stack {
	int arr[];
	int top = -1;
	Stack(int size){
		arr = new int[size];
	}
	

	public boolean isFull() {
		if(top==arr.length-1) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}
	
	public void push(int data) {
		if(!(isFull())) {
			top++;
			arr[top] = data;
		}
		else {
			System.out.println("Stack is full");
		}
	}
	
	public int pop() {
		System.out.println();
		if(isEmpty()) {
			return -1; // if stack is empty
		}
		else {
			return arr[top--];
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;
		}else {
			return arr[top];
		}
	}
	
	public void delete() {
		System.out.println("stack is deleted");
		arr = null;
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("stack is empty !!");
		}else {
			for(int i = 0; i<=top; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}
	
}
