/*

https://leetcode.com/problems/design-hashset/submissions/1446356225/
https://leetcode.com/problems/design-hashset/description/


Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)

 */
import java.util.LinkedList;

public class MyHashSet {

    private LinkedList<Integer> list = new LinkedList<>();

    public MyHashSet() {

    }

    public void add(int key) {

        if (!list.contains(key)) {
            list.add(key);
        }

    }

    public void remove(int key) {

        if (list.contains(key)) {
            list.remove((Object)key);
        }

    }

    public boolean contains(int key) {

        return list.contains(key);
    }


    public static void main(String[] args) {

        MyHashSet obj = new MyHashSet();

        obj.add(1);
        System.out.println(obj.list);

        obj.add(2);
        System.out.println(obj.list);

        System.out.println(obj.contains(1));

        System.out.println(obj.contains(3));

        obj.add(2);
        System.out.println(obj.list);

        System.out.println(obj.contains(2));

        obj.remove(2);
        System.out.println(obj.list);

        System.out.println(obj.contains(2));

    }

}