package com.generalthink.java8;

import java.util.stream.Stream;

//创作音乐的个人或团队
public class Artist {

    private String name;//艺术家名字
    
    private Stream<String> members;//乐队成员
    
    private String origin;//来自哪里
    
    @SuppressWarnings("unused")
    private Boolean isSolo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stream<String> getMembers() {
        return members;
    }

    public void setMembers(Stream<String> members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Boolean isSolo() {
        if(null != members) {
            if(members.count() > 1) {
                return false;
            }
        }
        return true;
    }
    
}
