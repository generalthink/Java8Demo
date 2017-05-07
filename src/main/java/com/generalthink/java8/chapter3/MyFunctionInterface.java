package com.generalthink.java8.chapter3;

/**
 * @FunctionalInterface只允许有一个抽象方法,如果大于一个并且还使用该注解,则编译报错
 * @author TKing
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface MyFunctionInterface<T,R> {
    
    public R get(T t);
    //public R show(T t);
    
    //允许添加一个默认方法,比如List中添加了一个stream方法,那么所有实现List接口的都需要实现stream方法，那么以前版本的怎么办呢？所以就有了这个默认方法
    //如果子类没有这个方法那么就调用父类的
    public default R getInfo(T t) {
        
        return null;
    }

}
