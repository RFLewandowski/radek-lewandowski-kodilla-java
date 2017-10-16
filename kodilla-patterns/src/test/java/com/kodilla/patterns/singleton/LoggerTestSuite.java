package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void init() {
        Logger
                .getInstance()
                .log("test message");
    }

    @Test
    public void Should_Log() {
        //Given
        //
        //When
        String testMessage = Logger
                .getInstance()
                .toString();
        //Then
        Assert.assertEquals("Logger(lastLog=test message)", testMessage);
    }


    @Test
    public void Should_GetLastLog() {
        //Given
        //
        //When
        String actualLog = Logger
                .getInstance()
                .getLastLog();
        //Then
        Assert.assertEquals("test message", actualLog);
    }
}
