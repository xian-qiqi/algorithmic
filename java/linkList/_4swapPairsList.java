package linkList;

import java.util.Scanner;
public class _4swapPairsList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // 创建链表
        ListNode head = ListUtils.createListNode(arr);
        // 打印链表
        ListUtils.printListNode(head);
        //两两交换
        swapPairsSolution linkedList = new swapPairsSolution();
        ListNode newHead = linkedList.swapPairs(head);    
        // 打印新链表
        ListUtils.printListNode(newHead);
        sc.close();
    }
}
//不想了--还是错的！！！！！！！！头痛
class swapPairsSolution {
    public ListNode swapPairs(ListNode head) {
        //只有一个节点或者没有节点，直接返回头节点
        if(head == null || head.next == null){
            return head;
        }
        ListNode firstListNode;
        ListNode secondListNode;
        ListNode cur = head;  //用于进行下一轮转换
        ListNode newHead = head.next; //用于返回新的头节点（第一组的第二个节点）
        //当第二组进行交换时，第一组与第二组链接断开，需要重新连接--好麻烦，使用虚拟节点吧
        while(cur != null && cur.next != null){
            firstListNode = cur;
            secondListNode = cur.next;
            firstListNode.next = secondListNode.next;
            secondListNode.next = firstListNode;
            cur = firstListNode.next;     
        }  
        //交换完成后，将头节点指向第二个节点（必须是第一组交换的第二个节点）
        //不对--The local variable secondListNode may not have been initialized
        // head=secondListNode;只想最后一组交换的第二个节点，错的
        return newHead;
    }
}
//使用虚拟头节点
class swapPairsSolution1 {
    public ListNode swapPairs(ListNode head) {
        //虚拟头节点-------真难啊
        ListNode dumyhead = new ListNode(-1);
        dumyhead.next = head;
        ListNode cur = dumyhead;
        ListNode firstListNode; // 第一个节点
        ListNode secondListNode; // 第二个节点
        ListNode temp; // 临时节点，用于两个交换节点后面的节点
        while(cur.next!=null && cur.next.next!=null){
            temp = cur.next.next.next;
            firstListNode = cur.next;
            secondListNode = cur.next.next;
            cur.next = secondListNode;
            secondListNode.next = firstListNode;
            firstListNode.next = temp;
            cur = firstListNode;
        }
        return dumyhead.next;
    }
}
//使用递归
class swapPairsSolution2 {
    public ListNode swapPairs(ListNode head) {
        //递归出口
        if(head == null || head.next == null){
            return head;
        }
        //获取当前节点的下一个节点
        ListNode next = head.next;
        //进行递归
        ListNode newHead = swapPairs(next.next);
        //进行交换
        next.next = head;
        head.next = newHead;
        return next;
    } 
}







