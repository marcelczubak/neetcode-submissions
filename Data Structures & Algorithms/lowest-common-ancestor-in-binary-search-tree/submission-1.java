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
 



 // If the current node == p or == q, the node is the LCA

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //if (root == null) return root;

         // If p and q are in different subtrees ... current node is the LCA
        if ((p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val)) return root;

        // If p and q are both in the same subtree ... go deeper to that subtree
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        

        return root;
    }
}
