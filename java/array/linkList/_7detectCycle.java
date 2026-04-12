package linkList;

public class _7detectCycle {
    public static void main(String[] args) {
        // 创建所有节点
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node_4 = new ListNode(-4);
        
        // 链接节点：3 -> 2 -> 0 -> -4
        node3.next = node2;
        node2.next = node0;
        node0.next = node_4;
        node_4.next = node2;
        // head指向第一个节点
        ListNode head = node3;

        //寻找循环入口
        detectCycleSolution1 linkedList = new detectCycleSolution1();
        ListNode newHead = linkedList.detectCycle(head); 
        System.out.println(newHead.val);
    }
}

//陷入死循环
class detectCycleSolution {
    public ListNode detectCycle(ListNode head) {
        //先找到链表最后一个节点----因为是循环链表,无法得到最后一个节点,打印链表也没陷入死循环
        if(head == null || head.next == null){
            return null;
        } 
        ListNode lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        while(head != null){
            if(lastNode.next == head){
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
//双指针法----快慢指针，slow每次移动一步，fast每次移动两步，如果fast和slow相遇，说明有循环
class detectCycleSolution1 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){ 
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){ //有环，找到环入口
                //slow指向头节点，fast指向相遇节点，两节点每次移动一步，直到相遇，就是环入口
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                //相遇节点就是环入口
                return slow;
            }
        }
        return null;
    }
}
