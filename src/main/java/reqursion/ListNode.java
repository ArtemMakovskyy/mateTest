package reqursion;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createLinkedList(int[] elements) {
        if (elements.length == 0) return null;

        ListNode head = new ListNode(elements[0]);
        ListNode current = head;

        for (int i = 1; i < elements.length; i++) {
            current.next = new ListNode(elements[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Для новой строки после окончания списка
    }
}
