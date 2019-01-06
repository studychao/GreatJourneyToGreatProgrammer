import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

///////////////////////
//LeetCode 225
///////////////////////
public class StackwzQueue {
    Queue<Integer> a = new LinkedList<>();
    Queue<Integer> b = new LinkedList<>();
    int top;
    /** Initialize your data structure here. */
    public StackwzQueue() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
     a.add(x);
     top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty())
            return 0;
        else {
            int size_a = a.size();
            int returnval;
            if (size_a >1) {


                while (b.size() < size_a - 2) {
                    b.add(a.remove());

                }
                top = a.remove();
                b.add(top);
                returnval = a.remove();
                a = b;
                return returnval;
            }
            else{
                top = a.remove();
                return top;
            }
        }
    }

    /** Get the top element. */
    public int top() {
        if (empty()) {
            return 0;
        }
        else {
            return top;
        }
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
    return a.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
