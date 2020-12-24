package com.edouardcourty;

import com.edouardcourty.heap.FibonacciHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> unsorted = new ArrayList<>(Arrays.asList(12,4,16,1,7,19,8,9,10,15,2,5,3,17,6,20,11,18,15,13,14));
        List<Integer> sorted = FibonacciHeap.sort(unsorted);

        System.out.println(sorted.toString());
    }
}
