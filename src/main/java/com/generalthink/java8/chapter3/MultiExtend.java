package com.generalthink.java8.chapter3;

/**
  1. 类胜于接口。如果在继承链中有方法体或抽象的方法声明，那么就可以忽略接口中定义
的方法。
  2. 子类胜于父类。如果一个接口继承了另一个接口，且两个接口都定义了一个默认方法，
那么子类中定义的方法胜出。
  3. 没有规则三。如果上面两条规则不适用，子类要么需要实现该方法，要么将该方法声明
为抽象方法
 * @author TKing
 *
 */
public class MultiExtend implements Inter1,Inter2 {

    public MultiExtend() {
    }

    @Override
    public void show() {
        Inter1.super.show();
    }
}

interface Inter1 {
    public default void show() {
        System.out.println("inter1 show");
    }
}

interface Inter2 {
    public default void show() {
        System.out.println("inter2 show");
    }
}
