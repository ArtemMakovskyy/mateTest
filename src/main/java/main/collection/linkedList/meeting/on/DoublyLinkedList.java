package main.collection.linkedList.meeting.on;

public class DoublyLinkedList {
    public static void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    public static void insertNode(ListNode previous, ListNode newNode) {
        // write code here
        System.out.println("++++++++++");

        newNode.prev = previous.next.prev;
        newNode.next = previous.next;
        previous.next = newNode;
        newNode.next.prev = newNode;

        System.out.println(newNode.prev.value);
        System.out.println(newNode.value);
        System.out.println(newNode.next.value);
        System.out.println("++++++++++");
    }
}