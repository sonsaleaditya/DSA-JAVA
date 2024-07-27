package com.SingleLinkedList;
import java.util.Scanner;
public class SingleLinkedList {

    public static int size = 0;
    public static Node head = null, tail = null;

    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {

        SingleLinkedList sl = new SingleLinkedList();
        for (int i = 0; i < 5; i++) {
            sl.insertNodeAtEnd();
        }

        // sl.insertBeforeNode();

        // sl.searchNode();
        sl.deleteNode();
        sl.display(head);
        System.out.println("size of LinkedLiset : " + size);
    }

    Node createList(int val) {
        return new Node(val);
    }

    void insertNodeAtEnd() {
        int n;
        System.out.print("enter the data : ");

        n = sc.nextInt();
        if (size == 0) {
            head = createList(n);
            tail = head;
            size++;
        } else {
            size++;
            tail.next = createList(n);
            tail = tail.next;
        }
    }

    void insertNodeAtFirst() {
        int n;
        System.out.print("enter the data : ");

        n = sc.nextInt();
        if (size == 0) {
            head = createList(n);
            tail = head;
            size++;
        } else {
            size++;
            Node temp = createList(n);
            temp.next = head;
            head = temp;
        }
    }

    void insertAfterNode() {
        if (size == 0 && head == null) {
            System.out.println("list is empty !!");
        } else {
            System.out.println(" enter the node data to point node : ");
            int val = sc.nextInt();
            System.out.println("enter the data to insert after : ");
            int newdata = sc.nextInt();
            Node temp = head;
            Node prev = null;
            while (!(temp.data == val)) {
                prev = temp;
                temp = temp.next;
            }
            if (temp.next != null) {
                prev = temp;
                temp = temp.next;
                prev.next = createList(newdata);
                prev = prev.next;
                prev.next = temp;

            } else {
                temp.next = createList(newdata);
                temp = temp.next;
                tail = temp;
            }
            size++;

            System.out.println("temp : " + temp.data + "prev : " + prev.data);
        }
    }

    void insertBeforeNode() {
        if (size == 0 && head == null) {
            System.out.println("list is empty !!");
        } else {
            System.out.println(" enter the node data to point node : ");
            int val = sc.nextInt();
            System.out.println("enter the data to insert before : ");
            int newdata = sc.nextInt();
            Node temp = head;
            Node prev = null;
            while (!(temp.data == val)) {
                prev = temp;
                temp = temp.next;
            }

            if (temp == head) {
                prev = createList(newdata);
                prev.next = temp;
                head = prev;
            } else {
                prev.next = createList(newdata);
                prev = prev.next;
                prev.next = temp;
            }

            size++;

            System.out.println("temp : " + temp.data + "prev : " + prev.data);
        }
    }

    void display(Node head) {
        Node temp = head;
        if (size == 0 && head == null) {
            System.out.println("LinkedList is Empty!!! ");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    void searchNode() {
        if (head == null) {
            System.out.println("List is Empty !! ");
        } else {
            System.out.print("enter the data to search : ");
            int n = sc.nextInt();
            int pos = -1;
            Node temp = head;
            while (temp != null) {
                pos++;
                if (temp.data == n) {
                    System.out.println("Node Found at Position : " + pos);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("data not found !!! ");
        }
    }

    void deleteNode() {
        if (head == null) {
            System.out.println("List is Empty !! ");
        } else {
            System.out.print("enter the data to delete : ");
            int n = sc.nextInt();
            Node temp, prev;
            temp = head;
            prev = null;

            if (temp.data == n) {
                System.out.println(temp.data + " Deleted Succesfully !! ");

                temp = temp.next;
                head = temp;
                size--;

                return;

            }

            while (!(temp.data == n)) {
                prev = temp;
                temp = temp.next;
                if (temp.data == n) {
                    System.out.println(temp.data + " Deleted Succesfully !! ");
                    System.out.println("HII" + prev.data);
                    temp = temp.next;
                    prev.next = temp;

                }
                size--;
                return;
            }

        }
    }
}

