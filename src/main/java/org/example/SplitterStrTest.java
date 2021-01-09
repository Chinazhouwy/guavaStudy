package org.example;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SplitterStrTest {

    @Test
    public void SplitterTest(){
        System.out.println(Splitter.on("|").splitToList("a|b|c"));
    }

    @Test
    public void Splitter_withnull_Test(){
        System.out.println(Splitter.on("|").splitToList("a|b|c||"));
        System.out.println(Splitter.on("|").omitEmptyStrings().splitToList("a | b|c||"));
        System.out.println(Splitter.on("|").trimResults().omitEmptyStrings().splitToList("a | b|c||"));
        System.out.println(Splitter.on(',').split("_a ,_b_ ,c__") );
        System.out.println(Splitter.on(',').trimResults().split("_a ,_b_ ,c__") );
        System.out.println(Splitter.on(',').trimResults(CharMatcher.is('_')).split("_a ,_b_ ,c__") );
        System.out.println(Splitter.on(',').trimResults(CharMatcher.is('_')).split("_a ,_b_,c__") );
    }

    @Test
    public void Splitter_FixLength_Test(){
        List<String> results = Splitter.fixedLength(4).splitToList("aaaabbbccccdddd");
        System.out.println(results);
    }

    @Test
    public void Splitter_limit_Test(){
        List<String> results = Splitter.on("#").limit(2).splitToList("1#2#3#4#5#");
        System.out.println(results);
    }

    @Test
    public void Splitter_Pattern_Test(){
        List<String> results = Splitter.onPattern("\\|").trimResults().omitEmptyStrings().splitToList(" a | b | c ||");
        System.out.println(results);
    }

    @Test
    public void Splitter_Pattern_Map_Test(){
        Map<String,String> results = Splitter.onPattern("\\|")
                .trimResults()
                .omitEmptyStrings()
                .withKeyValueSeparator("=")
                .split(" a=1 | b=2 | c=3 ||");
        System.out.println(results);
    }
}
