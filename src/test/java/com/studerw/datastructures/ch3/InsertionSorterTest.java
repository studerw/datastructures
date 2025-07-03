package com.studerw.datastructures.ch3;

import com.studerw.datastructures.TimedTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class InsertionSorterTest extends TimedTest {

    @Test
    void insertionSortNull() {
        assertThrows(NullPointerException.class, () -> InsertionSorter.sort(null));
    }

    @Test
    void insertionSortEmpty() {
        char[] data = new char[0];
        InsertionSorter.sort(data);
        assertThat(data).isEmpty();
    }

    @Test
    void insertionSortSorted() {
        char[] data = new char[]{'a', 'b', 'c'};
        InsertionSorter.sort(data);

        log.debug(Arrays.toString(data));

        assertThat(data).hasSize(3);
        assertThat(data[0]).isEqualTo('a');
        assertThat(data[1]).isEqualTo('b');
        assertThat(data[2]).isEqualTo('c');
    }

    @Test
    void insertionSortSingle() {
        char[] data = new char[]{'a'};
        InsertionSorter.sort(data);

        log.debug(Arrays.toString(data));

        assertThat(data).hasSize(1);
        assertThat(data[0]).isEqualTo('a');
    }

    @Test
    void insertionSortUnsorted() {
        char[] data = new char[]{'c', 'b', 'a'};
        InsertionSorter.sort(data);
        log.debug(Arrays.toString(data));

        assertThat(data).hasSize(3);
        assertThat(data[0]).isEqualTo('a');
        assertThat(data[1]).isEqualTo('b');
        assertThat(data[2]).isEqualTo('c');

        data = new char[]{'c', 'c', 'b'};
        InsertionSorter.sort(data);
        log.debug(Arrays.toString(data));
        assertThat(data).hasSize(3);
        assertThat(data[0]).isEqualTo('b');
        assertThat(data[1]).isEqualTo('c');
        assertThat(data[2]).isEqualTo('c');

        data = new char[]{'b', 'x', 'x', 'z', 's', 's', 'm'};
        // b,m,s,s,x,x,z
        InsertionSorter.sort(data);
        log.debug(Arrays.toString(data));
        assertThat(data).hasSize(7);
        assertThat(data[0]).isEqualTo('b');
        assertThat(data[3]).isEqualTo('s');
        assertThat(data[5]).isEqualTo('x');
        assertThat(data[6]).isEqualTo('z');
    }
}