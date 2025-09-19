package dsa.problems.medium;

/**
 * Problem: Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

import java.util.*;

public class LongestSubstringWithoutRepeating {
    
    /**
     * Sliding Window Approach
     * Time Complexity: O(n)
     * Space Complexity: O(min(m,n)) where m is charset size
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // If character is already in the window, shrink from left
            while (seen.contains(rightChar)) {
                seen.remove(s.charAt(left));
                left++;
            }
            
            // Add current character to the window
            seen.add(rightChar);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
    
    /**
     * Optimized Sliding Window with HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(min(m,n))
     */
    public static int lengthOfLongestSubstringOptimized(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            
            // If character is seen and is within current window
            if (charIndexMap.containsKey(rightChar) && charIndexMap.get(rightChar) >= left) {
                left = charIndexMap.get(rightChar) + 1;
            }
            
            charIndexMap.put(rightChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Helper method to find the actual longest substring
     */
    public static String findLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;
        int bestLeft = 0, bestRight = 0;
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            while (seen.contains(rightChar)) {
                seen.remove(s.charAt(left));
                left++;
            }
            
            seen.add(rightChar);
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                bestLeft = left;
                bestRight = right;
            }
            right++;
        }
        
        return s.substring(bestLeft, bestRight + 1);
    }
    
    /**
     * Test the solutions
     */
    public static void main(String[] args) {
        System.out.println("=== Longest Substring Without Repeating Characters ===\n");
        
        String[] testCases = {
            "abcabcbb",
            "bbbbb",
            "pwwkew",
            "dvdf",
            "",
            "au"
        };
        
        for (String test : testCases) {
            System.out.println("Input: \"" + test + "\"");
            
            int length1 = lengthOfLongestSubstring(test);
            int length2 = lengthOfLongestSubstringOptimized(test);
            String substring = findLongestSubstring(test);
            
            System.out.println("Length (Method 1): " + length1);
            System.out.println("Length (Method 2): " + length2);
            System.out.println("Longest substring: \"" + substring + "\"");
            System.out.println();
        }
    }
}