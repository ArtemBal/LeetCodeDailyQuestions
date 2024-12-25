package Problems;

import Problems.Entities.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            int max = nodes.peek().val;
            for(int i = nodes.size(); i > 0; i--) {
                TreeNode node = nodes.poll();
                max = Math.max(node.val, max);

                if(node.left != null) {
                    nodes.offer(node.left);
                }
                if(node.right != null) {
                    nodes.offer(node.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
