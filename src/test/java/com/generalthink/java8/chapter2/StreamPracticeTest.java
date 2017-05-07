package com.generalthink.java8.chapter2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.generalthink.java8.Album;
import com.generalthink.java8.Artist;
import com.generalthink.java8.chapter2.StreamPractice;

/**
 * 
 * @author TKing
 * 流的使用
 */
public class StreamPracticeTest {
    
    @Test
    public void addUpTest() {
        StreamPractice sp = new StreamPractice();
        int sum = sp.addUp(Stream.of(1,2,3,4,5));
        assertTrue(sum == 15);
    }
    
    @Test
    public void getArtistInfoTest() {
        List<Artist> list = new ArrayList<>();
        Artist a1 = new Artist();
        a1.setName("Adell");
        a1.setOrigin("American");
        
        Artist a2 = new Artist();
        a2.setName("zhansan");
        a2.setOrigin("Chain");
        
        Artist a3 = new Artist();
        a3.setName("Mark");
        a3.setOrigin("English");
        
        list.add(a1);
        list.add(a2);
        list.add(a3);
        
        StreamPractice sp = new StreamPractice();
        System.out.println(sp.getArtistInfo(list));
    }
    
    @Test
    public void getTotalMembersTest() {
        Artist a1 = new Artist();
        List<String> members = new ArrayList<String>();
        members.add("zhangsan");
        members.add("zhangsan2");
        members.add("zhangsan3");
        a1.setMembers(members);
        
        Artist a2 = new Artist();
        List<String> members2 = new ArrayList<String>();
        members2.add("lisi");
        members2.add("lisi2");
        a2.setMembers(members2);
        
        List<Artist> artists = new ArrayList<Artist>();
        artists.add(a2);
        artists.add(a1);
        
        StreamPractice sp = new StreamPractice();
        assertTrue(sp.getTotalMembers(artists) == 5);
        
    }
    
    @Test
    public void atomicTest() {
        AtomicInteger ai = new AtomicInteger();
        Album album = new Album();
        Artist a1 = new Artist();
        Artist a2 = new Artist();
        Artist a3 = new Artist();
        album.setMusicians(Stream.of(a1,a2,a3).collect(Collectors.toList()));
        
       album.getMusicians().stream().forEach(artist -> ai.getAndIncrement());
       assertTrue(3 == ai.getAndIncrement());; 
    }
    
    @Test
    public void getLowerCharCountTest() {
        String testStr = "AbcDefg";
        assertTrue(5L == StreamPractice.getLowerCharCount(testStr));
    }
    
    @Test
    public void getMaxLowerCharStringTest() {
       Optional<String> optStr = Stream.of("abcd","ade","afg").max(Comparator.comparing(StreamPractice::getLowerCharCount));
       System.out.println(optStr.get());
    }
}
