package Problems;

import Problems.Entities.Pair;
import Problems.Entities.TreeNode;

public class Q1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root, 0).ans;
    }

    private Pair helper(TreeNode root, int depth) {
        if(root != null) {
            Pair leftSub = helper(root.left, depth + 1);
            Pair rightSub = helper(root.right, depth + 1);
            if(leftSub.depth > rightSub.depth) {
                return leftSub;
            } else if(leftSub.depth < rightSub.depth) {
                return rightSub;
            } else if(leftSub.depth != -1){
                return new Pair(leftSub.depth, root);
            } else {
                return new Pair(depth, root);
            }
        }
        return new Pair(-1, root);
    }
}
