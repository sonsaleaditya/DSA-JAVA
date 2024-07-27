package com.DoubleLinkedList;
import java.util.Scanner;

public class DoublyCircularLinkedList {
    static Node head, tail;
    static int size;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DoublyCircularLinkedList dl = new DoublyCircularLinkedList();
        Node n = dl.createNode(5);
        System.out.println(n.data);
        for (int i = 0; i < 3; i++)
            dl.insertAtEnd();

        dl.delete();
        dl.display();
        
    }

    Node createNode(int val) {
        return new Node(val);
    }

    void insertAtFirst() {
        System.out.print("Enter the data : ");
        System.out.println();
        int n = sc.nextInt();

        if (head == null) {
            head = createNode(n);
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            Node newnode = createNode(n);
            newnode.next = head;
            head.prev = newnode;
            newnode.prev = last;
            last.next = newnode;
            head = newnode;
        }
        size++; // Increment size when inserting a node.
    }
    
    void insertAtEnd() {
        System.out.print("Enter the data : ");
        System.out.println();
        int n = sc.nextInt();

        if (head == null) {
            head = createNode(n);
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            Node newnode = createNode(n);
            last.next = newnode;
            newnode.prev =last;
            head.prev = newnode;
            newnode.next = head;
            
        }
        size++; // Increment size when inserting a node.
    }
    
    void delete() {
    	System.out.print("enter the data to delete : ");
    	int n = sc.nextInt();
    	System.out.println();
    	Node temp = head;
    	if(size == 1) {
    		System.out.println(head.data+" is deleted !!");
    		head = null;
    		return;
    	}
    	do {
    		if(temp.data == n) {
    			System.out.println(temp.data+" is deleted !!");
    			temp = temp.prev;
    			temp.next = temp.next.next;
    			return;
    		}
    		temp = temp.next;
    	}while(temp!=head);
    	
    	
    }
    
    void display() {
        if (head == null) {
            System.out.println("List is empty!!");
        }
        Node temp = head;
        do {
            System.out.println(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

}