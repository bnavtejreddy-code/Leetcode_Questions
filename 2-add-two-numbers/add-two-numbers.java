/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify list construction
        ListNode dummy = new ListNode(0);

        // Pointer to build the answer
        ListNode current = dummy;

        // Initially there is no carry
        int carry = 0;

        // Continue while any list has nodes
        // or a carry remains
        while (l1 != null || l2 != null || carry != 0) {

            // Values from current nodes
            int x = 0;
            int y = 0;

            if (l1 != null)
                x = l1.val;

            if (l2 != null)
                y = l2.val;

            // Total sum
            int sum = x + y + carry;

            // New carry
            carry = sum / 10;

            // Digit to store
            int digit = sum % 10;

            // Create new node
            current.next = new ListNode(digit);

            // Move current
            current = current.next;

            // Move l1
            if (l1 != null)
                l1 = l1.next;

            // Move l2
            if (l2 != null)
                l2 = l2.next;
        }

        // Skip dummy node
        return dummy.next;
    }
}