package com.leetcode.china.array;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 两个数组之间的间距作为长度,两个数组之间的value较小的作为高，计算最大面积
 */

public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7,6,9};
        System.out.println(new MaxArea().maxArea(height));
    }

    /**
     * 使用指针碰撞,左右开工,每次把较小的移动一下
     * @param height
     * @return
     */
    public int maxArea(int [] height){
        int maxErea = 0;
        int left= 0;
        int right = height.length-1;
        while(left<right){
            maxErea = Math.max(maxErea,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }

        return maxErea;
    }
}
