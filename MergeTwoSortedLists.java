import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeTwoSortedLists {

    static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    static Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }              
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node l1 = null, l2 = null;

        System.out.print("Enter size of first list: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements (sorted):");
        for (int i = 0; i < n1; i++)
            l1 = insertAtEnd(l1, sc.nextInt());

        System.out.print("Enter size of second list: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements (sorted):");
        for (int i = 0; i < n2; i++)
            l2 = insertAtEnd(l2, sc.nextInt());

        Node result = merge(l1, l2);
        printList(result);
    }
}
