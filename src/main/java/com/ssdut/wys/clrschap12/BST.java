package com.ssdut.wys.clrschap12;

/**
 * Created by wangyongshan on 17-3-20.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    public TreeNode(int val) {
        this.val = val;
        this.right = this.left = this.parent = null;
    }
}

public class BST {
    private TreeNode root;

    public void inOrderWalk(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderWalk(root.left);
        System.out.print(root.val + ",");
        inOrderWalk(root.right);
    }

    public void addNode(int val) {
        TreeNode pointer = this.root;
        if (pointer == null) {
            this.root = new TreeNode(val);
            return;
        }

        boolean relationShip = true; // true:left;false:right
        while (true) {
            if (pointer.val > val) {
                if (pointer.left == null) {
                    relationShip = true;
                    break;
                }
                pointer = pointer.left;
            } else {
                if (pointer.right == null) {
                    relationShip = false;
                    break;
                }
                pointer = pointer.right;
            }
        }
        if (relationShip) {
            pointer.left = new TreeNode(val);
            pointer.left.parent = pointer;
        } else {
            pointer.right = new TreeNode(val);
            pointer.right.parent = pointer;
        }
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public TreeNode searchNode(int val) {
        TreeNode pointer = this.root;
        while (pointer != null) {
            if (pointer.val == val) {
                return pointer;
            } else if (pointer.val < val) {
                pointer = pointer.right;
            } else {
                pointer = pointer.left;
            }
        }

        return null;
    }

    public void transplant(TreeNode originNode, TreeNode newNode) {
        if (originNode.parent == null) {
            this.root = newNode;
        } else {
            if (originNode.parent.left == originNode) {
                originNode.parent.left = newNode;
            } else {
                originNode.parent.right = newNode;
            }
        }
        if (originNode != null) {
            originNode.parent = newNode.parent;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.addNode(6);
        bst.addNode(3);
        bst.addNode(2);
        bst.addNode(10);
        bst.addNode(12);
        bst.addNode(7);
        bst.inOrderWalk(bst.getRoot());
        System.out.println(bst.searchNode(7).val);
    }
}
