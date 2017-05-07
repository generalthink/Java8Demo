package com.generalthink.java8;

//专辑中的一支曲目
public class Track {

    private String name;//曲目名称
    
    private Integer length;//曲目耗时多少秒
    
    public Track(String name, Integer length) {
        super();
        this.name = name;
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
