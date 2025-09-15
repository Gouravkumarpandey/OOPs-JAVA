package dsa.datastructures.linkedlists;

/**
 * Singly Linked List implementation
 * Fundamental data structure for DSA preparation
 */
public class SinglyLinkedList<T> {
    
    /**
     * Node class for the linked list
     */
    public static class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
        
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    private Node<T> head;
    private int size;
    
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Add element at the beginning
     * Time Complexity: O(1)
     */
    public void addFirst(T data) {
        head = new Node<>(data, head);
        size++;
    }
    
    /**
     * Add element at the end
     * Time Complexity: O(n)
     */
    public void addLast(T data) {
        if (head == null) {
            addFirst(data);
            return;
        }
        
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(data);
        size++;
    }
    
    /**
     * Add element at specific index
     * Time Complexity: O(n)
     */
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        current.next = new Node<>(data, current.next);
        size++;
    }
    
    /**
     * Remove first element
     * Time Complexity: O(1)
     */
    public T removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    /**
     * Remove last element
     * Time Complexity: O(n)
     */
    public T removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        
        if (head.next == null) {
            return removeFirst();
        }
        
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }
    
    /**
     * Remove element at specific index
     * Time Complexity: O(n)
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            return removeFirst();
        }
        
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }
    
    /**
     * Get element at specific index
     * Time Complexity: O(n)
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    /**
     * Check if list contains element
     * Time Complexity: O(n)
     */
    public boolean contains(T data) {
        return indexOf(data) >= 0;
    }
    
    /**
     * Find index of element
     * Time Complexity: O(n)
     */
    public int indexOf(T data) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data != null && current.data.equals(data)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }
    
    /**
     * Get size of the list
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Clear the list
     */
    public void clear() {
        head = null;
        size = 0;
    }
    
    /**
     * Reverse the linked list
     * Time Complexity: O(n)
     */
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
    }
    
    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}