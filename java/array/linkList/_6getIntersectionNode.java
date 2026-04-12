package linkList;

public class _6getIntersectionNode {
    public static void main(String[] args) {
        // 创建相交的节点
    ListNode common1 = new ListNode(2);
    ListNode common2 = new ListNode(4);
    common1.next = common2;
    
    // 链表A: 0->9->1->2->4
    ListNode headA = new ListNode(0);
    headA.next = new ListNode(9);
    headA.next.next = new ListNode(1);
    headA.next.next.next = common1;  // 指向共同节点
    
    // 链表B: 3->2->4
    ListNode headB = new ListNode(3);
    headB.next = common1;  // 直接指向共同节点
    
    // 打印
    System.out.print("HeadA: ");
    ListUtils.printListNode(headA);
    System.out.print("HeadB: ");
    ListUtils.printListNode(headB);
    
    // 找相交点
    getIntersectionNodeSolution2 solution = new getIntersectionNodeSolution2();
    ListNode interNode = solution.getIntersectionNode(headA, headB);
    
    System.out.print("InterNode: ");
    ListUtils.printListNode(interNode);  // 应该输出 2->4
    }
}
//暴力解法
//时间复杂度O(n^2)，空间复杂度O(1)，也是双指针法
class getIntersectionNodeSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode curA = headA; //用于遍历链表A
        ListNode curB = headB; //用于遍历链表B
        while(curA != null){
            while(curB != null){ //遍历链表B，包含头节点headB
                if(curB == curA){
                    return curA;   //返回相交节点
                }
                curB = curB.next;
            }
            curB = headB; //重置curB，从头开始遍历链表B
            curA = curA.next;
        }
        return null;
    }
}
//时间复杂度O(n)，空间复杂度O(1)
class getIntersectionNodeSolution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针法
        ListNode curA = headA;
        ListNode curB = headB;
        // 求链表A和B的长度
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        //重置curA和curB
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐！！！！！）
        //时间复杂度确实比暴力解法低
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
//合并链表实现同步移动
//时间复杂度O(n+m)，空间复杂度O(1)
class getIntersectionNodeSolution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //P1和P2分别指向链表A和B的头节点
        ListNode P1 = headA , P2 = headB;
        while(P1 != P2){
            if(P1 == null){
                P1 = headB;
            }else{
                P1 = P1.next;
            }
            if(P2 == null){
                P2 = headA;
            }else{
                P2 = P2.next;
            }
        }
        //P1和P2指向相交节点
        return P1;
    } 
}
