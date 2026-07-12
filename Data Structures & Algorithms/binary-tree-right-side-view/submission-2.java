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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();

        bfs(root, result);

        return result;
    }

    private void bfs(TreeNode root, List<Integer> result) {
 
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode remove = queue.remove();

                if (i + 1 == levelSize) result.add(remove.val);

                if (remove.left != null) queue.add(remove.left);
                if (remove.right != null)  queue.add(remove.right);
            }
        }
    }
}
