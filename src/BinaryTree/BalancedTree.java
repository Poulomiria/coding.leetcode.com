package BinaryTree;

public class BalancedTree {
    public static boolean isBalanced(TreeNode root)
    {
     return helper(root) != -1;
    }
    public static int helper(TreeNode root)
    {
        if(root == null)
            return  0;
        else{
            int lh = helper(root.left);
            int rh = helper(root.right);
            if(lh == -1)
                return -1;
            if(rh == -1)
                return -1;
            return Math.abs(lh - rh) > 1? -1 : Math.max(lh, rh) + 1;
        }

    }
    public static void main(String args[])
    {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(9);
        t.right = new TreeNode(5);
        t.right.left = new TreeNode(4);
        t.right.right = new TreeNode(6);
        System.out.println(isBalanced(t));
    }
}
