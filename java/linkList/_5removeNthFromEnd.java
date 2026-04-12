package linkList;

import java.util.Scanner;
public class _5removeNthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // 创建链表
        ListNode head = ListUtils.createListNode(arr);
        int n = sc.nextInt();
        // 打印链表
        System.out.print("Head: ");
        ListUtils.printListNode(head);
        //删除倒数节点
        removeNthFromEndSolution linkedList = new removeNthFromEndSolution();
        ListNode newHead = linkedList.removeNthFromEnd(head, n);    
        // 打印新链表
        System.out.print("newHead: ");
        ListUtils.printListNode(newHead);

        sc.close();
    }
}
class removeNthFromEndSolution {
    // public int size = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //需要知道链表的长度，才能确定要删除的节点的前一个节点
        //使用虚拟头节点，避免特殊处理头节点的情况
        ListNode dummyListNode = new ListNode(-1, head);
        //遍历链表，统计链表的长度
        ListNode cur = dummyListNode;
        int size = 0; 
        while(cur.next != null){
            size++;
            cur = cur.next;
        }
        //删除节点--size<n时，不删除，需要单独删除
        cur = dummyListNode; //将cur指向虚拟头节点，方便删除头节点
        if(size < n){
            //不删除，直接返回头节点
            return dummyListNode.next;
        }
        //size>=0
        for(int i=0;i<size-n;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyListNode.next;
    }
}