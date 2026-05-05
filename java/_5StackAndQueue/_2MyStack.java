package _5StackAndQueue;

import java.util.*;
public class _2MyStack {
    public static void main(String[] args) {
        MyStack myStack  = new MyStack();
        myStack.push(1); // queue is: [1]
        System.out.println(myStack);
        myStack.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myStack);
        System.out.println(myStack+ " " + myStack.top());// return 1
        System.out.println(myStack+ " " + myStack.pop());// return 1, queue is [2]
        System.out.println(myStack + " " + myStack.empty());// return false
    }
}
//
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        //除最后一个元素，都导到queue2中
        while(queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        int result = queue1.poll();
        while(!queue2.isEmpty()){ //将queue2中的元素导入到queue1中,便于后续操作操作
            queue1.offer(queue2.poll());
        }
        return result;
    }
    
    public int top() {
        //除最后一个元素，都导到queue2中
        while(queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        int result = queue1.peek();
        queue2.offer(queue1.poll()); //将最后一个元素导入到queue2中
        while(!queue2.isEmpty()){ //将queue2中的元素导入到queue1中,便于后续操作操作
            queue1.offer(queue2.poll());
        }
        return result;
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
    @Override
    public String toString() {
        return "MyStack{" +
                "queue1=" + queue1 +
                ", queue2=" + queue2 +
                '}';
    }
}
//官方题解---两个队列或一个队列
class MyStack1 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack1() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    //两个队列
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        //原来可以使用这个temp，还以为只能定义两个队列
        //并没有创建新队列new LinkedList<Integer>();，只是指向指向队列对象的"指针"（queue1, queue2, temp）
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    //一个队列
    // public void push1(int x){
    //     int n = queue.size();
    //     queue.offer(x);
    //     for(int i = 0; i < n; i++){
    //         queue.offer(queue.poll());
    //     }  
    // }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

