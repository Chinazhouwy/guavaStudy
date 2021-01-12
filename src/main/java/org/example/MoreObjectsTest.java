package org.example;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import org.junit.Test;

import java.util.Objects;

public class MoreObjectsTest {

    @Test
    public void test01(){
        System.out.println(MoreObjects.toStringHelper(this).omitNullValues().add("first", "value1").add("second", false));
    }

    @Test
    public void test02(){
        System.out.println(Objects.hash("1231451"));
    }

    @Test
    public void test03(){
        System.out.println(ComparisonChain.start().compare(1,2).compare("1","3").result());
    }

}
