package com.studerw.datastructures.ch5;

import com.studerw.datastructures.TimedTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class UniqueBadTest extends TimedTest {

    public static boolean unique3(int[] data, int low, int high) {
        log.debug("Checking for unique values - low: {}, high: {}: {}", low, high, Arrays.toString(Arrays.copyOfRange(data, low, high)));
        if (low >= high) {
//            log.debug("Low {} >= High {} -> TRUE", low, high);
            return true;
        } else if (!unique3(data, low, high - 1)) return false;
        else if (!unique3(data, low + 1, high)) return false;
        else {
            boolean result = data[low] != data[high];
            log.debug("data[{}]: {} != data[{}}: {}: -> {}", low, data[low], high, data[high], String.valueOf(result).toUpperCase());
            return result; // at most one item
        }
    }

    @Test
    void uniqueBad() {
        int[] x = new  int[] {1, 2, 3};
        boolean isUnique = unique3(x, 0, x.length -1);
        log.debug("isUnique: {}, for {}", isUnique, Arrays.toString(x));
        assertThat(isUnique).isTrue();
    }

    @Test
    void uniqueBad2() {
        int[] x = new  int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean isUnique = unique3(x, 0, x.length -1);
        log.debug("isUnique: {}, for {}", isUnique, Arrays.toString(x));
        assertThat(isUnique).isTrue();
    }
}