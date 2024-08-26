/*
https://leetcode.com/problems/sort-list/description/ 
Given the head of a linked list, return the list after sorting it in ascending order.

Todo: Time limit needs to be improved.
Following algorithm is bubble sort. Need to implement better like merge sort or so. 
*/

public class sortList {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(-1);

        list = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;

        printList(list);

        ListNode resultNode = sortList(list);

        printList(resultNode);
    }

    public static ListNode sortList(ListNode head) {

        int n=countNode(head);

        for (int i=0; i<n; i++) {

            ListNode list = head;
            ListNode temp;
            ListNode prev = list;
            boolean first = true;

            //while (list.next != null) {
            for (int j=0; j<n-1-i; j++) {

                if (list.val > list.next.val) {

                    temp = list.next;
                    list.next = temp.next;
                    temp.next = list;

                    if (first) {
                        head = temp;
                        prev = temp;
                        first = false;
                    } else {
                        prev.next = temp;
                        prev = temp;
                    }
                } else {
                    prev = list;
                    list = list.next;
                    first = false;
                }
            }
        }
        return head;
    }

    private static void printList(ListNode root) {
        System.out.println();
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }

    private static int countNode(ListNode root) {
        int nodeCount = 0;
        while (root != null) {
            nodeCount++;
            root = root.next;
        }
        return nodeCount;
    }


}
