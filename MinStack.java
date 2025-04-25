/* https://leetcode.com/problems/min-stack/description/
https://leetcode.com/problems/min-stack/submissions/1617178105/
https://leetcode.com/problems/min-stack/solutions/6685054/simple-solution-using-two-staks-by-ayonm-7hm4/

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;


    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        if (!minStack.empty()) {
            if (minStack.peek() >= val) {
                minStack.push(val);
            }
        }
        else minStack.push(val);

        mainStack.push(val);
    }

    public void pop() {

        if ((int)mainStack.peek() == (int)minStack.peek()) {
            minStack.pop();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();

        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);

        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());

    }
}
