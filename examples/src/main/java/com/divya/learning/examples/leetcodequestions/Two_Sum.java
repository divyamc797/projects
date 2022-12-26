package com.divya.learning.examples.leetcodequestions;

//Given an array of integers nums and an integer target,
// return indices of the two numbers such that they add up to target.

//Example 1:
//
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//Example 2:
//
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//
//Example 3:
//
//        Input: nums = [3,3], target = 6
//        Output: [0,1]

import java.util.*;

public class Two_Sum {

    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    System.out.println(Arrays.toString(new int[]{i, j}));
//                    return new int[]{i, j};
//                }
//            }
//        }

        Map<Integer, Integer> visited = new HashMap<>();//{2, 0} {3, 1} {4, 2}
        for (int i = 0; i < nums.length; i++) {
            if (visited.containsKey(target - nums[i])) {
                return new int[]{i, visited.get(target - nums[i])};
            }
            visited.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4};
        int tar = 6;
        System.out.println(Arrays.toString(twoSum(numbers, tar)));
    }
}
