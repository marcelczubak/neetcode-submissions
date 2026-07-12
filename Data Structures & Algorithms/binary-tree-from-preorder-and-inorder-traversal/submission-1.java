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

    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        
        return helper(preorder, inorder, 0, inorder.length - 1);
        

    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right) {

        if (left > right) return null;

        int root = preorder[preorderIndex];
        preorderIndex++;
        
        // find root in inorder
        int rootIndex = 0;
        while(rootIndex < inorder.length && inorder[rootIndex] != root) {
            rootIndex++;
        }

        TreeNode node = new TreeNode(root);

        // call helper on both subtrees to L and R of the root in inorder
        node.left = helper(preorder, inorder, left, rootIndex - 1);
        node.right = helper(preorder, inorder, rootIndex + 1, right);

        return node;
    }


}
