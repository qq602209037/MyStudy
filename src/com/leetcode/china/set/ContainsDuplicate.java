package com.leetcode.china.set;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int []nums){
        Set set = new HashSet();
        for(int i = 0;i<nums.length;++i){
            return set.add(nums[i]);
        }

        return false;

    }
}
