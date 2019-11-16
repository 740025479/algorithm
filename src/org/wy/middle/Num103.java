package org.wy.middle;

import org.wy.dataStructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean toRight = true;
        List<List<Integer>> res = new ArrayList<>();
        if (root==null)return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while (size>0){
                TreeNode treeNode = queue.poll();
                if (toRight)
                list.add(treeNode.val);
                else list.add(0,treeNode.val);
                size--;
                if (treeNode.left!=null){queue.offer(treeNode.left);}
                if (treeNode.right!=null){queue.offer(treeNode.right);}
            }
            res.add(list);
            toRight=!toRight;
        }
        return res;
    }


}
