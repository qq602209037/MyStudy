package com.leetcode.china.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZero {

    public static void main(String[] args) {
        int [] array = {1,0,1};

        new MoveZero().moveZeroes2(array);

        for(int i = 0;i<array.length;++i){
            System.out.println(array[i]);
        }
    }

    /**
     * 用一次循环把所有的非0全部移到前面,然后把后面的多余的全部清0
     * 时间复杂度为O(n) ,空间复杂度为O(1)
     * @param nums
     */

    public void moveZeroes2(int [] nums){
        int left = 0;

        int j = 0;
        //循环查找非0数值移动到最前面
        for(int i =0;i<nums.length;++i){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        //把移动后多余的位全部重置为0
        for(int i = j;i<nums.length;++i){
            nums[i] = 0;
        }
    }
    /**
     * 双重循环,第一重循环从后往前找到0的位置
     * 第二重循环把找到的0放到最后面
     * 所以时间复杂度O(n*n),空间复杂度为O(1)
     * @param nums
     */
    public void moveZeroes(int [] nums){
        int right = nums.length-1;

        int currentIndex = right;

        while(currentIndex-- >0){
            if(nums[currentIndex] == 0){
                for(int k = currentIndex+1;k<=right;++k){
                    int temp = nums[k];
                    nums[k] = nums[k-1];
                    nums[k-1] = temp;
                }
            }
        }
    }
}
