package io.devzona.interview_practices.dsa;

import lombok.Data;

@Data
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        super();
    }

    public TreeNode(int val) {
        super();
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
