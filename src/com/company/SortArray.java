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

}
