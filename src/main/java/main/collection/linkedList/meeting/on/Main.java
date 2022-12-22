package main.collection.linkedList.meeting.on;

public class Main {
    public static void main(String[] args) {
        ListNode value1 = new ListNode(1);
        ListNode value2 = new ListNode(2);
        ListNode value3 = new ListNode(3);
        value1.next = value2;
        value2.prev = value1;
        value2.next = value3;
        value3.prev = value2;
        DoublyLinkedList.deleteNode(value2);


    }
}
