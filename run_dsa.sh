#!/bin/bash

# DSA Preparation Setup Script
# This script helps you compile and run the DSA code

echo "🚀 DSA Preparation in Java - Setup Script 🚀"
echo "=============================================="

# Check if Java is installed
if ! command -v javac &> /dev/null; then
    echo "❌ Java compiler (javac) not found. Please install Java JDK first."
    exit 1
fi

if ! command -v java &> /dev/null; then
    echo "❌ Java runtime (java) not found. Please install Java JDK first."
    exit 1
fi

echo "✅ Java found: $(java -version 2>&1 | head -n 1)"
echo ""

# Navigate to source directory
cd src/main/java

echo "📁 Current directory: $(pwd)"
echo ""

# Clean previous compilation
echo "🧹 Cleaning previous compilation..."
find . -name "*.class" -delete
echo "✅ Clean completed"
echo ""

# Compile all Java files
echo "🔨 Compiling Java files..."
if javac dsa/**/*.java; then
    echo "✅ Compilation successful!"
else
    echo "❌ Compilation failed!"
    exit 1
fi
echo ""

# Function to run a specific class
run_class() {
    local class_name=$1
    local description=$2
    
    echo "▶️  Running $description..."
    echo "   Command: java $class_name"
    echo "   " + "=" * 50
    
    if java "$class_name"; then
        echo "   " + "=" * 50
        echo "✅ $description completed successfully!"
    else
        echo "❌ Failed to run $description"
    fi
    echo ""
}

# Main menu
while true; do
    echo "🎯 What would you like to run?"
    echo "1. Complete DSA Demo (recommended for first run)"
    echo "2. Two Sum Problem (Easy)"
    echo "3. Longest Substring Problem (Medium)"
    echo "4. Sorting Algorithms Demo"
    echo "5. Searching Algorithms Demo"
    echo "6. Compile only"
    echo "7. Exit"
    echo ""
    read -p "Enter your choice (1-7): " choice
    
    case $choice in
        1)
            run_class "dsa.DSADemo" "Complete DSA Demo"
            ;;
        2)
            run_class "dsa.problems.easy.TwoSum" "Two Sum Problem"
            ;;
        3)
            run_class "dsa.problems.medium.LongestSubstringWithoutRepeating" "Longest Substring Problem"
            ;;
        4)
            echo "▶️  Running Sorting Demo..."
            java -cp . dsa.algorithms.sorting.SortingAlgorithms
            echo ""
            ;;
        5)
            echo "▶️  Running Searching Demo..."
            java -cp . dsa.algorithms.searching.SearchingAlgorithms
            echo ""
            ;;
        6)
            echo "✅ Compilation completed. Files are ready to run."
            echo ""
            ;;
        7)
            echo "👋 Happy coding! Good luck with your DSA preparation!"
            exit 0
            ;;
        *)
            echo "❌ Invalid choice. Please enter 1-7."
            echo ""
            ;;
    esac
done