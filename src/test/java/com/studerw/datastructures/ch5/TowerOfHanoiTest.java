package com.studerw.datastructures.ch5;

import com.studerw.datastructures.TimedTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.studerw.datastructures.ch5.TowerOfHanoi.hanoi;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class TowerOfHanoiTest extends TimedTest {

    @Test
    void hanoiError() {
        assertThrows(IllegalArgumentException.class, () -> hanoi(0, 'A', 'B', 'C'));
    }

    @Test
    void hanoiOne() {
        hanoi(1, 'A', 'B', 'C');
    }

    @Test
    void hanoiTwo() {
        hanoi(2, 'A', 'B', 'C');
    }

    @Test
    void hanoiThree() {
        hanoi(3, 'A', 'B', 'C');
    }

    @Test
    void hanoiTen() {
        hanoi(10, 'A', 'B', 'C');
    }

    @Test
    @Disabled
    void hanoiTwenty() {
        hanoi(21, 'A', 'B', 'C');
    }
}