package com.studerw.datastructures.ch5;

import com.studerw.datastructures.TimedTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.studerw.datastructures.ch5.TowerOfHanoi.hanoi;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class TowerOfHanoiTest extends TimedTest {

    @Test
    void hanoiError() {
        assertThrows(IllegalArgumentException.class, () -> hanoi(0, 'A', 'B', 'C'));
    }

    @Test
    void hanoiOne() {
        int count = hanoi(1, 'A', 'B', 'C');
        log.debug("hanoi count for 1: {}", count);
        assertThat(count).isEqualTo(1);
    }

    @Test
    void hanoiTwo() {
        int count =hanoi(2, 'A', 'B', 'C');
        log.debug("hanoi count for 2: {}", count);
        assertThat(count).isEqualTo(3);
    }

    @Test
    void hanoiThree() {
        int count =hanoi(3, 'A', 'B', 'C');
        log.debug("hanoi count for 3: {}", count);
        assertThat(count).isEqualTo(7);
    }

    @Test
    @Disabled
    void hanoiTen() {
        int count =hanoi(10, 'A', 'B', 'C');
        log.debug("hanoi count for 10: {}", count);
        assertThat(count).isEqualTo(1023);
    }

    @Test
    @Disabled
    void hanoiTwenty() {
        int count =hanoi(20, 'A', 'B', 'C');
        log.debug("hanoi count for 21: {}", count);
        assertThat(count).isEqualTo(1_048_575);
    }

    @Test
    @Disabled
    void hanoiTwentyOne() {
        int count =hanoi(21, 'A', 'B', 'C');
        log.debug("hanoi count for 21: {}", count);
        assertThat(count).isEqualTo(2_097_151);
    }
}