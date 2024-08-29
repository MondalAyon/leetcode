/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/ 
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Input: head = [1,1,2]
Output: [1,2]
 */

public class deleteDuplicateNodes {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        //ListNode l4 = new ListNode(0);
        //ListNode l5 = new ListNode(2);

        list = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        //l4.next = l5;
        //l5.next = null;

        printList(list);


        printList(deleteDuplicates(null));
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode list = head;
        ListNode curr = list;

        if (head == null) return head;

        while (list.next != null) {

            while (curr.val == curr.next.val) {
                if (curr.next.next == null) {
                    curr.next = null;
                    return head;
                }
                else curr.next = curr.next.next;
            }
            curr = curr.next;
            list = curr;

        }
        return head;
    }

    private static void printList(ListNode root) {
        System.out.println();
        while (root != null) {
            if (root.next != null)
                System.out.print(root.val + " -> ");
            else System.out.print(root.val);
            root = root.next;
        }
    }
}
