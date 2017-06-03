package com.generalthink.java8.chapter4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.generalthink.java8.Album;
import com.generalthink.java8.Artist;

public class CollectorsUser {

    public CollectorsUser() {}

    /**
     * 找出成员最多的乐队
     * @param artists
     * @return
     */
    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        
        return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
    }

    /**
     * 将艺术家组成的流分成乐队和独唱歌手两部分
     * partitioningBy用于分组，如果为true返回的数据在一个list中，为false在一个list中
     * @param artists
     * @return
     */
    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(artist -> artist.isSolo()));
    }
    
    /**
     * 使用groupingBy对元素进行分组,哪些数据作为一组由Function决定
     * @param albums
     * @return
     */
    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(album -> album.getMainMusician()));
    }
    //使用流和收集器格式化艺术家姓名
    public String formatName(Stream<Artist> artists) {
        return artists.map(Artist::getName).collect(Collectors.joining(", ", "[", "]"));
             
    }
    /**
     * 使用收集器计算每个艺术家的专辑数
     * groupingBy 先将元素分成块，每块都与分类函数 getMainMusician 提供的键值相关联，然
后使用下游的另一个收集器收集每块中的元素，最好将结果映射为一个 Map,即groupingBy的第二个参数是将分块后的Value进行二次处理
     * @param albums
     * @return
     */
    public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(album -> album.getMainMusician(),
            Collectors.counting()));
    }
    /**
     * 使用收集器求每个艺术家的专辑名
     * @param albums
     * @return
     */
    public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(Collectors.groupingBy(Album::getMainMusician,
            Collectors.mapping(Album::getName, Collectors.toList())));
    }
    //将List(a,b,c,d)转换成'a','b','c','d'
    public List<String> formatNames(List<String> names) {
        return names.stream().map(name -> "'" + name + "'").collect(Collectors.toList());
    }
}
