package dsa.datastructures.arrays;

/**
 * Dynamic Array implementation (similar to ArrayList)
 * Demonstrates basic array operations and dynamic resizing
 */
public class DynamicArray<T> {
    private Object[] array;
    private int size;
    private int capacity;
    
    private static final int DEFAULT_CAPACITY = 10;
    
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }
    
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
    }
    
    /**
     * Add element at the end
     * Time Complexity: O(1) amortized
     */
    public void add(T element) {
        if (size >= capacity) {
            resize();
        }
        array[size++] = element;
    }
    
    /**
     * Add element at specific index
     * Time Complexity: O(n)
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (size >= capacity) {
            resize();
        }
        
        // Shift elements to the right
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        
        array[index] = element;
        size++;
    }
    
    /**
     * Remove element at specific index
     * Time Complexity: O(n)
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        T removedElement = (T) array[index];
        
        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        
        size--;
        array[size] = null; // Help GC
        
        return removedElement;
    }
    
    /**
     * Get element at specific index
     * Time Complexity: O(1)
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }
    
    /**
     * Set element at specific index
     * Time Complexity: O(1)
     */
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        array[index] = element;
    }
    
    /**
     * Check if array contains element
     * Time Complexity: O(n)
     */
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }
    
    /**
     * Find index of element
     * Time Complexity: O(n)
     */
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Get current size
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Clear all elements
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    
    /**
     * Resize the array when capacity is reached
     */
    private void resize() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}