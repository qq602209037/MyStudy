package com.leetcode.china.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection {
    public static void main(String[] args) {
        int [] nums1 = {4,9,5};
        int [] nums2 = {9,4,9,8,4};

        int [] rs = new Intersection().intersection2(nums1,nums2);

        for (int r : rs) {
            System.out.println(r);
        }
    }
    /**
     * 使用set集合，先把第一个数组存入，然后存入第二个数组，存入失败的则是重复的元素，因为set集合不允许有重复元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1,int[]nums2){
        List list = new ArrayList();
        Set set = new HashSet(nums1.length+nums2.length);
        Set set1 = new HashSet(nums1.length);
        Set set2 = new HashSet(nums2.length);


        if(nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        for(int i = 0;i<nums1.length;++i){
            set1.add(nums1[i]);
        }
        for(int j = 0;j<nums2.length;++j){
            set2.add(nums2[j]);
        }

        for (Object o : set1) {
            set.add(o);
        }

        for (Object o : set2) {
            if(!set.add(o)){
                list.add(o);
            }
        }

        int rs[] = new int[list.size()];
        for(int i = 0;i<rs.length;++i){
            rs[i] = (int) list.get(i);
        }
        return rs;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        // 确定数组 nums1 的取值范围
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        boolean[] arr = new boolean[max - min + 1];
        for (int num : nums1) {
            arr[num - min] = true;
        }

        // 判断数组 nums2 中的数是否在数组 nums1 中存在，
        // 如果存在保存在数组 tmp 中
        int[] tmp = new int[max - min + 1];
        int idx = 0;
        for (int num : nums2) {
            if (num >= min && num <= max && arr[num - min]) {
                tmp[idx++] = num;
                arr[num- min] = false;
            }
        }

        // 返回结果
        int[] ret = new int[idx];
        for (int i = 0; i < idx; i++) {
            ret[i] = tmp[i];
        }
        return ret;
    }
}
