package com.studerw.datastructures;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

@Slf4j
public class TimedTest {
    private StopWatch stopWatch;
    private String testMethodName;
    private String testPackageName;

    @BeforeEach
    public void startTimer(TestInfo testInfo) {
        testMethodName = testInfo.getDisplayName();
        testPackageName = testInfo.getTestClass().map(Class::getSimpleName).orElse("");
        stopWatch = new StopWatch();
        log.debug("Beginning Test '{}'", testMethodName);
        stopWatch.start();
    }

    @AfterEach
    public void logExecutionTime() {
        stopWatch.stop();
        log.debug("Test '{}.{}' took {} seconds\n\n", testPackageName, testMethodName, stopWatch.getDuration().toMillis() / 1000);
    }
}
