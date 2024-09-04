/*
https://leetcode.com/problems/linked-list-cycle/
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
 */

public class findCycle {

    public static void main(String[] args) {

        ListNode h1 = new ListNode(3);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(0);
        ListNode h4 = new ListNode(-4);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        //h4.next = h2; // cycle

        System.out.println(hasCycle(h1));
    }

    public static boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            if (fast == slow) {
                //System.out.println("Cycle found at node " + fast.val);
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
}
