package io.kvh.algorithm.w2.c6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kvh on 2020/6/26.
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);

        System.out.println(inorderTraversal2(root));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //termination
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        //current
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int i = 0;
        while (preorder[0] != inorder[i]) {
            i++;
            // <----left---i----right---->
        }

        //drill down
        int[] lpreorder = Arrays.copyOfRange(preorder, 1, i + 1);
        int[] linorder = Arrays.copyOfRange(inorder, 0, i);

        root.left = buildTree(lpreorder, linorder);

        int[] rpreorder = Arrays.copyOfRange(preorder, i + 1, preorder.length);
        int[] rinorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);

        root.right = buildTree(rpreorder, rinorder);

        return root;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        helper(root, result);
        return result;
    }

    public static void helper(TreeNode root, List<Integer> result) {
        //termination
        if (root == null) {
            return;
        }

        //in-order
        if (root.left != null) {
            helper(root.left, result);
        }

        result.add(root.val);

        if (root.right != null) {
            helper(root.right, result);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
