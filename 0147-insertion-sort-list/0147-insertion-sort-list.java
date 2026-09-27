class Solution {
    public ListNode insertionSortList(ListNode head) {

        // Dummy node helps us insert before the first element
        ListNode dummy = new ListNode(0);

        ListNode current = head;

        while (current != null) {

            // Save the next node before changing current.next
            ListNode next = current.next;

            // Find where current should be inserted
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Insert current between prev and prev.next
            current.next = prev.next;
            prev.next = current;

            // Move to the next original node
            current = next;
        }

        return dummy.next;
    }
}