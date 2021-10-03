package com.ahg.bruteforce;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SuccessivePair {

    public static List<Pair> successivePairs(int ...arr) {
        if(arr == null || arr.length == 0) {
            return Collections.emptyList();
        }

        List<Pair> pairs = new LinkedList<>();
        int k = 1;
        while(k < arr.length) {
            if(Math.abs(arr[k] - arr[k - 1]) == 1) {
                pairs.add(new Pair(arr[k - 1], arr[k]));
            }
            k++;
        }
        return pairs;
    }

    public static void main(String[] args) {
        List<Pair> pairs = successivePairs(4, 5, -2, -3, 11, 10, 5, 6, 20);
        System.out.println(pairs);
    }
}

@ToString
@AllArgsConstructor
class Pair {
    int x;
    int y;
}
