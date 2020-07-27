package algorithms.sorting;

import java.util.Arrays;

public class HeapSort {
    
    static int[] heap;
    static int size = 0;
    static int resIndex = 0;
    public static int[] heapSort(int[] arr) {
        if(arr.length == 0 || arr.length == 1) return arr;
        //insert elements into heap
        heap = new int[arr.length];
        int[] res = new int[arr.length];
        for(int each:arr) insertIntoMinHeap(each);

        
        return heap;
    }

    private static void insertIntoMinHeap(int each) {
        heap[size++] = each;
        heapifyUp(size - 1, 0);
    }

    private static void heapifyUp(int currentIndex, int startIndex) {
        int parentIndex = getParentIndex(currentIndex);
        while(heap[parentIndex] > heap[currentIndex] && parentIndex >= startIndex) {
            //swap
            int temp = heap[parentIndex];
            heap[parentIndex] = heap[currentIndex];
            heap[currentIndex] = temp;
            currentIndex = parentIndex;
        }
    }

    private static int getParentIndex(int size) {
        return (size - 1) / 2;
    }

    public static void main(String[] args) {
        heapSort(new int[] {5,2,1,9,6,4});
    }

}


