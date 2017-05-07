package com.generalthink.java8.chapter3;

import java.util.IntSummaryStatistics;

import com.generalthink.java8.Album;

/**
 * 类库的使用
 * 
 * @author TKing
 *
 */
public class ClassLibaryUse {

    public ClassLibaryUse() {}

    //返回的是关于曲目长度的统计对象,该对象可以对流中的值进行统计
    public IntSummaryStatistics getTrackStatistics(Album album) {
        return album.getTracks().stream().mapToInt(
            track -> track.getLength()).summaryStatistics();
    }

}
