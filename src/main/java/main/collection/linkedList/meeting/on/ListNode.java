package main.collection.linkedList.meeting.on;

public class ListNode {
    public int value;
    public ListNode prev;
    public ListNode next;

    public ListNode(int x) {
        value = x;
    }

    @Override
    public String toString() {
        return
                "value=" + value;

    }
}