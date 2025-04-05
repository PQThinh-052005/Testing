package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVatCalculator {
    @Test
    public void testGetVatOnAmount() {
        VatCalculator calc = new VatCalculator();
        double expected = 10;
        Assert.assertEquals(calc.getVatOnAmount(100), expected);
        Assert.assertNotEquals(calc.getVatOnAmount(120), expected);
    }
}
