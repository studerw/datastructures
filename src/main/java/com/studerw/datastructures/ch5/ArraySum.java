package com.studerw.datastructures.ch5;

public class ArraySum {

    public long sum(int[] x) {
        if (x == null) {
            throw new IllegalArgumentException("x cannot be null");
        }
        if (x.length == 0) {
            return 0L;
        }
        return sumPriv(0, x);
    }

    private long sumPriv(int current, int[] x) {
        if (current == x.length - 1) {
            return x[current];
        }
        return x[current] + sumPriv(current + 1, x);
    }
}
