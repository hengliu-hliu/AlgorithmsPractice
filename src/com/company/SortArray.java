package com.company;

import java.util.Arrays;

public class SortArray {
    private final int[] arr;
    private String timeComplexity;
    private int numOfOperations;
    private String lastOperation;

    public SortArray(int[] arr){
        this.arr = arr;
        timeComplexity = null;
        numOfOperations = -1;
        lastOperation = null;
    }

    public int[] getArr() {
        return arr;
    }

    public String getSearchStats() {
        String stats = "Performed: " + lastOperation + "\t\t"
                + "Time Complexity: " + timeComplexity + "\n"
                + "Number of Operations: " + numOfOperations + "\t"
                + "Total Number of Elements: " + arr.length + "\n";

        if(arr.length < 100){
            stats = stats + "Contents of Array: " + Arrays.toString(arr) + "\n";
        }

        return stats;
    }

    /*Selection Sort*/
    public int selectionSort(){
        lastOperation = "Selection Sort";
        timeComplexity = "O(n\00B2)";
        int loIndex;

        for(int i=0; i<arr.length; i++){
            numOfOperations++;
            loIndex = i;

            for(int j = i+1; j < arr.length; j++){
                numOfOperations++;
                if(arr[j] < arr[loIndex]){
                    loIndex = j;
                }
            }
            int lo = arr[loIndex];
            arr[loIndex] = arr[i];
            arr[i] = lo;
        }

        return 0;
    }

    /*Bubble Sort */
    public int bubbleSort(){
        lastOperation = "Bubble Sort";
        timeComplexity = "O(n\02)";
        numOfOperations = 0;
        boolean swapped = true;
        int lo;

        if(arr.length < 2){
            return 0;
        }

        while(swapped) {
            swapped = false;
            for (int i = 1; i < arr.length; i++) {
                numOfOperations++;
                if (arr[i] < arr[i - 1]) {
                    swapped = true;
                    lo = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = lo;
                }
            }
        }

        return 0;
    }

    /*Insertion Sort*/
    public int insertionSort(){
        lastOperation = "Insertion Sort";
        timeComplexity = "O(n\02)";
        numOfOperations = 0;

        int prevIntIndex;
        int currInt;

        if(arr.length < 2){
            return 0;
        }

        for(int i=1; i<arr.length; i++){
            numOfOperations++;
            currInt = arr[i];
            prevIntIndex = i;

            for(int j=i-1; j >= 0; j--){
                numOfOperations++;
                if(arr[j] > currInt){
                    arr[prevIntIndex] = arr[j];
                    prevIntIndex = j;
                }
            }
            arr[prevIntIndex] = currInt;
        }

        return 0;
    }

    public void mergeSort(int array[], int startIndex, int endIndex){
        lastOperation = "Merge Sort";
        timeComplexity = "...";
        if(startIndex == 0 && endIndex == arr.length) {
            numOfOperations = 0;
        }

        numOfOperations++;

        if(array.length < 2){
            return;
        }
        int mid = array.length/2;

        // left subarr
        int[] left = new int[mid];
        for(int i=0; i<mid; i++){

            left[i] = array[i];
        }

        //right subarr
        int[] right = new int[array.length-mid];
        for(int i=mid; i<array.length;i++){
            right[i-mid] = array[i];
        }

        mergeSort(left, startIndex, mid);
        mergeSort(right,mid+1, endIndex);

        int i = 0;  //left
        int j = 0;  //right
        int k = 0;  //array

        while(i<left.length && j < right.length){
            if(left[i] < right[j]){
                array[k] = left[i];
                i++;
            }else{
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<left.length){
            array[k] = left[i];
            i++;
            k++;
        }

        while(j<right.length){

            array[k] = right[j];
            j++;
            k++;
        }


    }



}
