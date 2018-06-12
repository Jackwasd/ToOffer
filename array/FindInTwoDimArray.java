package com;

/**
 * 问题描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * 解题思路：选择右上角的一个数进行对比，如果小于目标值的话，直接行数减一
 * 如果大于目标值的话，列数减一之后再对新的右上角的数进行比较
 */
public class Solution {
    public boolean Find(int target, int[][] array){
        if(array.length == 0){
            return false;
        }
        int row = array.length;
        int column = array[0].length;
        int temp = 0;

        while(temp < row && column > 0){
            if(target == array[temp][column-1]){
                return true;
            }else if(target < array[temp][column-1]){
                column--;
            }else {
                temp++;
            }
        }
        return false;
    }
}
