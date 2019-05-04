package com.leetcode.china.array;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int []nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(new FindKthLargest().findKthLargest(nums,4));
        System.out.println(Arrays.toString(nums));

    }
    public int findKthLargest(int[] nums,int k){
        quickSort(nums,0,nums.length-1);
        return nums[k-1];
    }

    public void quickSort(int[] nums,int left ,int right){
        int staticLeft = left;
        int staticRight = right;
       int key = nums[left];
       while(left<right){
           while(nums[right]<=key && left<right){
               right--;
           }
           nums[left] = nums[right];
           while(nums[left]>=key && left<right){
               left++;
           }
           nums[right] = nums[left];
       }
       nums[left] = key;

       if(staticLeft <left-1)
       quickSort(nums,staticLeft,left-1);
       if(right+1<staticRight)
       quickSort(nums,right+1,staticRight);
    }
}
