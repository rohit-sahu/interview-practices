package io.devzona.interview_practices.company;

import io.devzona.interview_practices.dsa.TreeNode;
import lombok.Data;

import java.util.*;

/**
 * Question
 *
 * Given the root of a binary tree, the task is to print level order traversal in a way that nodes of all levels are printed in separate lines.
 *
 * Example:
 *
 * Input:
 * Output:
 * 20
 * 8 22
 * 4 12
 * 10 14
 *
 * Input:
 *          1
 *       /     \
 *      2       3
 *    /   \
 *  4     5
 *
 * Output:
 * 1
 * 2 3
 * 4 5
 */
public class EncoraTree {

    public static void bfsTraversal(TreeNodes rootNode) {
        if (rootNode == null) {
            System.out.println("tree is empty");
            return;
        }
        Queue<TreeNodes> queue =  new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            TreeNodes c = queue.poll();
            System.out.println(c.value + " ");
            if (c.left != null) {
                queue.add(c.left);
            }
            if (c.right != null) {
                queue.add(c.right);
            }
        }
    }
}

@Data
class TreeNodes {
    int value;
    TreeNodes left;
    TreeNodes right;
}
