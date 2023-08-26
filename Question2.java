import java.util.Scanner;

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;
}

public class Question2 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); //Total number of test cases

        for (int i = 0; i < t; i++) 
        {
            int n = scanner.nextInt(); //Total number of elements in the linked list
            DoublyLinkedListNode head = null;

            for (int j = 0; j < n; j++) 
            {
                int value = scanner.nextInt(); //Data for each node
                head = sortedInsert(head, value);
            }

            int data = scanner.nextInt(); // Data to be inserted
            head = sortedInsert(head, data);

            // Display the sorted linked list
            printList(head);
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) 
    {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode();
        newNode.data = data;

        if (head == null) 
        {
            return newNode;
        }

        if (data <= head.data) 
        {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        DoublyLinkedListNode current = head;

        while (current.next != null && current.next.data < data) 
        {
            current = current.next;
        }

        newNode.prev = current;
        newNode.next = current.next;

        if (current.next != null) 
        {
            current.next.prev = newNode;
        }
        current.next = newNode;

        return head;
    }

    static void printList(DoublyLinkedListNode head) 
    {
        DoublyLinkedListNode current = head;
        while (current != null) 
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
