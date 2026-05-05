package _5StackAndQueue;

import java.util.*;
public class _4removeDuplicatesSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        removeDuplicatesSolution1 solution = new removeDuplicatesSolution1();
        System.out.println(solution.removeDuplicates(s));
        sc.close();
    }
}
//时间复杂度O(n)
class removeDuplicatesSolution {
    public String removeDuplicates(String s) {
        if(s.length() <= 1){
            return s;
        }
        String res = "";
        Deque<Character> instack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(instack.isEmpty()){
                instack.push(c);
                continue;
            }else{
                if(instack.peek() == c){
                    instack.pop();
                    continue;
                }else{
                    instack.push(c);
                }
            }
        }
        while(!instack.isEmpty()){
            res += instack.pop();
        }
        String result = "";
        for(int i=res.length()-1; i>=0; i--){
            result += res.charAt(i);
        }
        return result;
    }
}
//shift，时间复杂度O(n²)---执行时间更高了
class removeDuplicatesSolution1 {
    public String removeDuplicates(String s) {
        if(s.length() <= 1){
            return s;
        }
        
        // for(int i=0; i<s.length()-1; ){
        //     char c = s.charAt(i);
        //     if(c != s.charAt(i+1)){
        //         i++;
        //     }else{
        //         s = s.substring(0,i) + s.substring(i+2,s.length());
        //         i = i-1;
        //         System.out.println(s);
        //     }
        // }

        //还得是ai
        for (int i = 0; i < s.length() - 1; ) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                s = s.substring(0, i) + s.substring(i + 2);
                if (i > 0) i--;
            } else {
                i++;
            }
        }

        return s;
    }
}

