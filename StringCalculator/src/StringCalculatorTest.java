import appl.StringCalculator;

import static org.junit.Assert.*;
package  appl;

public class StringCalculatorTest {

    @org.junit.Test
    public void Add() {
        appl.StringCalculator str = new StringCalculator("test");
        Assert.assertEquals(str.Add("test"), result + "test")
    }

    @org.junit.Test
    public void multiply() {
    }
}