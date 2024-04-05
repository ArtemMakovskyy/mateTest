package tasks;

class AddTwoNumbers {
    public static Node addTwoNumbers(Node list1, Node list2) {
        Node head = new Node(0);
        Node listNumbers1 = list1;
        Node listNumbers2 = list2;
        Node current = head;
        int carry = 0;
        while (listNumbers1 != null || listNumbers2 != null) {
            int x = (listNumbers1 != null) ? listNumbers1.data : 0;
            int y = (listNumbers2 != null) ? listNumbers2.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new Node(sum % 10);
            current = current.next;
            if (listNumbers1 != null) {
                listNumbers1 = listNumbers1.next;
            }
            if (listNumbers2 != null) {
                listNumbers2 = listNumbers2.next;
            }
        }
        if (carry > 0) {
            current.next = new Node(carry);
        }
        return head.next;
    }
}