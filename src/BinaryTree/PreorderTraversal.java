package BinaryTree;

import java.util.ArrayList;

public class PreorderTraversal {
    //Recursive
    public void preorderhelper(TreeNode root, ArrayList list)
    {
        if(root != null)
        {
            list.add(root.val);
            preorderhelper(root.left, list);
            preorderhelper(root.right, list);
        }
    }
}
