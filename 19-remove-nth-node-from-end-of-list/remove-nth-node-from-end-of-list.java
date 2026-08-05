class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Create a dummy node before the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Both pointers start from dummy
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n+1 steps ahead
        // This keeps slow one node before the node to delete
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}