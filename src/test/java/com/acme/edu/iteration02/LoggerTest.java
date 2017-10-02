package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.Prefix;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
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


    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.stop();
        //endregion

        //region then
        assertSysoutEquals(
                Prefix.STRING.value() + lineSeparator() +
                "str 1" + lineSeparator() +
                        Prefix.PRIMITIVE.value() +
                        "3" + lineSeparator() +
                        Prefix.STRING.value() + lineSeparator() +
                        "str 2" + lineSeparator() +
                        Prefix.PRIMITIVE.value() +
                        "0" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.stop();
        //endregion

        //region then
        assertSysoutEquals(
                Prefix.STRING.value() + lineSeparator() +
                        "str 1" + lineSeparator() +
                        Prefix.PRIMITIVE.value() +
                        Integer.MAX_VALUE + lineSeparator() +
                        "10" + lineSeparator() +
                        Prefix.STRING.value() + lineSeparator() +
                        "str 2" + lineSeparator() +
                        Prefix.PRIMITIVE.value() +
                        "0" + lineSeparator()
        );

        assertSysoutContains("str 1");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE));
        assertSysoutContains("10");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte) 10);
        Logger.log(Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.stop();
        //endregion

        //region then
        assertSysoutEquals(
                Prefix.STRING.value() + lineSeparator() +
                        "str 1" + lineSeparator() +
                        Prefix.PRIMITIVE.value() +
                        Byte.MAX_VALUE + lineSeparator() +
                        "10" + lineSeparator() +
                        Prefix.STRING.value() + lineSeparator() +
                        "str 2" + lineSeparator() +
                        Prefix.PRIMITIVE.value() +
                        "0" + lineSeparator()
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.stop();
        //endregion

        //region then
        assertSysoutEquals(
                "string: " + lineSeparator() +
                        "str 1" + lineSeparator() +
                        "str 2 (x2)" + lineSeparator() +
                        "primitive: " + lineSeparator() +
                        "0" + lineSeparator() +
                        "string: " + lineSeparator() +
                        "str 2" + lineSeparator() +
                        "str 3 (x3)" + lineSeparator()
        );
        //endregion
    }


}