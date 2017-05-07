package com.generalthink.java8.chapter1;

import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

public class LambdaExpressionTest {

    //如何书写Lambda表达式
    @Test
    public void howToLambda() {
       //相当于写了一个匿名函数
       Runnable runnable = () -> System.out.println("runnable with Lambda");
       new Thread(runnable).start();
       new Thread(()->System.out.println("new runnable")).start();
       
       //这里的word是参数名称,可以指定类型,返回值为最后一条语句
      MethodInterface oneMethod = (String word) -> "say : " + word;
      System.out.println(oneMethod.saySomething("hello"));
      assertTrue("say : hello".equals(oneMethod.saySomething("hello")));
      
      oneMethod = word -> "say : " + word;
      
      assertTrue("say : GoodBye".equals(oneMethod.saySomething("GoodBye")));
      
      //多条语句和普通方法规则一致
      MethodInterface multiStatement = word -> {
          if(word.startsWith("hello")) {
              return "nice to meet you ";
          }
          return word;
      };
      assertTrue("nice to meet you ".equals(multiStatement.saySomething("hello")));
    }
    
    //是否使用final
    @Test
    public void useFinalOrNot() {
        String name = "张三";
        ////这里的name其实已经是既定事实的final变量,如果试图该表name的值比如加上name="李四",编译器会报错
        new Thread(() -> System.out.println(name)).start();
        //说明不加上final关键字,但是实际上也是final了
    }
    
    //类型推断
    @SuppressWarnings({"rawtypes", "unused"})
    @Test
    public void typeInference() {
        Predicate<Integer> atLeast = x -> x > 5;
        assertTrue(atLeast.test(6));
        
        Predicate noType = x -> x.equals(5);
        
        //下面的代码编译报错,因为noType没有声明类型,编译器默认认为参数类型以及返回类型为Object
        //noType = x -> x > 5;
    }
    
}
