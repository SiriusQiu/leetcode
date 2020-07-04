package com.cqupt.sirius.awing;

public class Basic {
    public int[] quickSort(int[] array){
        quickSort(array, 0, array.length-1);
        return array;
    }
    public int[] quickSort(int[] array, int left, int right){
        if (left >= right) return array;
        int i = left - 1;
        int j = right + 1;
        int x = array[left];
        while (i < j){
            while (array[++i] < x);
            while (array[--j] > x);
            swap(array, i, j);
        }
        quickSort(array, left, j);
        quickSort(array, j+1, right);
        return array;
    }

    public int quickSearchK(int[] arr, int left, int right, int k){
        if (left >= right) return arr[left];
        int i = left - 1;
        int j = right + 1;
        int x = arr[left + right >> 1];
        while (i < j){
            while (arr[++i] < x);
            while (arr[--j] > x);
            swap(arr, i, j);
        }
        if (j - left + 1 >= k) return quickSearchK(arr, left, j, k);
        else return quickSearchK(arr, j + 1, right, k - (j - left + 1));
    }

    public void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
