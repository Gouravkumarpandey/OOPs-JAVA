package dsa.problems.easy;

/**
 * Problem: Two Sum
 * Difficulty: Easy
 * 
 * Given an array of integers nums and an integer target, return indices of the 
 * two numbers such that they add up to target.
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

import java.util.*;

public class TwoSum {
    
    /**
     * Brute Force Approach
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // No solution found
    }
    
    /**
     * Hash Map Approach (Optimized)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1}; // No solution found
    }
    
    /**
     * Test the solutions
     */
    public static void main(String[] args) {
        System.out.println("=== Two Sum Problem ===\n");
        
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        
        // Test brute force
        int[] result1 = twoSumBruteForce(nums, target);
        System.out.println("Brute Force Result: " + Arrays.toString(result1));
        
        // Test optimized
        int[] result2 = twoSumOptimized(nums, target);
        System.out.println("Optimized Result: " + Arrays.toString(result2));
        
        // Verify results
        if (result1[0] != -1) {
            System.out.println("Verification: " + nums[result1[0]] + " + " + nums[result1[1]] + " = " + (nums[result1[0]] + nums[result1[1]]));
        }
    }
}