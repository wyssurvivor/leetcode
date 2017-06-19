package com.ssdut.wys.ds;

/**
 * Created by wangyongshan on 17-6-7.
 */
public class htci4_3 {

    public TreeNode buildTree(int[] numbers, int start, int end) {
        if(start>end) {
            return null;
        }

        int mid = start + (end-start)/2;
        TreeNode left = buildTree(numbers, start, mid-1);
        TreeNode right = buildTree(numbers, mid+1, end);
        TreeNode root = new TreeNode(numbers[mid]);
        root.left = left;
        root.right = right;
        return root;
    }
}
