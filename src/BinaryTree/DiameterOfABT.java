package BinaryTree;

//Max height of a particular node
public class DiameterOfABT {
    private int diameter = 0;
    public int diameter(TreeNode root)
    {
        getMaxheight(root);
        return diameter;
    }

    public int getMaxheight(TreeNode root)
    {
        if(root == null)
            return 0;
        int lh = getMaxheight(root.left);
        int rh = getMaxheight(root.right);
        diameter = Math.max(diameter, lh+rh);
        return Math.max(lh,rh) + 1;
    }

}
