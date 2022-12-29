package BinaryTree;

import java.util.ArrayList;

public class PostorderTraversal {

    //Recursive
    public void postorderhelper(TreeNode root, ArrayList list)
    {
        if(root != null)
        {
            postorderhelper(root.left, list);
            postorderhelper(root.right, list);
            list.add(root.val);
        }
    }
}
