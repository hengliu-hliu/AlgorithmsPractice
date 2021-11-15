package com.company;


import javax.sound.midi.SysexMessage;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SearchArray thirdSearchArr = new SearchArray(generateRanArray(1000000));
        thirdSearchArr.linearSearch(10681);
        System.out.println(thirdSearchArr.getSearchStats());
        thirdSearchArr.binarySearch(10681);
        System.out.println(thirdSearchArr.getSearchStats());
        thirdSearchArr.jumpSearch(10681);
        System.out.println(thirdSearchArr.getSearchStats());
        thirdSearchArr.interpolationSearch(10681);
        System.out.println(thirdSearchArr.getSearchStats());

    }

    public static int[] generateRanArray(int n){
        Random rand = new Random();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++ ) {
            arr[i] = rand.nextInt(1000000);
        }

        return arr;
    }
}



