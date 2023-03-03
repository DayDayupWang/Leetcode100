class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    // size存储链表元素的个数
    int size;
    // 虚拟头结点
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        // 如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        // 包含一个虚拟头节点，用于查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;

    }

    public void addAtHead(int val) {
        // 假如没有后缀就创建一个头节点
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        // 找到前驱
        ListNode pred = head;// head是为0的哨兵

        for (int i = 0; i < index; i++) {
            pred = pred.next;// 此时指到了索引处的前驱

        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;// 索引开始的元素定为所加元素的后继
        pred.next.prev = toAdd;// 把所加元素定为索引的前驱
        pred.next = toAdd;// 把所加元素定为索引前元素的后继
        toAdd.prev = pred;// 把索引前元素定为所加元素的前驱
    }

    public void deleteAtIndex(int index) {
        // 判断非法index
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        // 找到前驱
        ListNode pred = head;// head是为0的哨兵
        for (int i = 0; i < index; i++) {
            pred = pred.next;// 此时指到了索引处的前驱节点
        }
        pred.next = pred.next.next;
        pred.next.prev = pred;
    }
}