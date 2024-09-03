/* https://leetcode.com/problems/reverse-linked-list/submissions/1378223179/
Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class reverseList {
    public static void main(String[] args) {

        ListNode h = new ListNode();
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h = h1;

        printList(h);
        int l = lengthOfList(h);
        System.out.println("L=" + l);

        printList(reverseList(h));


    }

    public static ListNode reverseList(ListNode n) {
        ListNode curr = n;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(ListNode n) {
        while (n != null) {
            if (n.next != null) System.out.print(n.val + " -> ");
            else System.out.print(n.val);
            n = n.next;
        }
        System.out.println();
    }

    private static int lengthOfList(ListNode n) {
        int l = 0;
        while (n.next != null) {
            l++;
            n = n.next;
        }
        l++;
        return l;
    }

}
