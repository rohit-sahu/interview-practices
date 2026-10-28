package io.devzona.interview_practices.dsa.medium;

import io.devzona.interview_practices.dsa.Node;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {

    public static void removeLoop(Node head) {
        HashSet<Node> st = new HashSet<Node>();
        Node prev = null;
        while (head != null) {
            // If we have already seen this node in hash set, it means there is a cycle.
            // Set the next of the previous pointer to null to remove the cycle.
            if (st.contains(head)) {
                prev.setNext(null);
                return;
            }
            // If we are seeing the node for the first time, insert it in hash set.
            else {
                st.add(head);
                prev = head;
                head = head.getNext();
            }
        }
    }

    public static void detectAndRemoveLoop(Node node) {
        if (node == null || node.getNext() == null)
            return;
        Node slow = node, fast = node;
        slow = slow.getNext();
        fast = fast.getNext().getNext();
        while (fast != null && fast.getNext() != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        // If loop exists
        if (slow == fast) {
            slow = node;
            if (slow != fast) {
                while (slow.getNext() != fast.getNext()) {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                // since fast->next is the looping point remove loop
                fast.setNext(null);
            }
            // This case is added if fast and slow pointer meet at first position.
            else {
                while(fast.getNext() != slow) {
                    fast = fast.getNext();
                }
                fast.setNext(null);
            }
        }
    }

    public static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
    }

    public static Node reverseList(Node head) {
        Stack<Node> nodes = new Stack<>();
        Node temp = head;
        while (temp != null) {
            nodes.push(temp);
            temp = temp.getNext();
        }
        if (!nodes.isEmpty()) {
            head = nodes.pop();
            temp = head;
            while (!nodes.isEmpty()) {
                temp.setNext(nodes.pop());
                temp = temp.getNext();
            }
            temp.setNext(null);
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(50);
        head.setNext(new Node(20));
        head.getNext().setNext(new Node(15));
        head.getNext().getNext().setNext(new Node(4));
        head.getNext().getNext().getNext().setNext(new Node(10));
        head.getNext().getNext().getNext().getNext().setNext(head.getNext().getNext());
        //removeLoop(head);
        detectAndRemoveLoop(head);
        printList(head);

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head1 = new Node(1);
        head1.setNext(new Node(2));
        head1.getNext().setNext(new Node(3));
        head1.getNext().getNext().setNext(new Node(4));
        head1.getNext().getNext().getNext().setNext(new Node(5));
        System.out.println("\nGiven Linked List:");
        printList(head1);
        head = reverseList(head1);
        System.out.println("\nReversed Linked List:");
        printList(head);
    }
}
