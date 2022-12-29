package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class InorderTraversal {

    //Recursive
    //Time : O(n), Space : O(n)
    public void inorderhelper(TreeNode root, ArrayList list)
    {
        if(root != null)
        {
            inorderhelper(root.left, list);
            list.add(root.val);
            inorderhelper(root.right, list);
        }
    }
    //Iterative using stack
    // Time : O(n), Space : O(n)
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null)
        {
            return result;
        }
        TreeNode curr = root;

            st.push(curr);
        while(!st.isEmpty() || curr != null)
        {
            while(curr != null)
            {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            result.add(curr.val);
            curr = curr.right;
        }

            return  result;
    }
    //Morris Traversal - Threaded Binary Tree
    // Time : O(n), Space : O(1)
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }


}
