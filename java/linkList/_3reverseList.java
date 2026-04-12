package linkList;

import java.util.Scanner;
public class _3reverseList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // 创建链表
        ListNode head = ListUtils.createListNode(arr);
        // 反转链表
        reverseListSolution1 linkedList = new reverseListSolution1();
        ListNode newHead = linkedList.reverseList(head);    
        // 打印新链表
        ListUtils.printListNode(newHead);
        sc.close();
    }
}
class reverseListSolution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        // if(head == null){
        //     return head;
        // }不需要这个 
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

class reverseListSolution1 {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }
    private ListNode reverse(ListNode pre, ListNode cur){
        // 递归出口
        if(cur == null){
            return pre;
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
        //或者这个
        // pre = cur;
        // cur = temp;
        // return reverse(pre, cur);
    }
}




