package tasks.other;

public class SinglyLinkedList {
    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
