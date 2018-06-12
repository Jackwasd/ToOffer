package com;

import java.util.ArrayList;

/**
 * 问题描述：输入一个链表，从尾到头打印链表每个节点的值。
 *
 * 解题思路：递归的方式本身也是一种栈的方式,但是当链表很长的时候，调用的层级深，容易导致溢出。
 */
public class Solution {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return arrayList;
        }
        printListFromTailToHead(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;
    }
}



class ListNode{
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}