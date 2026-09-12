class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        // Base case
        if (head == null) {
            return null;
        }

        // If only one node
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // Find middle node
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half from middle
        prev.next = null;

        // slow is the middle node
        TreeNode root = new TreeNode(slow.val);

        // Left half
        root.left = sortedListToBST(head);

        // Right half
        root.right = sortedListToBST(slow.next);

        return root;
    }
}