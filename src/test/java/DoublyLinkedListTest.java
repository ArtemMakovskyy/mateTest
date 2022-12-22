import main.collection.linkedList.meeting.on.DoublyLinkedList;
import main.collection.linkedList.meeting.on.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class DoublyLinkedListTest {
    @Test
    public void insertNode_twoIntegersList() {
        ListNode value1 = new ListNode(1);
        ListNode value3 = new ListNode(3);
        value1.next = value3;
        value3.prev = value1;
        ListNode value2 = new ListNode(2);
        DoublyLinkedList.insertNode(value1, value2);
        Assert.assertEquals("The next value for 1 should be 2 if the head = [1, 3], previous = 1 and newNode = 2\n",
                2, value1.next.value);
        Assert.assertEquals("The previous value for 2 should be 1 if the head = [1, 3], previous = 1 and newNode = 2\n",
                1, value2.prev.value);
        Assert.assertEquals("The next value for 2 should be 3 if the head = [1, 3], previous = 1 and newNode = 2\n",
                3, value2.next.value);
        Assert.assertEquals("The previous value for 3 should be 2 if the head = [1, 3], previous = 1 and newNode = 2\n",
                2, value3.prev.value);
    }

    @Test
    public void insertNode_newNodeEqualsZero() {
        ListNode value1 = new ListNode(20);
        ListNode value3 = new ListNode(71);
        value1.next = value3;
        value3.prev = value1;
        ListNode value2 = new ListNode(0);
        DoublyLinkedList.insertNode(value1, value2);
        Assert.assertEquals("The next value for 20 should be 0 if the head = [20, 71], previous = 20 and newNode = 0\n",
                0, value1.next.value);
        Assert.assertEquals("The previous value for 0 should be 20 if the head = [20, 71], previous = 20 and newNode = 0\n",
                20, value2.prev.value);
        Assert.assertEquals("The next value for 0 should be 71 if the head = [20, 71], previous = 20 and newNode = 0\n",
                71, value2.next.value);
        Assert.assertEquals("The previous value for 71 should be 0 if the head = [20, 71], previous = 20 and newNode = 0\n",
                0, value3.prev.value);
    }

    @Test
    public void insertNode_negativeIntegersList() {
        ListNode value1 = new ListNode(-3);
        ListNode value3 = new ListNode(-10);
        value1.next = value3;
        value3.prev = value1;
        ListNode value2 = new ListNode(-492);
        DoublyLinkedList.insertNode(value1, value2);
        Assert.assertEquals("The next value for -3 should be -492 if the head = [-3, -10], previous = -3 and newNode = -492\n",
                -492, value1.next.value);
        Assert.assertEquals("The previous value for -492 should be -3 if the head = [-3, -10], previous = -3 and newNode = -492\n",
                -3, value2.prev.value);
        Assert.assertEquals("The next value for -492 should be -10 if the head = [-3, -10], previous = -3 and newNode = -492\n",
                -10, value2.next.value);
        Assert.assertEquals("The previous value for -10 should be -492 if the head = [-3, -10], previous = -3 and newNode = -492\n",
                -492, value3.prev.value);
    }

    @Test
    public void insertNode_threeIntegersList() {
        ListNode value1 = new ListNode(5);
        ListNode value2 = new ListNode(-17);
        ListNode value4 = new ListNode(32);
        value1.next = value2;
        value2.prev = value1;
        value2.next = value4;
        value4.prev = value2;
        ListNode value3 = new ListNode(238);
        DoublyLinkedList.insertNode(value2, value3);
        Assert.assertEquals("The next value for -17 should be 238 if the head = [5, -17, 32], previous = -17 and newNode = 238\n",
                238, value2.next.value);
        Assert.assertEquals("The previous value for 238 should be -17 if the head = [5, -17, 32], previous = -17 and newNode = 238\n",
                -17, value3.prev.value);
        Assert.assertEquals("The next value for 238 should be 32 if the head = [5, -17, 32], previous = -17 and newNode = 238\n",
                32, value3.next.value);
        Assert.assertEquals("The previous value for 32 should be 238 if the head = [5, -17, 32], previous = -17 and newNode = 238\n",
                238, value4.prev.value);
    }

    @Test
    public void insertNode_twoNodesInserted() {
        ListNode value1 = new ListNode(490);
        ListNode value2 = new ListNode(-25);
        ListNode value5 = new ListNode(81);
        value1.next = value2;
        value2.prev = value1;
        value2.next = value5;
        value5.prev = value2;
        ListNode value3 = new ListNode(11);
        ListNode value4 = new ListNode(4);
        DoublyLinkedList.insertNode(value2, value3);
        DoublyLinkedList.insertNode(value3, value4);
        Assert.assertEquals("The next value for -25 should be 11 if the head = [490, -25, 81] and nodes 11 and 4 are inserted after node -25\n",
                11, value2.next.value);
        Assert.assertEquals("The previous value for 11 should be -25 if the head = [490, -25, 81] and nodes 11 and 4 are inserted after node -25\n",
                -25, value3.prev.value);
        Assert.assertEquals("The next value for 11 should be 4 if the head = [490, -25, 81] and nodes 11 and 4 are inserted after node -25\n",
                4, value3.next.value);
        Assert.assertEquals("The previous value for 4 should be 11 if the head = [490, -25, 81] and nodes 11 and 4 are inserted after node -25\n",
                11, value4.prev.value);
        Assert.assertEquals("The next value for 4 should be 81 if the head = [490, -25, 81] and nodes 11 and 4 are inserted after node -25\n",
                81, value4.next.value);
        Assert.assertEquals("The previous value for 81 should be 4 if the head = [490, -25, 81] and nodes 11 and 4 are inserted after node -25\n",
                4, value5.prev.value);
    }
}
