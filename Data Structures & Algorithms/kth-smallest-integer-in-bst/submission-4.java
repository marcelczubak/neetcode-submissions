/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int count = 0;
    int target;
    TreeNode kthSmallest;

    public int kthSmallest(TreeNode root, int k) {
        target = k;
        inOrderTraversal(root);
        return kthSmallest.val;
    }

    private void inOrderTraversal(TreeNode root) {

        if (root == null || kthSmallest != null) return;

        // go left
        inOrderTraversal(root.left);

        // current node
        count++;
        if (count == target) {
            kthSmallest = root;
            return;
        }

        // go right
        inOrderTraversal(root.right);
    }
}
