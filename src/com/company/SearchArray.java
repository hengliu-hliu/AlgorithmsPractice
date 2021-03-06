package com.company;

import java.util.Arrays;

class SearchArray implements StructSearch{
    private final int[] arr;
    private String timeComplexity;
    private int numOfOperations;
    private String lastOperation;

    public int getIndexOfElement() {
        return indexOfElement;
    }

    private int searchedElement;
    private int indexOfElement;

    public SearchArray(int[] arr){
        Arrays.sort(arr);
        this.arr = arr;
        timeComplexity = null;
        numOfOperations = -1;
        lastOperation = null;
        searchedElement = -1;
        indexOfElement = -1;
    }

    public String toString(){
        return Arrays.toString(arr);
    }

    public String returnStructType(){
        return "Array";
    }

    public String getSearchStats() {
        String stats = "Performed: " + lastOperation + "\t\t"
                + "Time Complexity: " + timeComplexity + "\n"
                + "Number of Operations: " + numOfOperations + "\t"
                + "Total Number of Elements: " + arr.length + "\n"
                + "Searched Element: " + searchedElement + "\t\t"
                + "Index of Element: " + indexOfElement + "\n";

        if(arr.length < 100){
            stats = stats + "Contents of Array: " + Arrays.toString(arr) + "\n";
        }

        return stats;
    }

    //linear search
    public int linearSearch(int element){
        lastOperation = "Linear Search";
        timeComplexity = "O(n)";
        numOfOperations = 0;
        searchedElement = element;
        indexOfElement = -1;

        for(int i=0; i<arr.length; i++) {
            numOfOperations++;
            if (element == arr[i]) {
                indexOfElement = i;
                break;
            }
        }
        return indexOfElement;
    }

    //binary search
    ///*** current errors still
    public int binarySearch(int element, int lo, int hi){
        if(lo == 0) {
            lastOperation = "Binary Search";
            timeComplexity = "O(log n)";
            numOfOperations = 0;
            searchedElement = element;
            indexOfElement = -1;
        }

        int low;
        int high;

        if(lo == -1){
            low = 0;
        }else{
            low = lo;
        }

        if(hi == -1){
            high = arr.length;
        }else{
            high = hi;
        }


        while(true){
            numOfOperations++;
            int index = (low+high)/2;
            if(arr[index] == element){
                indexOfElement = index;
                break;
            }
            if(low == high){
                indexOfElement = -1;
                break;
            }
            System.out.println(low);
            System.out.println(high);

            if(arr[index] > element) {
                high = index -1;
            }else if(arr[index] < element){
                low = index + 1;
            }

        }
        return indexOfElement;

    }

    //jump search
    public int jumpSearch(int element){
        lastOperation = "Jump Search";
        timeComplexity = "O(\u221An)";
        numOfOperations = 0;
        searchedElement = element;
        indexOfElement = -1;

        int jump = (int)Math.sqrt(arr.length);
        int index = 0;

        int startIndex = -1;
        int endIndex = -1;

        while(index < arr.length){
            numOfOperations++;
            if(arr[index] == element){
                indexOfElement = index;
                break;
            }else if(arr[index] > element){
                startIndex = index - jump;
                endIndex = index;
                break;
            }
            index = index + jump;
            if(index != arr.length-1 && index >= arr.length){
                index = arr.length-1;
            }
        }

        if(startIndex >= 0 && endIndex >= 0){
            for(int i = startIndex; i < endIndex; i++){
                numOfOperations++;
                if(arr[i] == element){
                    indexOfElement = i;
                    break;
                }
            }
        }
        return indexOfElement;
    }

    //interpolation Search
    /*  y = m*x + c
        arr[hi] = m*hi+c    [1]
        arr[lo] = m*lo+c    [2]
        x = m*pos +c        [3]     [x is the value, pos is its index]

        m = (arr[hi] - arr[lo])/(hi-lo)     [2-1]   [4]
        pos = (x - arr[lo])/m + lo          [3-2]   [5]
        pos = lo + (x - arr[lo])*(hi-lo)/(arr[hi] - arr[lo])
        */
    public int interpolationSearch(int element){
        lastOperation = "Interpolation Search";
        timeComplexity = "O(log2(log2 n))[Best]\t\tO(n)[Worse]";
        numOfOperations = 0;
        searchedElement = element;
        indexOfElement = -1;

        int lo = 0;
        int hi = arr.length-1;
        int pos;

        while(lo <= hi &&  element >= arr[lo] && element <= arr[hi]){
            numOfOperations++;
            pos = lo + ((hi-lo)/(arr[hi] - arr[lo]))*(element-arr[lo]);

            if(arr[pos] == element){
                indexOfElement = pos;
                break;
            }

            if(arr[pos] > element){
                hi = pos - 1;
            }else if(arr[pos] < element){
                lo = pos + 1;
            }
        }
        return indexOfElement;
    }

    //Exponential Search
    /*especially useful for unbounded searches - arrays of infinite length
      works better for items near beginning of list*/
    public int exponentialSearch(int element){
        lastOperation = "Exponential Search";
        timeComplexity = "O(Log n)";
        numOfOperations = 0;
        searchedElement = element;
        indexOfElement = -1;
        int index = 0;

        if(arr[index] == element){
            numOfOperations++;
            indexOfElement = 0;
            return indexOfElement;
        }
        index++;

        while(index < arr.length && arr[index] < element){
            index = index*2;
        }

        int lo = index/2;
        int hi = index;
        if(hi>arr.length-1){
            hi = arr.length-1;
        }
        binarySearch(element, lo, hi);

        return indexOfElement;
    }

    public int fibonacciSearch(int element){
        lastOperation = "Fibonacci Search";
        timeComplexity = "O(Log n)";
        numOfOperations = 0;
        searchedElement = element;
        indexOfElement = -1;

        int fib1 = 0;
        int fib2 = 1;
        int fibNext = fib1 + fib2;

        while(fibNext < arr.length){
            fib1 = fib2;
            fib2 = fibNext;
            fibNext = fib1 + fib2;
        }

        int offset = -1;

        while(fibNext > 1){
            numOfOperations++;
            int i = Math.min(offset + fib1, arr.length-1);
            System.out.println(i);
            if(arr[i] < element){
                fibNext = fib2;
                fib2 = fib1;
                fib1 = fibNext - fib2;
                offset = i;
            }else if(arr[i] > element){
                fibNext = fib1;
                fib2 = fib2 - fib1;
                fib1 = fibNext -fib2;
            }else{
                indexOfElement = i;
                return indexOfElement;
            }
        }

        if(fib2 == 1 && arr[arr.length-1] == element){
            numOfOperations++;
            indexOfElement = arr.length-1;
            return indexOfElement;
        }
        numOfOperations++;
        indexOfElement = -1;

        return indexOfElement;
    }

}
