package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        if(arr.length == 0 || arr.length == 1) return arr;
        int[] res = mergeSort(arr, 0, arr.length - 1);
        return res;
    }
    
    public static int[] mergeSort(int[] arr, int start, int end) {
        if(end - start == 0) return new int[] {arr[start]};
        int mid = (start + end) / 2;
        int[] leftArray = mergeSort(arr, start, mid);
        int[] rightArray = mergeSort(arr, mid + 1, end);
        return merge(arr, leftArray, rightArray);
    }
    
    public static int[] merge(int[] arr, int[] leftArray, int[] rightArray) {
        if(leftArray.length == 0 || rightArray.length == 0) return new int[] {};
        int[] res = new int[leftArray.length + rightArray.length];
        int left = 0;
        int right = 0;
        int merged = 0;
        
        while(left < leftArray.length && right < rightArray.length) {
            if(leftArray[left] <= rightArray[right]) {
                res[merged++] = leftArray[left++];
            } else {
                res[merged++] = rightArray[right++];
            }
        }
        
        while(left < leftArray.length) {
            res[merged++] = leftArray[left++];
        }
        while(right < rightArray.length) res[merged++] = rightArray[right++];
        return res;
    }

    public static void main(String[] args) {
        int[] arr = mergeSort(new int[] {5,4,2,8,9,7,1});
        Arrays.stream(arr).forEach(System.out::println);
    }

}
