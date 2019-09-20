package org.wy.dataStructure.tree;



/**
 * 二叉搜索树
 * 左子树的所有节点小于(或等于)根节点
 * 右子树大于(或等于)根节点
 */
public class BinarySearchTree {


    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    /**
     * 判断二叉搜索树
     * @param root
     * @param max
     * @param min
     * @return
     */
    public boolean isBST(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
    }

    public static class WidthSearch {




    }
}
