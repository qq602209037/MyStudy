package com.leetcode.china.array;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class SortColors {

    public static void main(String[] args) {
        int[] t = {2,0,1};
        new SortColors().sortColors2(t);
        System.out.println(Arrays.toString(t));
    }

    public void sortColors(int []nums){
        int[] temp = new int[3];

        for(int i = 0;i<nums.length;++i){
            temp[nums[i]]++;
        }
        int index = 0;
        for(int i=0;i<temp.length;++i){
            while(temp[i]-->0){
                nums[index++] = i;
            }
        }
    }

    /**
     * 采用分段,先把为2的移到最后面,那么前面就只剩下0，1，然后碰到0就把它和最左边的交换位置,由于前面只剩下0和1
     * 所以交换位置以后0处于最前面，而又把2放到了最后面，自然中间的就是为1的了
     *
     * 空间为O(1),时间为O(n)
     * @param nums
     */
    public void sortColors2(int []nums){
        int right = nums.length-1;
        int left = 0;
        int i = 0;

        while(i<=right){
            int temp = 0;
            //如果为0,则把它和最左边的交换位置,同时遍历的下标+1,因为数值为2的已经被移到最右边
            if(nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[left];
                nums[left++] = temp;
                ++i;
            }
            //如果为2则移到最右边,但是遍历的下标不能加,因为换过来的可能是0
            else if (nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[right];
                nums[right--] = temp;
            }else{
                ++i;
            }
        }
    }
}
