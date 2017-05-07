package com.generalthink.java8.chapter3;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class OptionalUseTest {

    @Test
    public void howToOptional() {
        Optional<String> opt = Optional.of("abc");
        Assert.assertSame("abc", opt.get());
    }
    @Test
    public void isEmptyTest() {
        Optional<Integer> opt = Optional.ofNullable(null);
        Assert.assertTrue(false == opt.isPresent());
    }
    @Test
    public void orGetTest() {
        Optional<Integer> opt = Optional.ofNullable(null);
        Assert.assertTrue(2 == opt.orElse(2));
        Assert.assertTrue(5 == opt.orElseGet(() -> 5));
    }
    
}
