package com.generalthink.java8.chapter4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class ElementOrderTest {

    /**
     * 一个有序集合中创建一个流时，流中的元素就按出现顺序排列
     */
    @Test
    public void listOrderTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> sameOrder = numbers.stream()
        .collect(Collectors.toList());
        Assert.assertEquals(numbers, sameOrder);
    }
    
    /**
     * 如果集合本身就是无序的，由此生成的流也是无序的
     */
    @Test
    public void setOrderTest() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 3, 2, 1));
        List<Integer> sameOrder = numbers.stream()
        .collect(Collectors.toList());
        // 该断言有时会失败
        Assert.assertEquals(Arrays.asList(4, 3, 2, 1), sameOrder);
    }
    
    /**
     * 有些集合本身是无需的，但是sorted方法会产生顺序
     */
    @Test
    public void sortOrderTest() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(4, 3, 2, 1));
        List<Integer> sameOrder = numbers.stream().sorted()
        .collect(Collectors.toList());
        // 该断言有时会失败
        Assert.assertEquals(Arrays.asList(1,2,3,4), sameOrder);
    }
    
    
}
