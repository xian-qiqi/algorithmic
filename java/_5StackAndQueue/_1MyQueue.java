package _5StackAndQueue;

import java.util.*;
public class _1MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        System.out.println(myQueue);
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue);
        System.out.println(myQueue+ " " + myQueue.peek());// return 1
        System.out.println(myQueue+ " " + myQueue.pop());// return 1, queue is [2]
        System.out.println(myQueue + " " + myQueue.empty());// return false
    }
}
//使用stack实现队列
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        //为什么是这样？？不应该使用this吗？
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        //只在 stack2 为空时才倒腾，不为空先放在stack1中
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }    
        if(stack2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }
    
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        // ✅ 直接判断两个栈是否都为空--注意是两个栈都为空时，队列才为空
        //因为有可能没有pop操作，所以stack2为空，只判断stack2为空会错
        return stack1.isEmpty() && stack2.isEmpty();
    }
    @Override
    public String toString() {
        return "MyQueue{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }
}
//官方解法---使用Deque
class MyQueue1 {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue1() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
