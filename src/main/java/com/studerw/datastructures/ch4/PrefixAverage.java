package com.studerw.datastructures.ch4;

import java.util.Objects;

public class PrefixAverage {

    /**
     * calculates prefix averages, but runs in quadratic time i.e. O(n^2).
     * @param x array of doubles
     * @return prefix averages array of doubles
     */
    public static double[] prefixAverage1(double[] x) {
        Objects.requireNonNull(x);
        if (x.length == 0) return new double[] {};

        var averages = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            double sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += x[j];
            }
            averages[i] = sum / (i + 1);
        }
        return averages;
    }

    /**
     * calculate array of prefix averages. Should run in O(n),
     * @param x array of doubles
     * @return prefix averages array of doubles
     */
    public static double[] prefixAverage2(double[] x) {
        Objects.requireNonNull(x);
        if (x.length == 0) return new double[] {};

        var averages = new double[x.length];
        averages[0] = x[0];

        var sums = new double[x.length];
        sums[0] = x[0];

        for (int i = 1; i < x.length; i++) {
            double sum = sums[i-1] + x[i];
            sums[i] = sum;
            double avg = sum / (i + 1);
            averages[i] = avg;
        }
        return averages;
    }
}
