package dsa.algorithms.searching;

/**
 * Collection of fundamental searching algorithms
 * Essential for DSA preparation
 */
public class SearchingAlgorithms {
    
    /**
     * Linear Search
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Works on: Sorted and unsorted arrays
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Element not found
    }
    
    /**
     * Binary Search (Iterative)
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * Prerequisite: Array must be sorted
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Element not found
    }
    
    /**
     * Binary Search (Recursive)
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to recursion stack
     * Prerequisite: Array must be sorted
     */
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }
    
    private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Element not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    /**
     * Find First Occurrence (using binary search)
     * Time Complexity: O(log n)
     * Useful when array has duplicates
     */
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching in left half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    /**
     * Find Last Occurrence (using binary search)
     * Time Complexity: O(log n)
     * Useful when array has duplicates
     */
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching in right half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    /**
     * Count Occurrences of an element
     * Time Complexity: O(log n)
     */
    public static int countOccurrences(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        if (first == -1) {
            return 0;
        }
        
        int last = findLastOccurrence(arr, target);
        return last - first + 1;
    }
    
    /**
     * Search in Rotated Sorted Array
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int searchInRotatedArray(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            // Check if left half is sorted
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    /**
     * Demo method to test all searching algorithms
     */
    public static void demonstrateSearching() {
        System.out.println("=== Searching Algorithms Demo ===\n");
        
        // Test array (sorted)
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 11;
        
        System.out.print("Sorted Array: ");
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
        System.out.println("\nTarget: " + target + "\n");
        
        // Linear Search
        int linearResult = linearSearch(sortedArr, target);
        System.out.println("Linear Search: Index " + linearResult);
        
        // Binary Search (Iterative)
        int binaryResult = binarySearch(sortedArr, target);
        System.out.println("Binary Search (Iterative): Index " + binaryResult);
        
        // Binary Search (Recursive)
        int binaryRecResult = binarySearchRecursive(sortedArr, target);
        System.out.println("Binary Search (Recursive): Index " + binaryRecResult);
        
        // Test with duplicates
        int[] arrWithDuplicates = {1, 2, 2, 2, 3, 4, 4, 5};
        int duplicateTarget = 2;
        
        System.out.println("\n--- Testing with duplicates ---");
        System.out.print("Array with duplicates: ");
        for (int num : arrWithDuplicates) {
            System.out.print(num + " ");
        }
        System.out.println("\nTarget: " + duplicateTarget);
        
        int first = findFirstOccurrence(arrWithDuplicates, duplicateTarget);
        int last = findLastOccurrence(arrWithDuplicates, duplicateTarget);
        int count = countOccurrences(arrWithDuplicates, duplicateTarget);
        
        System.out.println("First occurrence: Index " + first);
        System.out.println("Last occurrence: Index " + last);
        System.out.println("Total occurrences: " + count);
        
        // Test rotated array
        int[] rotatedArr = {4, 5, 6, 7, 0, 1, 2};
        int rotatedTarget = 0;
        
        System.out.println("\n--- Testing rotated sorted array ---");
        System.out.print("Rotated array: ");
        for (int num : rotatedArr) {
            System.out.print(num + " ");
        }
        System.out.println("\nTarget: " + rotatedTarget);
        
        int rotatedResult = searchInRotatedArray(rotatedArr, rotatedTarget);
        System.out.println("Search in rotated array: Index " + rotatedResult);
    }
}