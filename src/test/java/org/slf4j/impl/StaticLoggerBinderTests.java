package org.slf4j.impl;

import org.junit.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

import com.github.valfirst.slf4jtest.TestLoggerFactory;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class StaticLoggerBinderTests {

    @Test
    public void getLoggerFactory() {
        assertSame(TestLoggerFactory.getInstance(), StaticLoggerBinder.getSingleton().getLoggerFactory());
    }

    @Test
    public void getLoggerFactoryClassStr() {
        assertEquals("com.github.valfirst.slf4jtest.TestLoggerFactory", StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr());
    }

    @Test
    public void getLoggerFactoryReturnsCorrectlyFromSlf4JLoggerFactory() {
        ILoggerFactory expected = TestLoggerFactory.getInstance();
        assertThat(LoggerFactory.getILoggerFactory(), is(expected));
    }

    @Test
    public void requestedApiVersion() {
        assertEquals("1.6", StaticLoggerBinder.REQUESTED_API_VERSION);
    }
}
