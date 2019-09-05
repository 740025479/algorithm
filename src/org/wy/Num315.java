package org.wy;

import java.util.ArrayList;
import java.util.List;

public class Num315 {
    public static void main(String[] args) {

        Num315 num315 = new Num315();
        int[] input = new int[]{5,2,6,1};
        num315.countSmaller(input);

    }

    /**
     * 时间复杂度O(n2)
     * @param nums
     * @return
     */
    public List<Integer> countSmaller1(int[] nums) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]<nums[i]){
                    temp++;
                }
            }
            res.add(temp);
        }
        return res;
    }



    /**
     * 时间复杂度O(nlogn)
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums){

        List<Integer> res = new ArrayList<>();
        if (nums.length<1) return res;
        TreeNode root = null;
        for (int i = nums.length-1; i >=0 ; i--) {
            root = insertBinaryTree(root,i,0,nums,res);
        }
        return res;
    }

    private TreeNode insertBinaryTree(TreeNode root,int index,int count,int[] nums,List<Integer> res){
        if (root==null){
            root = new TreeNode(nums[index]);
            /** 下面这行代码必须注释，因为count是会变化的，所以每次插入新数据时，重新开始计算 */
            //root.count = count;
            res.add(0,count);
            return root;
        }
        if (root.val>=nums[index]){
            root.count++;
            root.left = insertBinaryTree(root.left,index,count,nums,res);
        }else if (root.val<nums[index]){
            /** 下面这行必须这样 */
            count+=(root.count+1);
            root.right = insertBinaryTree(root.right,index,count,nums,res);
        }
        return root;
    }


    private class TreeNode{
        /** 维护一个保存左子树节点数量的值 而不是比该节点小的数的数量！！！谨记*/
        int count;
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


}
