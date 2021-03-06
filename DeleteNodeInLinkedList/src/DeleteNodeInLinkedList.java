/**
 * 
 */

/**
 * @author Kyran
 */
public class DeleteNodeInLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
