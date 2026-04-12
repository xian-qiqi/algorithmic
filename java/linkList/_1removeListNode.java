package linkList;

import java.util.Scanner;

public class _1removeListNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int val = sc.nextInt();
        // 创建链表
        ListNode head = ListUtils.createListNode(arr);
        // 移除元素
        ListNodeRemoveSolution solution = new ListNodeRemoveSolution();
        ListNode newHead = solution.removeElements(head, val);
        // 打印新链表
        ListUtils.printListNode(newHead);
        sc.close();
    }

}

//递归
class ListNodeRemoveSolution {
    public ListNode removeElements(ListNode head, int val) {
        // if (head == null) {
        //     return null;
        // }
        // // 当最后一个节点值为val时，需要删除最后一个节点，所以需要判断head.next是否为null
        // // 此时head.next = removeElements(head.next, val);会报空指针错误
        // // 此时要删除最后一个节点，又要不报错，所以需要判断head.next是否为null，结束递归
        // if (head.next == null) {
        //     return null;
        // }
        // //当有连续的val需要删除了，会导致错误❌
        // if (head.val == val) {
        //     head = head.next;
        // }
        // head.next = removeElements(head.next, val);
        // return head;
        if (head == null) {
            return null;
        }
        // 先处理后面的节点
        head.next = removeElements(head.next, val);
        // 再处理当前节点
        if (head.val == val) {
            return head.next; // 跳过当前节点
        } else {
            return head; // 保留当前节点
        }
    }
}
//单独处理头节点值为val的情况
class ListNodeRemoveSolution1 {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        //上面的代码排除了当前值等于val的情况
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
//设置虚拟头节点，避免单独处理头节点值为val的情况
class ListNodeRemoveSolution2 {
    public ListNode removeElements(ListNode head, int val) {
        // 设置一个虚拟的头结点
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;        
            }
        }
        return dummy.next;
    }
}




