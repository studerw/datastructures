package com.studerw.datastructures.ch5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TowerOfHanoi {

    public static int hanoi(int n, char source, char destination, char auxiliary) {
        if (n < 1) throw new IllegalArgumentException("Number of discs for Hanoi must be 1 or more.");
        if (n == 1) {
            log.debug("Moving disk from {} to {}", source, destination);
            return 1;
        }
        int moves = 0;
        // A =  source, B = desintation, C = auxiliary
        // Move n from A -> B, using C as auxiliary

        // move top n - 1 from A - > C using B as auxiliary
        moves += hanoi(n - 1, source, auxiliary, destination);

        // move last one from A - > B using C as auxiliary
        moves += hanoi(1, source, destination, auxiliary);

        // move last one from C - > B using A as auxiliary
        moves += hanoi(n - 1, auxiliary, destination, source);

        return moves;
    }
}
