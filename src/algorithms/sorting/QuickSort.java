package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    
    
    public static int[] quickSort(int[] arr) {
        if(arr.length == 0 || arr.length == 1) return arr;
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(end - start  == 0) return;
        int pivot = arr[end];
        int i = start - 1;
        int j = start;
        while(j < end) {
            if(arr[j] < pivot) {
                i++;
                swap(arr,i,j);
            }
            j++;
        }
        i += 1;
        swap(arr,i,end);
        if(i-1 > 0) quickSort(arr,start,i-1);
        if(i + 1 < arr.length) quickSort(arr,i+1,end);
        return;
    }
    
    public static void swap(int[] arr, int firstIndex, int lastIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[lastIndex];
        arr[lastIndex] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = quickSort(new int[] {5,4,2,8,9,7,1});
        Arrays.stream(arr).forEach(System.out::println);
    }

}
