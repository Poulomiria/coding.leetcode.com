package BinaryTree;

public class MaxPathSum {
    int maxsum = 0;
    public int maxPathSum(TreeNode root)
    {
        if(root != null)
        {
            helper(root);

        }
        return maxsum;
    }
    public int helper(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int gainfromleft = Math.max(0, root.left.val);
        int gainfromright = Math.max(0, root.right.val);
        maxsum = Math.max(maxsum, gainfromleft + gainfromright + root.val);
        return Math.max(root.val + root.left.val, root.val+root.right.val);
    }
}
