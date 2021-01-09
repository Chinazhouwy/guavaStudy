package org.example;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JoinStrTest {

    private List<String> stringList = Arrays.asList("a", "b", "c", "d");

    private List<String> stringWithNullList = Arrays.asList("a", "b", "c",null,"d");

    private Map<String,String> map = ImmutableMap.of("a","1","b","2");

    @Test
    public void JoinTest(){
        System.out.println(Joiner.on("$").join(stringList));
        System.out.println(Joiner.on("$").skipNulls().join(stringWithNullList));
        System.out.println(Joiner.on("$").useForNull("DEFAULT").join(stringWithNullList));
    }

    @Test
    public void Join_with_stringBuilder_Test(){
        final StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = Joiner.on("$").useForNull("DEFAULT").appendTo(stringBuilder,stringWithNullList);
        System.out.println(stringBuilder1 == stringBuilder);
    }

    @Test
    public void Join_with_writer_Test(){
        try(FileWriter fileWriter = new FileWriter(new File("test.txt"))){
            Joiner.on("$").useForNull("DEFAULT").appendTo(fileWriter,stringWithNullList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void Join_with_stream_Test(){
        StringJoiner stringJoiner = new StringJoiner("$","","");
        stringWithNullList.stream().forEach(stringJoiner::add);
        System.out.println(stringJoiner);
    }

    @Test
    public void Join_with_stream_withDEfalut_Test(){
        StringJoiner stringJoiner = new StringJoiner("$","","");
        stringWithNullList.stream().map(e->e=(e==null?"DEFAULT":e)).forEach(stringJoiner::add);
        System.out.println(stringJoiner);
    }

    @Test
    public void Join_with_stream_withDEfalut_filter_Test(){
        System.out.println(stringWithNullList.stream().filter(e -> e != null).collect(Collectors.joining("$")));
    }

    @Test
    public void Join_with_stream_withKeyValue_Test(){
        System.out.println(Joiner.on("$").useForNull("DEFAULT").withKeyValueSeparator("=").join(map));
    }

}
