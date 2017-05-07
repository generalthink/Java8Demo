package com.generalthink.java8.chapter3;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.generalthink.java8.Album;
import com.generalthink.java8.Track;

public class ClassLibaryUseTest {

    private ClassLibaryUse clu;
    
    @Before
    public void init() {
        clu = new ClassLibaryUse();
    }
    //还有对应的LongSummaryStatistics,DoubleSummaryStatistics
    @Test
    public void getTrackStatisticsTest() {
        Album album = new Album();
        Track t1 = new Track("小苹果", 221);
        Track t2 = new Track("平凡之路", 189);
        Track t3 = new Track("天亮了", 247);
        album.setTracks(Stream.of(t1,t2,t3).collect(Collectors.toList()));
        
        IntSummaryStatistics intStatistics = clu.getTrackStatistics(album);
        
        Assert.assertTrue(intStatistics.getSum() == 657);
        Assert.assertTrue(intStatistics.getMax() == 247);
        Assert.assertTrue(intStatistics.getMin() == 189);
        Assert.assertTrue(intStatistics.getAverage() == 219);
    }
    
}
