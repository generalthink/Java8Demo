package com.generalthink.java8.chapter2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {

    @Test
    public void streamUseTest() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(3L, list.stream().filter(num -> num > 2).count());
        
        //没有任何输出
        list.stream().filter(num -> {
            System.out.println("num : " + num);
            return num > 2;
        });
        //输出num = 1,2,3,4,5
        list.stream().filter(num -> {
            System.out.println("num = " + num);
            return num > 2;
        }).count();
        
     /*   
      * 因为filter只是刻画了stream,并没有产生新的集合,这种不产生新集合的方法叫做惰性求值方法
   
                        像 count这样最终会从 Stream 产生值的方法叫作及早求值方法。
                        
                        判断一个操作是惰性求值还是及早求值很简单：只需看它的返回值。如果返回值是 Stream ，
                        那么是惰性求值；如果返回值是另一个值或为空，那么就是及早求值
                     
        */
    }

    @Test
    public void collectTest() {
       //collect(toList()) 方法由 Stream 里的值生成一个列表，是一个及早求值操作。
       List<String> list = Stream.of("a","b","c").collect(Collectors.toList());
       assertEquals(Arrays.asList("a","b","c"), list);
    }
    
    //和jquery的map方法类似,jquery中的map方法用于数组的每个元素调用定义的回调函数并返回包含结果的数组
    /*
     * // Define the callback function.
        function AreaOfCircle(radius) {
            var area = Math.PI * (radius * radius);
            return area.toFixed(0);
        }
        
        // Create an array.
        var radii = [10, 20, 30];
        
        // Get the areas from the radii.
        var areas = radii.map(AreaOfCircle);
        
        document.write(areas);
        
        // Output:
        // 314,1257,2827
     * 
     */
    @Test
    public void mapTest() {
       //map操作就是将一个流中的值转换成一个新的流
       List<String> list =  Stream.of("a","b","c")
               .map(string -> string.toUpperCase()).collect(Collectors.toList());
       
       assertEquals(Arrays.asList("A","B","C"), list);
    }
    //filter方法用于数据过滤,接收一个Predicate接口
    @Test
    public void filterTest() {
       List<String> list = Stream.of("a","2b","3c")
               .filter(str -> !Character.isDigit(str.charAt(0))).collect(Collectors.toList());
       assertEquals(Arrays.asList("a"), list);
    }
    
    //flatMap 方法可用 Stream 替换值，然后将多个 Stream 连接成一个 Stream
    @Test
    public void flatMapTest() {
        List<Integer> list = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(1,2,3,4), list);
    }
    
    @Test
    public void minTest() {
       List<Person> personList = Arrays.asList(new Person("xiaoming", 22),new Person("xiaohong", 23));
       Person minAgePerson = personList.stream().
               min(Comparator.comparing(person -> person.getAge())).get();
      assertTrue(22 == minAgePerson.getAge());
    }
    
    @Test
    public void maxTest() {
       List<Person> personList = Arrays.asList(new Person("xiaoming", 22),new Person("xiaohong", 23));
       Person maxAgePerson = personList.stream().
               max(Comparator.comparing(person -> person.getAge())).get();
       assertTrue(23 == maxAgePerson.getAge());
    }
    
    @Test
    public void reduceTest() {
        Optional<Integer> sum = Stream.of(2,3,5).reduce((x,y) -> x+y); 
        assertTrue(sum.get() == 10);
    }
    
    @Test
    public void accultorTest() {
        BinaryOperator<Integer> operator = (x,y) -> x*y;
        int result = operator.apply(operator.apply(operator.apply(1, 2),3), 4);
        assertTrue(result == 24);
    }
}
