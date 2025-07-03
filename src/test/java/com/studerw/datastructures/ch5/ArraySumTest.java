package com.studerw.datastructures.ch5;

import com.studerw.datastructures.TimedTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class ArraySumTest extends TimedTest {

    ArraySum arraySum;

    @BeforeEach
    public void setup() {
        arraySum = new ArraySum();
    }

    @Test
    void sumArrayNull() {
        assertThrows(IllegalArgumentException.class, () -> arraySum.sum(null));
    }

    @Test
    void sumArrayEmpty() {
        long sum = arraySum.sum(new int[] {});
        assertThat(sum).isEqualTo(0);
    }

    @Test
    void sumArrayOne() {
        int[] x = new int[] {5};
        long sum = arraySum.sum(x);
        log.debug("Result of summing {}: {}", Arrays.toString(x), sum);
        assertThat(sum).isEqualTo(5);
    }

    @Test
    void sumArrayFive() {
        int[] x = new int[] {1, 2, 3, 4, 5}; // should be equal to (n(n+1))/2 -> 5
        long sum = arraySum.sum(x);
        log.debug("Result of summing {}: {}", Arrays.toString(x), sum);
        assertThat(sum).isEqualTo(15);
    }

    @Test
    void sumArrayMillion() {
        int count = 1_000_000_000;
        int[] x = new int[count];

        for (int i = 0; i < count; i++) {
            x[i] = i + 1;
        }

        assertThrows(StackOverflowError.class, () -> arraySum.sum(x));
        //        long sum = arraySum.sum(x);
        //        log.debug("Result of summing 1...{}: {}", count, sum);
        //        assertThat(sum).isEqualTo(500_000_500_000L);
    }

    @Test
    void sumArray900() {
        int count = 900;
        int[] x = new int[count];

        for (int i = 0; i < count; i++) {
            x[i] = i + 1;
        }

        long sum = arraySum.sum(x);
        log.debug("Result of summing 1...{}: {}", count, sum);
        assertThat(sum).isEqualTo(405_450L);
    }
}