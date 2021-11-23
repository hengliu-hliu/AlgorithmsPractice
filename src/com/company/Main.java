package com.company;


import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        runAllSearchArray(10000000, 4596837);
//        runAllSearchArray(100000000, 76879847);

        runAllSortArray(85);
    }

    public static void runAllSearchArray(int arrSize, int element){
        SearchArray thirdSearchArr = new SearchArray(generateRanArray(arrSize));
        thirdSearchArr.linearSearch(element);
        System.out.println(thirdSearchArr.getSearchStats());
        thirdSearchArr.binarySearch(element, 0, -1);
        System.out.println(thirdSearchArr.getSearchStats());
        thirdSearchArr.jumpSearch(element);
        System.out.println(thirdSearchArr.getSearchStats());
        thirdSearchArr.interpolationSearch(element);
        System.out.println(thirdSearchArr.getSearchStats());
        thirdSearchArr.exponentialSearch(element);
        System.out.println(thirdSearchArr.getSearchStats());
        thirdSearchArr.fibonacciSearch(element);
        System.out.println(thirdSearchArr.getSearchStats());

    }

    public static void runAllSortArray(int arrSize){
        int[] arr = generateRanArray(arrSize);
        SortArray mySortArr = new SortArray(arr);
        SortArray mySortArr2 = new SortArray(arr);
        SortArray mySortArr3 = new SortArray(arr);
        SortArray mySortArr4 = new SortArray(arr);
        mySortArr.selectionSort();
        System.out.println(mySortArr.getSearchStats());
        mySortArr2.bubbleSort();
        System.out.println(mySortArr2.getSearchStats());
        mySortArr3.insertionSort();
        System.out.println(mySortArr3.getSearchStats());
        mySortArr4.mergeSort(mySortArr4.getArr(),0,arrSize);
        System.out.println(mySortArr4.getSearchStats());
    }

    public static int[] generateRanArray(int size){
        Random rand = new Random();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++ ) {
            arr[i] = rand.nextInt(size);
        }

        return arr;
    }
}



