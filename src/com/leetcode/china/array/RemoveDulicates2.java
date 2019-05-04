package com.leetcode.china.array;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDulicates2 {
    public static void main(String[] args) {
        int [] nums = {1,1,1,1,1,1,1,2,2,2,2,2,2,3,4,4,4,4,5,5,5,6,6,7};
        System.out.println(new RemoveDulicates2().removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 设置一个标志位,判断是否存储了两次,如果存储了两次则跳过，否则存进来,
     * 设置一个左边的下标,用于存储
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {



        int left = 0;
        int flag = 1;

        for(int i = 1;i<nums.length;++i){
            if(nums[left]<=nums[i]){
                if(nums[left] == nums[i]&&flag<2){
                    ++flag;
                    nums[++left] = nums[i];
                }
                else if(nums[left]<nums[i]){
                    flag = 1;
                    nums[++left] = nums[i];
                }
            }
        }
        return left+1;
    }

    /**
     * 因为他是顺序排列,如果有重复的必然在一起,所以直接每间隔两个判断一次,
     * 而第一次直接先存入两个
     * @param nums
     * @return
     */
    public int removeDuplicates2(int []nums){
        int flag = 0;

        if(nums == null ||nums.length<=0){
            return 0;
        }

        for(int i =0;i<nums.length;++i){
            //第一次先存入两个,第三个元素和第一个元素判断,当第三个元素比第一个元素大时,则可以确定第三个元素是不相等的,如果相等的则往后遍历
            if(flag<2 ||nums[i]>nums[flag-2]){
                nums[flag++] = nums[i];
            }
        }
        return flag;
    }
}
