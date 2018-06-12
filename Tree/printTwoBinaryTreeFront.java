package com;

import java.util.*;

/**
 * 二叉树的三种遍历方式：
 * 前序遍历：根左右
 * 中序遍历：左根右
 * 后序遍历：左右根
 */
public class Solution {
    public ArrayList<Integer> printTwoBinaryTreeFront(TreeNode root) {
        //首先是递归的解法,三种是通用的，就是换了个顺序
//        if(root != null){
//            arrayList.add(root.val);
//        }
//        if(root.left != null){
//            printTwoBinaryTreeFront(root.left);
//        }
//        if(root.right != null){
//            printTwoBinaryTreeFront(root.right);
//        }
//        return arrayList;
        //主要是非递归的解法
        ArrayList<Integer> arrayList = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return arrayList;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            arrayList.add(treeNode.val);
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
        return arrayList;
    }
    public ArrayList<Integer> printTwoBinaryTreeEnd(TreeNode root){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stackInteger = new Stack<>();
        if(root == null){
            return arrayList;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            stackInteger.add(treeNode.val);
            //先左序，再右序，因为先把左序压进栈底，先出右序，那么反转之后就可以了
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
        }
        while (!stackInteger.isEmpty()){
            arrayList.add(stackInteger.pop());
        }
        return arrayList;
    }

    public List<Integer> printTwoBinaryTreeMid(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node=stack.pop();
            result.add(node.val);
            root=node.right;
        }
        return result;
    }








    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        Solution solu = new Solution();
        //solu.printTwoBinaryTreeMid(t1);
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(1);
        arrayDeque.offer(2);
        arrayDeque.push(3);
        while(!arrayDeque.isEmpty()){
            System.out.println(arrayDeque.pop());
        }
    }
}



class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}