package com.jerry.study;


import java.util.Comparator;
import java.util.PriorityQueue;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode newNode = new ListNode(-1);
//        ListNode prev = newNode;
//        while (list1 != null && list2 != null){
//                if (list2.val <= list1.val){
//                    prev.next = list2;
//                    list2 = list2.next;
//                }else {
//                    prev.next = list1;
//                    list1 = list1.next;
//                }
//                prev = prev.next;
//        }
//
//        prev.next = list1 == null? list2: list1;
//        return newNode.next;
//    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(-1);
        ListNode prev = newNode;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                prev.next = p2;
                p2 = p2.next;
            } else {
                prev.next = p1;
                p1 = p1.next;
            }
            prev = prev.next;
        }
        if (p1 != null) {
            prev.next = p1;
        }
        if (p2 != null) {
            prev.next = p2;
        }
        return newNode.next;
    }
}

class Solution1 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newNode = head;
        while (newNode.next != null) {
            if (newNode.val == newNode.next.val) {
                newNode.next = newNode.next.next;
            } else {
                newNode = newNode.next;
            }

        }
        return head;
    }


}

class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode newNode = new ListNode(-1);
        ListNode prev = newNode;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            prev.next = poll;
            if (poll.next != null) {
                pq.add(poll.next);
            }
            prev = prev.next;
        }
        return newNode.next;
    }
}

class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        // 找到倒数第n+1个节点
        ListNode p2 = getListNode(newNode, n+1);
        p2.next = p2.next.next;
        return newNode.next;

    }

    private ListNode getListNode(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

class 链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
}

class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 =headA;
        ListNode p2 =headB;
        while (p1 != p2){
            if (p1 == null){
                p1 = headB;
            }else {
                p1 = p1.next;
            }

            if (p2 == null){
                p2 = headA;
            }else {
                p2 = p2.next;
            }
        }

        return p2;
    }
}

class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}



class 反转链表II {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        head.next = new ListNode(2, null);
        head.next.next = new ListNode(3, null);
        head.next.next.next = new ListNode(4, null);
        head.next.next.next.next = new ListNode(5, null);
        ListNode listNode = reverseBetween(head, 2, 4);
        System.out.println(listNode);
    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;

        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode noPreNode = pre.next;
        ListNode curr = rightNode.next;

        pre.next = null;
        rightNode.next = null;


        pre.next = reverseList(noPreNode);
        noPreNode.next = curr;


        return dummyNode.next;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

