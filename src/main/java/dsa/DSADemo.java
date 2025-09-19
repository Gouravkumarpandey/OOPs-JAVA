package dsa;

import dsa.datastructures.arrays.DynamicArray;
import dsa.datastructures.linkedlists.SinglyLinkedList;
import dsa.algorithms.sorting.SortingAlgorithms;
import dsa.algorithms.searching.SearchingAlgorithms;

/**
 * Main class to demonstrate DSA implementations
 * Run this class to see all data structures and algorithms in action
 */
public class DSADemo {
    
    public static void main(String[] args) {
        System.out.println("🚀 Welcome to DSA Preparation in Java! 🚀");
        System.out.println("==========================================\n");
        
        // Demo Data Structures
        demonstrateDataStructures();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demo Algorithms
        demonstrateAlgorithms();
        
        System.out.println("\n🎉 DSA Demo completed! Happy coding! 🎉");
    }
    
    private static void demonstrateDataStructures() {
        System.out.println("📚 DATA STRUCTURES DEMO 📚\n");
        
        // Dynamic Array Demo
        System.out.println("--- Dynamic Array ---");
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        
        // Add elements
        for (int i = 1; i <= 5; i++) {
            dynamicArray.add(i * 10);
        }
        System.out.println("After adding elements: " + dynamicArray);
        System.out.println("Size: " + dynamicArray.size());
        
        // Insert at specific index
        dynamicArray.add(2, 25);
        System.out.println("After inserting 25 at index 2: " + dynamicArray);
        
        // Remove element
        int removed = dynamicArray.remove(1);
        System.out.println("Removed element at index 1: " + removed);
        System.out.println("Array after removal: " + dynamicArray);
        
        System.out.println();
        
        // Linked List Demo
        System.out.println("--- Singly Linked List ---");
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        
        // Add elements
        linkedList.addLast("Apple");
        linkedList.addLast("Banana");
        linkedList.addLast("Cherry");
        linkedList.addFirst("Avocado");
        
        System.out.println("Linked List: " + linkedList);
        System.out.println("Size: " + linkedList.size());
        
        // Get element at index
        System.out.println("Element at index 2: " + linkedList.get(2));
        
        // Remove elements
        String removedFirst = linkedList.removeFirst();
        System.out.println("Removed first element: " + removedFirst);
        System.out.println("List after removal: " + linkedList);
        
        // Reverse the list
        linkedList.reverse();
        System.out.println("Reversed list: " + linkedList);
    }
    
    private static void demonstrateAlgorithms() {
        System.out.println("🧮 ALGORITHMS DEMO 🧮\n");
        
        // Sorting Algorithms Demo
        SortingAlgorithms.demonstrateSorting();
        
        System.out.println("=".repeat(50) + "\n");
        
        // Searching Algorithms Demo
        SearchingAlgorithms.demonstrateSearching();
    }
}