package com;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 问题描述：输入一个链表，从尾到头打印链表每个节点的值。
 *
 * 解题思路：从尾到头打印的话肯定是后进先出的方式
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return null;
        }
        ArrayList<Integer> lists = new ArrayList<>();
        Stack<Integer> stack = new Stack();
        ListNode list = new ListNode(0);
        while(list.next != null){
            stack.add(list.next.val);
            list = list.next;
        }
        while(!stack.isEmpty()){
            lists.add(stack.pop());
        }
        return lists;
    }
}



class ListNode{
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}