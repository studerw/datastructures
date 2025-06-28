package com.studerw.datastructures.ch3;

import java.util.Objects;

public class InsertionSorter {

    /**
     *
     * @param data character data array to be sorted. This mutates the array.
     */
    public static void sort(char[] data) {
        Objects.requireNonNull(data, "Char data array cannot be null.");

        // start at the second index (don't start at the first because that's the fist against which we begin comparing the others)
        for (int i = 1; i < data.length; i++) {
            char current = data[i];
            int y = i;
            while(y > 0 && data[y - 1]  > current){
                data[y] =  data[y - 1];
                y--;
            }
            data[y] = current;
        }
    }
}
