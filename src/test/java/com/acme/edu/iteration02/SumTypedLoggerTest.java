package com.acme.edu.iteration02;

import com.acme.edu.SumTypedLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SumTypedLoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion



    //TODO: implement SumTypedLogger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        SumTypedLogger.log("str 1");
        SumTypedLogger.log(1);
        SumTypedLogger.log(2);
        SumTypedLogger.log("str 2");
        SumTypedLogger.log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "3\n" +
            "str 2\n" +
            "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        SumTypedLogger.log("str 1");
        SumTypedLogger.log(10);
        SumTypedLogger.log(Integer.MAX_VALUE);
        SumTypedLogger.log("str 2");
        SumTypedLogger.log(0);
        //endregion

        //region then
        assertSysoutContains(
            "str 1\n" +
            "10\n" +
            Integer.MAX_VALUE + "\n" +
            "str 2\n" +
            "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        SumTypedLogger.log("str 1");
        SumTypedLogger.log((byte)10);
        SumTypedLogger.log((byte)Byte.MAX_VALUE);
        SumTypedLogger.log("str 2");
        SumTypedLogger.log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "10\n" +
            Byte.MAX_VALUE + "\n" +
            "str 2\n" +
            "0\n"
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        SumTypedLogger.log("str 1");
        SumTypedLogger.log("str 2");
        SumTypedLogger.log("str 2");
        SumTypedLogger.log(0);
        SumTypedLogger.log("str 2");
        SumTypedLogger.log("str 3");
        SumTypedLogger.log("str 3");
        SumTypedLogger.log("str 3");
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\n" +
            "str 2 (x2)\n" +
            "0\n" +
            "str 2\n" +
            "str 3 (x3)\n"
        );
        //endregion
    }


}