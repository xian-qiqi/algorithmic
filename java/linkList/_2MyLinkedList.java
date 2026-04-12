package linkList;

public class _2MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList1 linkedList = new MyLinkedList1();
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 4);
        linkedList.get(1);
        linkedList.get(3);
        printListNode(linkedList.head.next);
        linkedList.deleteAtIndex(2);
        printListNode(linkedList.head.next);    
    }

    //打印链表
    // public static void printListNode(MyLinkedList.ListNode head) {
    //     if (head == null) {
    //         return;
    //     }
    //     MyLinkedList.ListNode current = head;
    //     while (current != null) {
    //         System.out.print(current.val);
    //         if (current.next != null) {
    //             System.out.print("->");
    //         }
    //         current = current.next;
    //     }
    //     System.out.println();
    // }

    public static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }

}
//报错！！！！因为之前函数已经定义了ListNode类，所以这里不能重新定义--可以直接使用之前定义的ListNode类，
// 或者使用内部定义
// class ListNode{
//     int val;
//     ListNode next;
//     //默认构造函数
//     ListNode(){}
//     //单参构造函数
//     ListNode(int val){
//         this.val = val;
//     }
//     //双参构造函数
//     ListNode(int val, ListNode next){
//         this.val = val;
//         this.next = next;
//     }
// }

//好难！！！！！！！！！！呜呜呜，写了半天还是错的
//改为内部类，之后都是用第一个包的公共类ListNode来写

class MyLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    //虚拟头节点
    public ListNode head;
    //链表的长度
    private int size;
    //MyLinkedList的构造函数,初始链表为空
    public MyLinkedList() {
        //链表的长度为0
        this.size = 0;
        //头节点,虚拟头节点,不存储任何数据,所以数值为0
        this.head = new ListNode(0);
        //为什么不是this.head = head
    }
    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是虚拟头结点
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        //第0个节点是虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        //为什么要是head = newNode？？？不应该有啊，将头节点指向新节点，新节点成为头节点
        head.next = newNode;
        size++;

        // 在链表最前面插入一个节点，等价于在第0个元素前添加
        // addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        //找到要插入节点的前驱
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        
        //因为有虚拟头节点，所以不用对index=0的情况进行特殊处理
        ListNode pre = head;
        for (int i = 0; i < index ; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }

}

class MyLinkedList1 {
    //虚拟头节点
    public ListNode head;
    //链表的长度
    private int size;
    public MyLinkedList1() {
        this.size = 0;
        this.head = new ListNode(0);
    }
    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是虚拟头结点
    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }
        ListNode cur = head;
        while(index-- >= 0){
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0||index>size){
            return ;
        }
        ListNode newNode = new ListNode(val);
        //找到要插入节点的前驱
        ListNode pre = head;
        while(index-- > 0){
            pre = pre.next;
        }
        newNode.next = pre.next;
        pre.next = newNode;
        size++;

    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size){
            return ;
        }
        ListNode pre = head;
        for(int i=0;i<index;i++){
            pre = pre.next;
        }
        // if(pre.next != null){
        //     pre.next = pre.next.next;
        //     size--;
        // }else{
        //     pre.next = null;
        //     size--;
        // }不需要判断是否为空，因为pre.next != null，pre是要删除的节点前驱节点
        pre.next = pre.next.next;
        size--;
    }

}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
