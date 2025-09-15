package dsa.algorithms.sorting;

import dsa.utils.DSAUtils;

/**
 * Collection of fundamental sorting algorithms
 * Essential for DSA preparation
 */
public class SortingAlgorithms {
    
    /**
     * Bubble Sort
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * Stable: Yes
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    DSAUtils.swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            // If no swapping occurred, array is sorted
            if (!swapped) break;
        }
    }
    
    /**
     * Selection Sort
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * Stable: No
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            DSAUtils.swap(arr, i, minIdx);
        }
    }
    
    /**
     * Insertion Sort
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * Stable: Yes
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Merge Sort
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * Stable: Yes
     */
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }
    
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    /**
     * Quick Sort
     * Time Complexity: O(n log n) average, O(n²) worst
     * Space Complexity: O(log n)
     * Stable: No
     */
    public static void quickSort(int[] arr) {
        if (arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                DSAUtils.swap(arr, i, j);
            }
        }
        
        DSAUtils.swap(arr, i + 1, high);
        return i + 1;
    }
    
    /**
     * Demo method to test all sorting algorithms
     */
    public static void demonstrateSorting() {
        System.out.println("=== Sorting Algorithms Demo ===\n");
        
        int[] original = DSAUtils.generateRandomArray(10, 1, 100);
        System.out.print("Original array: ");
        DSAUtils.printArray(original);
        System.out.println();
        
        // Test each sorting algorithm
        testSortingAlgorithm("Bubble Sort", original, SortingAlgorithms::bubbleSort);
        testSortingAlgorithm("Selection Sort", original, SortingAlgorithms::selectionSort);
        testSortingAlgorithm("Insertion Sort", original, SortingAlgorithms::insertionSort);
        testSortingAlgorithm("Merge Sort", original, SortingAlgorithms::mergeSort);
        testSortingAlgorithm("Quick Sort", original, SortingAlgorithms::quickSort);
    }
    
    private static void testSortingAlgorithm(String name, int[] original, SortingMethod method) {
        int[] arr = DSAUtils.copyArray(original);
        long startTime = System.nanoTime();
        method.sort(arr);
        long endTime = System.nanoTime();
        
        System.out.printf("%-15s: ", name);
        DSAUtils.printArray(arr);
        System.out.printf("Time: %.2f μs, Sorted: %s\n\n", 
                         (endTime - startTime) / 1000.0, DSAUtils.isSorted(arr));
    }
    
    @FunctionalInterface
    private interface SortingMethod {
        void sort(int[] arr);
    }
}