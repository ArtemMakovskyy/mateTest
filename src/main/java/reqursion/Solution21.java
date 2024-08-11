package reqursion;


public class Solution21 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        final ListNode linkedList1 = ListNode.createLinkedList(arr1);
        final ListNode linkedList2 = ListNode.createLinkedList(arr2);
        ListNode.printList(linkedList1);
        ListNode.printList(linkedList2);

        final ListNode result = mergeTwoLists(linkedList1, linkedList2);

        ListNode.printList(result);

    }

    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // Рекурсивно объединяем списки, выбирая наименьший текущий элемент
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Проходим по обоим спискам до конца одного из них
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Если один из списков не закончился, добавляем оставшиеся элементы
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }
        return dummy.next;
    }
}
