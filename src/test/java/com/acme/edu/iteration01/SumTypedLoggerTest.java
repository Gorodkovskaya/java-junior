package com.acme.edu.iteration01;

import com.acme.edu.SumTypedLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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

    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        SumTypedLogger.log(1);
        SumTypedLogger.log(0);
        SumTypedLogger.log(-1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1\r\nprimitive: 0\r\nprimitive: -1\r\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        SumTypedLogger.log((byte)1);
        SumTypedLogger.log((byte)0);
        SumTypedLogger.log((byte)-1);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

//    TODO: implement SumTypedLogger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        SumTypedLogger.log('a');
        SumTypedLogger.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        SumTypedLogger.log("test string 1");
        SumTypedLogger.log("other str");
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }
    /*
    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        SumTypedLogger.log(true);
        SumTypedLogger.log(false);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        SumTypedLogger.log(new Object());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

    */
}