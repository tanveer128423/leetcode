class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            // Connect left child to right child
            root.left.next = root.right;

            // Connect right child to next node's left child
            if (root.next != null) {
                root.right.next = root.next.left;
            }

            // Recursively connect the next level
            connect(root.left);
            connect(root.right);
        }

        return root;
    }
}