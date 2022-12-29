package BinaryTree;

public class MaxDepth {

    public int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        else {
            int leftH = maxDepth(root.left);
            int rightH = maxDepth(root.right);
            return 1 + Math.max(leftH, rightH);
        }
    }

}
