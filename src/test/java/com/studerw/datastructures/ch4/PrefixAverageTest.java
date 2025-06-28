package com.studerw.datastructures.ch4;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class PrefixAverageTest {

    @Test
    void prefixAverage1Null() {
        assertThrows(NullPointerException.class, () -> PrefixAverage.prefixAverage1(null));
    }

    @Test
    void prefixAverage1Empty() {
        var x = new double[] {};
        double[] result = PrefixAverage.prefixAverage1(x);
        log.debug("result: {}", Arrays.toString(result));
        assertThat(result).isEmpty();
    }

    @Test
    void prefixAverage1OneMember() {
        var x = new double[] {2.0};
        double[] result = PrefixAverage.prefixAverage1(x);
        log.debug("result: {}", Arrays.toString(result));
        assertThat(result).hasSize(1);
        assertThat(result[0]).isEqualTo(2.0);
    }

    @Test
    void prefixAverage1TwoMember() {
        var x = new double[] {2.0, 8.0};
        double[] result = PrefixAverage.prefixAverage1(x);
        log.debug("result: {}", Arrays.toString(result));
        assertThat(result).hasSize(2);
        assertThat(result[0]).isEqualTo(2.0);
        assertThat(result[1]).isEqualTo(5.0);
    }

    @Test
    void prefixAverage1hundred() {
        double[] x = new double[100];
        for (int j = 0; j < 100; j++) {
            x[j] = j + 1.0;
        }
        log.debug("Calculating for: {}",  Arrays.toString(x));

        double[] result = PrefixAverage.prefixAverage1(x);
        log.debug("result: {}", Arrays.toString(result));

        assertThat(result).hasSize(100);
        assertThat(result[0]).isEqualTo(1.0);
        assertThat(result[9]).isEqualTo(5.5);
        assertThat(result[99]).isEqualTo(50.5);
    }

    @Test
    void prefixAverage1OneHundredThousand() {
        double[] x = new double[100_000];
        for (int j = 0; j < 100_000; j++) {
            x[j] = j + 1.0;
        }

        log.debug("--- Simple Timing for 100_000 prefix1 ---");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        double[] result = PrefixAverage.prefixAverage1(x);
        stopWatch.stop();
        log.debug("Time elapsed: {}",stopWatch); // Uses StopWatch's toString()
        log.debug("Time in seconds: {}", stopWatch.getTime(TimeUnit.SECONDS));
//        log.debug("result: {}", Arrays.toString(result));

        assertThat(result).hasSize(100_000);
        assertThat(result[0]).isEqualTo(1.0);
        assertThat(result[9]).isEqualTo(5.5);
        assertThat(result[99]).isEqualTo(50.5);
        assertThat(result[99_999]).isEqualTo(50000.5);
    }

    @Test
    @Disabled // disabled b/c it takes too long
    void prefixAverage1TwoHundredThousand() {
        double[] x = new double[200_000];
        for (int j = 0; j < 200_000; j++) {
            x[j] = j + 1.0;
        }

        log.debug("--- Simple Timing for 200_000 prefix1 ---");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        double[] result = PrefixAverage.prefixAverage1(x);
        stopWatch.stop();
        log.debug("Time elapsed: {}",stopWatch); // Uses StopWatch's toString()
        log.debug("Time in seconds: {}", stopWatch.getTime(TimeUnit.SECONDS));
//        log.debug("result: {}", Arrays.toString(result));

        assertThat(result).hasSize(200_000);
        assertThat(result[0]).isEqualTo(1.0);
        assertThat(result[9]).isEqualTo(5.5);
        assertThat(result[99]).isEqualTo(50.5);
        assertThat(result[99_999]).isEqualTo(50000.5);
    }

    @Test
    void prefixAverage2Null() {
        assertThrows(NullPointerException.class, () -> PrefixAverage.prefixAverage2(null));
    }

    @Test
    void prefixAverage2Empty() {
        var x = new double[] {};
        double[] result = PrefixAverage.prefixAverage2(x);
        log.debug("result: {}", Arrays.toString(result));
        assertThat(result).isEmpty();
    }

    @Test
    void prefixAverage2OneMember() {
        var x = new double[] {2.0};
        double[] result = PrefixAverage.prefixAverage2(x);
        log.debug("result: {}", Arrays.toString(result));
        assertThat(result).hasSize(1);
        assertThat(result[0]).isEqualTo(2.0);
    }

    @Test
    void prefixAverage2TwoMember() {
        var x = new double[] {2.0, 8.0};
        double[] result = PrefixAverage.prefixAverage2(x);
        log.debug("result: {}", Arrays.toString(result));
        assertThat(result).hasSize(2);
        assertThat(result[0]).isEqualTo(2.0);
        assertThat(result[1]).isEqualTo(5.0);
    }

    @Test
    void prefixAverage2hundred() {
        double[] x = new double[100];
        for (int j = 0; j < 100; j++) {
            x[j] = j + 1.0;
        }
        log.debug("Calculating for: {}",  Arrays.toString(x));

        double[] result = PrefixAverage.prefixAverage2(x);
        log.debug("result: {}", Arrays.toString(result));

        assertThat(result).hasSize(100);
        assertThat(result[0]).isEqualTo(1.0);
        assertThat(result[9]).isEqualTo(5.5);
        assertThat(result[99]).isEqualTo(50.5);
    }

    @Test
    void prefixAverage2OneHundredThousand() {
        double[] x = new double[100_000];
        for (int j = 0; j < 100_000; j++) {
            x[j] = j + 1.0;
        }

        log.debug("--- Simple Timing for 100_000 prefix1 ---");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        double[] result = PrefixAverage.prefixAverage2(x);
        stopWatch.stop();
        log.debug("Time elapsed: {}",stopWatch); // Uses StopWatch's toString()
        log.debug("Time in seconds: {}", stopWatch.getTime(TimeUnit.SECONDS));
//        log.debug("result: {}", Arrays.toString(result));

        assertThat(result).hasSize(100_000);
        assertThat(result[0]).isEqualTo(1.0);
        assertThat(result[9]).isEqualTo(5.5);
        assertThat(result[99]).isEqualTo(50.5);
        assertThat(result[99_999]).isEqualTo(50000.5);
    }

    @Test
    void prefixAverage2TwoHundredThousand() {
        double[] x = new double[200_000];
        for (int j = 0; j < 200_000; j++) {
            x[j] = j + 1.0;
        }

        log.debug("--- Simple Timing for 200_000 prefix1 ---");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        double[] result = PrefixAverage.prefixAverage2(x);
        stopWatch.stop();
        log.debug("Time elapsed: {}",stopWatch); // Uses StopWatch's toString()
        log.debug("Time in seconds: {}", stopWatch.getTime(TimeUnit.SECONDS));
//        log.debug("result: {}", Arrays.toString(result));

        assertThat(result).hasSize(200_000);
        assertThat(result[0]).isEqualTo(1.0);
        assertThat(result[9]).isEqualTo(5.5);
        assertThat(result[99]).isEqualTo(50.5);
        assertThat(result[99_999]).isEqualTo(50000.5);
    }

}