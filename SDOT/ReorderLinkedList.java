class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReorderLinkedList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // STEP 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2: Reverse second half
        ListNode second = slow.next;
        slow.next = null; // break list

        ListNode prev = null;
        while (second != null) {
            ListNode nextNode = second.next;
            second.next = prev;
            prev = second;
            second = nextNode;
        }

        // STEP 3: Merge two halves
        ListNode first = head;
        ListNode secondHalf = prev;

        while (secondHalf != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = secondHalf.next;

            first.next = secondHalf;
            secondHalf.next = temp1;

            first = temp1;
            secondHalf = temp2;
        }
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);
        printList(head);
    }
}
