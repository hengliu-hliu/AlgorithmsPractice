package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch{

    private List<Integer> list;
    private final int[] arr;

    public BinarySearch(int[] arr){
        this.arr = arr;
//        list = Arrays.asList(arr);
    }

    public String printList(){
        return Arrays.toString(arr);
    }


}
