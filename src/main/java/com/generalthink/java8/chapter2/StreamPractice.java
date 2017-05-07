package com.generalthink.java8.chapter2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.generalthink.java8.Album;
import com.generalthink.java8.Artist;

public class StreamPractice {

    public StreamPractice() {
    }
    
    //编写一个求和函数，计算流中所有数之和。例如， int addUp(Stream<Integer> numbers) ；
    public int addUp(Stream<Integer> numbers) {
        return numbers.reduce((x,y) -> x+y).get(); 
    }
    //编写一个函数，接受艺术家列表作为参数，返回一个字符串列表，其中包含艺术家的姓名和国籍
    public List<String> getArtistInfo(List<Artist> artists) {
        //map形成一个新的流之后,将其转换为list进行输出
       
        //List<String> result =  artists.stream().map(artist -> (artist.getName() + ":" + artist.getOrigin())).collect(Collectors.toList());
        
        List<String> result =  artists.stream().flatMap(artist -> Stream.of(artist.getName(),artist.getOrigin())).collect(Collectors.toList());
        
        return result;
    }
    
    //编写一个函数，接受专辑列表作为参数，返回一个由最多包含 3 首歌曲的专辑组成的列表
    public List<Album> getMoreThanThreeAlbum(List<Album> albumList) {
     
        return albumList.stream().filter(album -> album.getTracks().size() <= 3).collect(Collectors.toList());
        
    }

    /**
     * 修改如下代码，将外部迭代转换成内部迭代：
        int totalMembers = 0;
        for (Artist artist : artists) {
        Stream<Artist> members = artist.getMembers();
        totalMembers += members.count();
        }
     */
    public int getTotalMembers(List<Artist> artists) {
        //Long::sum表示调用Long.sum的静态方法
        return artists.stream().map(artist -> artist.getMembers().stream().count()).reduce(0L, Long::sum).intValue();
        //return artists.stream().flatMapToInt(artist -> IntStream.of(artist.getMembers().size())).sum();
    }
    
    public static long getLowerCharCount(String testStr) {
        return testStr.chars().filter(c -> Character.isLowerCase(c)).count();
    }
    
}
