package com.company;


import javax.sound.midi.SysexMessage;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        runAll(10000000, 4596837);
        runAll(100000000, 76879847);

    }

    public static void runAll(int arrSize, int element){
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



