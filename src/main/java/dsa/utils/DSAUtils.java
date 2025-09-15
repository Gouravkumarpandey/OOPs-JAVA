package dsa.utils;

import java.util.*;

/**
 * Utility class containing common helper methods for DSA implementations
 * Author: DSA Preparation
 */
public class DSAUtils {
    
    /**
     * Print an array with formatting
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    /**
     * Print a 2D array with formatting
     */
    public static void print2DArray(int[][] arr) {
        for (int[] row : arr) {
            printArray(row);
        }
    }
    
    /**
     * Swap two elements in an array
     */
    public static void swap(int[] arr, int i, int j) {
        if (i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    /**
     * Generate a random array of given size with values between min and max
     */
    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max - min + 1) + min;
        }
        return arr;
    }
    
    /**
     * Check if array is sorted in ascending order
     */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Copy array
     */
    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }
}