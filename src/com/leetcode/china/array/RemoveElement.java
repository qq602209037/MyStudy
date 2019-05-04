package com.leetcode.china.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2};
        System.out.println(new RemoveElement().removeElement(nums,2));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 类似,先把所有元素摆到前面,在统计
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int [] nums,int val){
        int k = 0;
        int count = 0;

        for(int i =0;i<nums.length;++i){
            //判断是否需要删除的值,不是则直接移到钱吗
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
            //是则记录一下
            else{
                count++;
            }
        }

        return nums.length-count;
    }
}
