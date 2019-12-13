package com.jailmango.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum - leetcode #1
 *
 * @author he.gang33
 * @CreateDate 2019-03-25
 * @see com.jailmango.algorithm.leetcode.easy
 * @since R9.0
 */
public class TwoSum {

    /**
     * 暴力搜索法，两次遍历数组
     * 
     * @param nums int[]
     * @param target int
     * @return int[]
     */
    public int[] twoSum1(int[] nums, int target) {
        boolean isGetResult = false;
        int outer = 0;
        int inner = 0;

        for (; outer < nums.length - 1 && !isGetResult;) {
            for (inner = outer + 1; inner < nums.length; inner++) {
                if (nums[inner] + nums[outer] == target) {
                    isGetResult = true;
                    break;
                }
            }

            if (isGetResult) {
                break;
            }

            outer++;
        }

        return new int[] {
            outer, inner
        };
    }

    /**
     * 使用Map
     * 
     * @param nums int[]
     * @param target int
     * @return int[]
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int anotherIndex = 0;

        for (; index < nums.length; index++) {
            int completement = target - nums[index];

            if (map.containsKey(completement)) {
                anotherIndex = map.get(completement);
                break;
            }

            map.put(nums[index], index);
        }

        return new int[] {
            index, anotherIndex
        };
    }
}
