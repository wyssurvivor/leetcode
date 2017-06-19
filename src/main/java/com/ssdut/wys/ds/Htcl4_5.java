package com.ssdut.wys.ds;

/**
 * Created by wangyongshan on 17-6-7.
 */
public class Htcl4_5 {

    public boolean isBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isBST(root.left)&&isBST(root.right);
    }
}
