package Problems;

import Problems.Entities.TreeNode;

public class Q1123 {
    TreeNode ans = null;
    int maxD = -1;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private int helper(TreeNode root, int depth) {
        if(root != null) {
            int leftSub = helper(root.left, depth + 1);
            int rightSub = helper(root.right, depth + 1);
            if(leftSub == rightSub && leftSub == maxD) {
                ans = root;
            }
            return Math.max(leftSub, rightSub);
        }
        if(depth > maxD) {
            maxD = depth;
        }
        return depth;
    }
}
