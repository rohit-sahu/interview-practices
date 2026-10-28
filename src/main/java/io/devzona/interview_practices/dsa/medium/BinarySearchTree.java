package io.devzona.interview_practices.dsa.medium;

import io.devzona.interview_practices.dsa.TreeNode;

public class BinarySearchTree {

    /**
     * 701. Insert into a Binary Search Tree
     * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
     * <p>
     * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
     * <p>
     * Example 1:
     * Input: root = [4,2,7,1,3], val = 5
     * Output: [4,2,7,1,3,5]
     * <p>
     * Example 2:
     * Input: root = [40,20,60,10,30,50,70], val = 25
     * Output: [40,20,60,10,30,50,70,null,null,25]
     * <p>
     * Example 3:
     * Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
     * Output: [4,2,7,1,3,5]
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.getVal() > val) {
            if (root.getLeft() != null) {
                insertIntoBST(root.getLeft(), val);
            } else {
                root.setLeft(new TreeNode(val));
                return root;
            }
        } else {
            if (root.getRight() != null) {
                insertIntoBST(root.getRight(), val);
            } else {
                root.setRight(new TreeNode(val));
                return root;
            }
        }
        return root;
    }

    /**
     * 700. Search in a Binary Search Tree
     * <p>
     * Example 1:
     * Input: root = [4,2,7,1,3], val = 2
     * Output: [2,1,3]
     * <p>
     * Example 2:
     * Input: root = [4,2,7,1,3], val = 5
     * Output: []
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.getVal() == val) {
            return root;
        } else if (root.getVal() > val) {
            return searchBST(root.getLeft(), val);
        } else {
            return searchBST(root.getRight(), val);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = insertIntoBST(null, 4);
        insertIntoBST(treeNode, 2);
        insertIntoBST(treeNode, 7);
        insertIntoBST(treeNode, 1);
        insertIntoBST(treeNode, 3);
        insertIntoBST(treeNode, 5);
        System.out.println(treeNode);
    }
}
