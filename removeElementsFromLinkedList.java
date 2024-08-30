/*
https://leetcode.com/problems/remove-linked-list-elements/description/
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 */

public class removeElementsFromLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(6);

        ListNode head = l1;
        l1.next = null;
        //l2.next = l3;
        //l3.next = l4;
        //l4.next = l5;
        //l5.next = l6;
        //l6.next = null;

        //head.next = null;

        printList(head);
        printList(removeElementsV2(head, 6));

    }

    public static ListNode removeElementsV2(ListNode head, int val) {

        ListNode prev = head;
        ListNode curr = head;

        if (head == null) return null;
        if (head.next != null) {
            curr = head.next;
        }
        else if (head.val == val) {
            return null;
        }
        else return head;

        while (curr != null) {

            if (head.val == val) {
                head = head.next;
                curr = curr.next;
                prev = prev.next;

            } else if (curr.val == val) {
                curr = curr.next;
                prev.next = curr;
            }

            else {
                curr = curr.next;
                prev = prev.next;
            }
        }

        if (head.val == val) return null;

        return head;
    }

    private static void printList(ListNode root) {
        System.out.println();
        while (root != null) {
            if (root.next == null)
                System.out.print(root.val);
            else System.out.print(root.val + " -> ");
            root = root.next;
        }
    }


}
