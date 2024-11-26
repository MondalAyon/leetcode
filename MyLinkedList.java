/*
https://leetcode.com/problems/design-linked-list/submissions/1463097712/
https://leetcode.com/problems/design-linked-list/description/
https://leetcode.com/problems/design-linked-list/solutions/6084405/simple-solution-using-listnode/
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.


Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3


Constraints:

0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 */

public class MyLinkedList {

    ListNode head;
    int listLen;

    public MyLinkedList() {

        this.listLen = 0;

    }

    public void addAtIndex(int index, int val) {

        if (index < 0 || index > this.listLen) return;

        ListNode newNode = new ListNode();
        newNode.val = val;

        if (index == 0) { // add at the Head
            newNode.next = head;
            head = newNode;
            this.listLen++;
        }

        else {

            ListNode node = this.head;

            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }

            ListNode temp = node.next;
            node.next = newNode;
            newNode.next = temp;
            this.listLen++;
        }
    }


    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(this.listLen, val);
    }

    public void deleteAtIndex(int index) {

        if (index > this.listLen - 1)

        if (index == 0 && this.listLen > 0) {
            head = head.next;
            this.listLen--;
        }

        else if (index > 0 && index < this.listLen) {

            ListNode node = this.head;

            for (int i = 1; i <= index - 1; i++) {
                node = node.next;
            }

            if (index == this.listLen) {
                node.next = null;
                this.listLen--;
            }
            else {
                node.next = node.next.next;
                this.listLen--;
            }
        }

    }

    public int get(int index) {

        if (index >= 0 && index < this.listLen) {

            ListNode node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.val;
        }
        else
            return -1;
    }


    public void printList(ListNode node) {
        while (node != null) {
            if (node.next == null)
                System.out.print(node.val + "  ListLen: " + this.listLen);
            else
                System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /*MyLinkedList obj = new MyLinkedList();

        obj.printList(obj.head);

        obj.addAtHead(3);
        obj.printList(obj.head);

        obj.addAtHead(2);
        obj.printList(obj.head);

        obj.addAtHead(1);
        obj.printList(obj.head);

        obj.addAtIndex(1, 10);
        obj.printList(obj.head);

        obj.addAtTail(99);
        obj.printList(obj.head);

        obj.addAtIndex(2, -5);
        obj.printList(obj.head);

        obj.deleteAtIndex(5);
        obj.printList(obj.head);

        obj.deleteAtIndex(4);
        obj.printList(obj.head);

        System.out.println(obj.get(4));
         */

        /*
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.printList(myLinkedList.head);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.printList(myLinkedList.head);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        myLinkedList.printList(myLinkedList.head);
        System.out.println(myLinkedList.get(1));
        */

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(2);
        myLinkedList.printList(myLinkedList.head);

        myLinkedList.deleteAtIndex(1);
        myLinkedList.printList(myLinkedList.head);

        myLinkedList.addAtHead(2);
        myLinkedList.printList(myLinkedList.head);

        myLinkedList.addAtHead(7);
        myLinkedList.printList(myLinkedList.head);

        myLinkedList.addAtHead(3);
        myLinkedList.printList(myLinkedList.head);

        myLinkedList.addAtHead(2);
        myLinkedList.printList(myLinkedList.head);

        myLinkedList.addAtHead(5);
        myLinkedList.printList(myLinkedList.head);

        myLinkedList.addAtHead(5);
        myLinkedList.printList(myLinkedList.head);

        myLinkedList.addAtTail(5);
        myLinkedList.printList(myLinkedList.head);

        System.out.println(myLinkedList.get(6));

        myLinkedList.deleteAtIndex(6);
        myLinkedList.printList(myLinkedList.head);

        myLinkedList.deleteAtIndex(4);
        myLinkedList.printList(myLinkedList.head);
    }
}
