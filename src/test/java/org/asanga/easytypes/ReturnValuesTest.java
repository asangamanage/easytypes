package org.asanga.easytypes;

import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReturnValuesTest {
    @Test
    public void testCreateSSuccessReturnValue_just_msg() throws Exception {
        Map successReturnValue = ReturnValues.ssuccess("OK");
        assertTrue(ReturnValues.isSuccess(successReturnValue));
        assertTrue(successReturnValue.get(ReturnValues.MESSAGE).equals("OK"));
    }

    @Test
    public void testCreateSuccessReturnValue() throws Exception {
        Map successReturnValue = ReturnValues.success("OK", "CLIENT", "CLIENT_OBJ", "SESSION", "SESSION_OBJ");
        assertTrue(ReturnValues.isSuccess(successReturnValue));
        assertTrue(successReturnValue.get(ReturnValues.MESSAGE).equals("OK"));
    }

    @Test
    public void testCreateSSuccessReturnValue() throws Exception {
        Map successReturnValue = ReturnValues.ssuccess("CLIENT", "CLIENT_OBJ", "SESSION", "SESSION_OBJ");
        assertTrue(ReturnValues.isSuccess(successReturnValue));
    }

    @Test
    public void testCreateShortSuccessWithoutMsg() throws Exception {
        Map successReturnValue = ReturnValues.ssuccess();
        assertTrue(ReturnValues.isSuccess(successReturnValue));
    }

    @Test
    public void testCreateSuccessReturnValue_one_arg() throws Exception {
        Map successReturnValue = ReturnValues.success("OK", "SESSION_OBJ");
        assertTrue(ReturnValues.isSuccess(successReturnValue));
        assertTrue(successReturnValue.get(ReturnValues.DATA).equals("SESSION_OBJ"));
        assertTrue(successReturnValue.get(ReturnValues.MESSAGE).equals("OK"));
    }

    @Test
    public void testCreateSuccessReturnValue_one_arg_without_msg() throws Exception {
        Map successReturnValue = ReturnValues.success("SESSION_OBJ");
        assertTrue(ReturnValues.isSuccess(successReturnValue));
        assertTrue(successReturnValue.get(ReturnValues.DATA).equals("SESSION_OBJ"));
    }
    @Test
    public void testCreateFailedReturnValue() throws Exception {
        Map successReturnValue = ReturnValues.failed("NOT OK", "CLIENT", "CLIENT_OBJ", "SESSION", "SESSION_OBJ");
        assertFalse(ReturnValues.isSuccess(successReturnValue));
        assertTrue(successReturnValue.get(ReturnValues.MESSAGE).equals("NOT OK"));
    }

    @Test
    public void testCreateSFailedReturnValue() throws Exception {
        Map successReturnValue = ReturnValues.sfailed("CLIENT", "CLIENT_OBJ", "SESSION", "SESSION_OBJ");
        assertFalse(ReturnValues.isSuccess(successReturnValue));
        assertTrue(successReturnValue.get("CLIENT").equals("CLIENT_OBJ"));
        assertTrue(successReturnValue.get("SESSION").equals("SESSION_OBJ"));
    }

    @Test
    public void testCreateSFailedReturnValue_just_msg() throws Exception {
        Map successReturnValue = ReturnValues.sfailed("NOT OK");
        assertFalse(ReturnValues.isSuccess(successReturnValue));
        assertTrue(successReturnValue.get(ReturnValues.MESSAGE).equals("NOT OK"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSuccessReturnValue_odd_no_params() throws Exception {
        ReturnValues.success("OK", "CLIENT", "CLIENT_OBJ", "SESSION");
    }
}