package com.studerw.datastructures.ch7;

import com.studerw.datastructures.TimedTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MiscTest extends TimedTest {

    @Test
    @Disabled
    /**
     * Just seeing what happens when you misuse iterators.
     * This obviously runs forever.
     */
    public void testIterator() {
        List<String> list = new ArrayList<>(List.of("a", "b", "c"));
        while(list.iterator().hasNext()) {
            log.debug(list.iterator().next());
        }
    }
}
