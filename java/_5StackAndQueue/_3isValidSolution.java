package _5StackAndQueue;

import java.util.*;
public class _3isValidSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        isValidSolution1 isValidSolution = new isValidSolution1();
        System.out.println(isValidSolution.isValid(s));
        sc.close();
    }
}
//先进后出-----栈
class isValidSolution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Deque<Character> instack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c=='{' || c=='['){
                instack.push(c);
            }else{
                if(instack.isEmpty()){
                    return false;
                }
                char top = instack.peek();
                if(top=='(' && c==')'){
                    instack.pop();
                }else if(top=='{' && c=='}'){
                    instack.pop();
                }else if(top=='[' && c==']'){
                    instack.pop();
                }else{
                    return false;
                }
            }
        }
        if(instack.isEmpty()){
            return true;
        }
        return false;
    }
}
//执行时间1ms
class isValidSolution1 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        char[] stack = s.toCharArray();
        int top = -1;// 这是一个指针，指向栈顶元素的位置
        for(char c : stack){
            if(c == '('){
                stack[++top] = ')';
            }else if(c=='{'){
                stack[++top] ='}';
            }else if(c=='['){
                stack[++top] = ']';
            }else{
                // 遇到右括号：如果栈为空(top == -1) 或 弹出的字符不匹配
                if(top == -1 || stack[top--] != c){
                    return false;
                }
            }
        }
        // 最后检查栈是否为空（指针是否回到了初始位置）
        return top == -1;
    }
}
//执行时间0ms
class isValidSolution2 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        char[] stack = s.toCharArray();
        int pointer = 0;
        for (char ch : stack) {
            switch (ch) {
                case '(' -> stack[pointer ++] = ')';
                case '[' -> stack[pointer ++] = ']';
                case '{' -> stack[pointer ++] = '}';
                default -> {
                    if (pointer == 0 || stack[--pointer] != ch) {
                        return false;
                    }
                }
            }
        }
        return pointer == 0;
    }
}
