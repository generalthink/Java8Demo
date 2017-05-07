package com.generalthink.java8.chapter4;

import static java.util.stream.Collectors.*;

import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import com.generalthink.java8.Artist;

public class CollectorsUseTest {

   @Test
   public void toCollectionTest() {
      HashSet<Integer> hashSet = Stream.of(1,2,3,4).collect(
          toCollection(HashSet::new));
      Assert.assertTrue(4 == hashSet.size());
   }
   
   public void maxByTest() {
       Function<Artist, Long> count = artist -> artist.getMembers().count();
       
   }
   
}
