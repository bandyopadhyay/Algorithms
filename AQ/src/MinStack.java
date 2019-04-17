import java.util.ArrayList;
import java.util.List;

/**
 * 155. Min Stack
 * Easy
 *
 * 1647
 *
 * 172
 *
 * Favorite
 *
 * Share
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    int  min = Integer.MAX_VALUE;
    List<Integer> stack = new ArrayList<>();


    public MinStack() {


    }

    public void push(int x) {
        min = Math.min(x,min);
        stack.add(x);
    }

    public void pop() {

        stack.remove(stack.size()-1);
        min = Integer.MAX_VALUE;
        for(Integer s : stack){
            min = Math.min(s,min);
        }
    }



    public int top() {
       return stack.get(stack.size()-1);
    }

    public int getMin() {
         return min;
    }
}
