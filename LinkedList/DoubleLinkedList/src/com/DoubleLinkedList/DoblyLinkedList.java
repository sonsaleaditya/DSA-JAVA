package com.DoubleLinkedList;
import java.util.Scanner;
public class DoblyLinkedList {
	
     static Node head,tail;
     static int size;
     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        DoblyLinkedList dl = new DoblyLinkedList();
        Node n = dl.createNode(5);
        System.out.println(n.data);
        for(int i =0;i<5; i++)
            dl.insertAtFirst();
        
        dl.display();
    }

    Node createNode(int val){
        return new Node(val);
    }

    void insertAtFirst(){
        System.out.print("enter the data : ");
        System.out.println();
        int n = sc.nextInt();
        if(head==null){
            head = createNode(n);
            tail = head;

        }
        else{
            tail.next = createNode(n);
            tail = tail.next;
        }
    }

    void display(){
        if(head == null){
            System.out.println("list is empty!!");
        }
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }
    
}


