import java.util.Scanner;

/*
 * Node class represents a single node of the linked list
 */
class Node {
    int data;      // Stores data of the node
    Node next;     // Points to the next node

    // Constructor to initialize node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RotateList {

    /*
     * Inserts a new node at the end of the linked list
     */
    static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data); // Create new node

        // If list is empty, new node becomes head
        if (head == null)
            return newNode;

        // Traverse till last node
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        // Attach new node at the end
        temp.next = newNode;
        return head;
    }

    /*
     * Prints the linked list
     */
    static void printList(Node head) {
        // Traverse and print nodes
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null"); // End of list
    }

    /*
     * Rotates the linked list to the right by k places
     */
    static Node rotateRight(Node head, int k) {

        // Edge cases: empty list or single node
        if (head == null || head.next == null)
            return head;

        // Step 1: Find length of list and last node (tail)
        int len = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Step 2: Reduce k if k > length
        k = k % len;

        // If no rotation needed
        if (k == 0)
            return head;

        // Step 3: Make list circular
        tail.next = head;

        // Step 4: Move to the new tail (len - k steps)
        for (int i = 0; i < len - k; i++)
            tail = tail.next;

        // Step 5: Break the circle
        Node newHead = tail.next; // New head
        tail.next = null;         // Break link

        return newHead;
    }

    /*
     * Main method - execution starts here
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        // Read number of nodes
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Read list elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            head = insertAtEnd(head, sc.nextInt());

        // Read number of rotations
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // Rotate the list
        head = rotateRight(head, k);

        // Print rotated list
        printList(head);
    }
}
// Output:
// Enter number of nodes: 5
// Enter elements:
// 1 2 3 4 5
// Enter k: 2
// 4 -> 5 -> 1 -> 2 -> 3 -> null
