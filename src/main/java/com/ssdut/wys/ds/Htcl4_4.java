package com.ssdut.wys.ds;

import java.util.List;

/**
 * Created by wangyongshan on 17-6-7.
 */
public class Htcl4_4 {
    public void createLevelLinkedList(TreeNode root) {

    }

    public void createLevelLinkedList(TreeNode root, List<TreeNode> list, int level, int targetLevel) {
        if(root == null) {
            return;
        }

        if(level == targetLevel) {
            list.add(root);
        }

        createLevelLinkedList(root.left, list, level+1, targetLevel);
        createLevelLinkedList(root.right, list, level+1, targetLevel);
        return;
    }
}
