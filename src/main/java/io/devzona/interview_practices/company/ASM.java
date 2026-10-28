package io.devzona.interview_practices.company;


import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * Reorder Linked List
 * You are given the head of a singly linked-list.
 *
 * The positions of a linked list of length = 7 for example, can intially be represented as:
 *
 * [0, 1, 2, 3, 4, 5, 6]
 *
 * Reorder the nodes of the linked list to be in the following order:
 *
 * [0, 6, 1, 5, 2, 4, 3]
 *
 * Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
 */
public class ASM {

    public static Nodes reOrder(Nodes node) {
        List<Integer> list = new LinkedList<>();
        List<Integer> newList = new LinkedList<>();
        Nodes temp = node;
        while (temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        int lastIndex = list.size() - 1;
        newList.add(list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            if (i < lastIndex) {
                newList.add(list.get(lastIndex--));
                newList.add(list.get(i));
            } else {
                break;
            }
        }
        int i = 0;
        while (node != null) {
            node.data = newList.get(i++);
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        //[0, 1, 2, 3, 4, 5, 6]
        Nodes node1 = new Nodes();
        node1.data = 0;
        Nodes node2 = new Nodes();
        node2.data = 1;
        node1.next = node2;
        Nodes node3 = new Nodes();
        node3.data = 2;
        node2.next = node3;
        Nodes node4 = new Nodes();
        node4.data = 3;
        node3.next = node4;
        Nodes node5 = new Nodes();
        node5.data = 4;
        node4.next = node5;
        Nodes node6 = new Nodes();
        node6.data = 5;
        node5.next = node6;
        Nodes node7 = new Nodes();
        node7.data = 6;
        node6.next = node7;
        reOrder(node1);
        while (node1 != null) {
            System.out.println(node1.data);
            node1 = node1.next;
        }
    }
}

@Data
class Nodes {
    public int data;
    public Nodes next;
}
