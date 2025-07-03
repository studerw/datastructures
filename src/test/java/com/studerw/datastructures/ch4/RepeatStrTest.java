package com.studerw.datastructures.ch4;

import com.studerw.datastructures.TimedTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class RepeatStrTest extends TimedTest {

    @Test
    void repeat1() {
        String result = RepeatStr.repeat1('a', 5);
        assertThat(result).isEqualTo("aaaaa");
        log.debug("result: {}", result);
    }

    @Test
    void repeat1Empty() {
        String result = RepeatStr.repeat1('a', 0);
        assertThat(result).isEqualTo("");
        log.debug("result: {}", result);
    }

    @Test
    @Disabled // disable because it takes too long
    void repeat1Big() {
        String result = RepeatStr.repeat1('a', 1_000_000);
        assertThat(result).hasSize(1_000_000);
//        log.debug("result: {}", result);
    }

    @Test
    void repeat2() {
        String result = RepeatStr.repeat2('a', 5);
        assertThat(result).isEqualTo("aaaaa");
        log.debug("result: {}", result);
    }

    @Test
    void repeat2Empty() {
        String result = RepeatStr.repeat2('a', 0);
        assertThat(result).isEqualTo("");
        log.debug("result: {}", result);
    }

    @Test
    void repeat2Big() {
        String result = RepeatStr.repeat2('a', 1_000_000_000);
        assertThat(result).hasSize(1_000_000_000);
//        log.debug("result: {}", result);
    }
}