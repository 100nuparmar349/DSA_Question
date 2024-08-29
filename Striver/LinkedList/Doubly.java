import java.util.*;

class Node {
    int data;
    Node next;
    Node back;

    // Constructor for initializing Node with next and back pointers
    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    // Constructor for initializing Node without next and back pointers
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class Doubly {
    public static Node convertArrToLL(List<Integer> arr) {
        if (arr.isEmpty()) return null; // Handle empty array case

        Node head = new Node(arr.get(0));
        Node prev = head;

        for (int i = 1; i < arr.size(); i++) {
            Node temp = new Node(arr.get(i), null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head; // Return the head of the linked list
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void  main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 1, 4, 5);
        Node head = convertArrToLL(arr);
        print(head);
        System.out.println("Hello");
    }
}
