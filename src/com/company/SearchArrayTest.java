package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;


import static com.company.Main.generateRanArray;

public class SearchArrayTest {

    static SearchArray arr1000; // 1 thousand

    static SearchArray arr100000000; //100 million

    SearchArray ranArr1000;

    SearchArray ranArr100000000;

//    @BeforeAll
//    public static void setUp() throws  Exception{
//
//    }

    @org.junit.jupiter.api.Test
    void binarySearch() {
//        int[] arr = new int[1000];
//
//        for(int i = 1; i<arr.length; i++){
//            arr[i] = i;
//        }
//        arr1000 = new SearchArray(arr);
//
//        arr = new int[10000000];
//
//        for(int i = 0; i<arr.length; i++){
//            arr[i] = i;
//        }
//
//        arr100000000 = new SearchArray(arr);
//        arr1000.binarySearch(867, 0, -1);
//        System.out.println(arr1000.getSearchStats());
//        Assertions.assertEquals(arr1000.getIndexOfElement(), 867);
    }

    @org.junit.jupiter.api.Test
    void jumpSearch() {
//        int[]arr = new int[10000000];
//        for(int i = 0; i<arr.length; i++){
//            arr[i] = i;
//        }
//        arr100000000 = new SearchArray(arr);
//        arr1000.jumpSearch(867);
//        System.out.println(arr1000.getSearchStats());
//        Assertions.assertEquals(arr1000.getIndexOfElement(), 867);
    }

    @org.junit.jupiter.api.Test
    void interpolationSearch() {
    }
}
