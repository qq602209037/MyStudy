package com.leetcode.china.array;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,2,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDulicates {

    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3,3,4,7,8,9,9,9};
        System.out.println(new RemoveDulicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 先指定一个指针,用来保存不重复的数字,
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){
        int left = 0;

        for(int i = 0;i<nums.length;++i){
            //如果left下标的值小于i下标的值说明他们不是重复的值，则直接赋值到左边，否则i++
            if(nums[left]<nums[i]){
                nums[++left] = nums[i];
            }
        }
        return left+1;
    }
}
