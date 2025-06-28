package com.studerw.datastructures.ch4;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RepeatStr {

    /**
     * Repeat a string using string concatenation. Should take O(n2) due to java's use of reallocation of char
     * arrays on every new string creation.
     * @param x char to repeat
     * @param count number of times to repeat char x
     * @return the string
     */
    public static String repeat1(char x, int count) {
        log.debug("--- String concatenation Timing for '{}' repeated {} times ----", x, count);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String result = "";
        for (int i = 0; i < count; i++) {
            result += x;
        }
        log.debug("Concatenation Time in seconds: {}", stopWatch.getTime(TimeUnit.SECONDS));
        return result;
    }

    /**
     * Repeat a string using Java StringBuilder. Should take O(n).
     * @param x char to repeat
     * @param count number of times to repeat char x
     * @return the string
     */
    public static String repeat2(char x, int count) {
        log.debug("--- StringBuilder Timing for {} repeated '{}' times ----", x, count);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(x);
        }
        log.debug("StrBuilder Time in seconds: {}", stopWatch.getTime(TimeUnit.SECONDS));
        return result.toString();
    }

}
