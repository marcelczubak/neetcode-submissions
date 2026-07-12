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
    TreeNode kthSmallest;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return kthSmallest.val;
    }

    private void inOrderTraversal(TreeNode root, int k) {

        if (root == null) return;

        inOrderTraversal(root.left, k);

        // current node
        count++;
        if (count == k) {
            kthSmallest = root;
            return;
        }

        inOrderTraversal(root.right, k);


    }
}
