package org.example;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import org.junit.Test;

public class StringsTest {

    @Test
    public void StringsTest01(){
        System.out.println(Strings.emptyToNull(null));
        System.out.println(Strings.emptyToNull(""));
        System.out.println(Strings.emptyToNull("1214"));
    }

    @Test
    public void StringsTest02_commPrefix(){
        System.out.println(Strings.commonPrefix("abcd","aec"));
        System.out.println(Strings.commonSuffix("abcd","eabcd"));
        System.out.println(Strings.repeat("abcd",3));
    }

    @Test
    public void StringsTest02Charars(){
        System.out.println(CharMatcher.javaDigit().matches('5'));
        System.out.println(CharMatcher.is('A').countIn("A b c d"));
        System.out.println(CharMatcher.breakingWhitespace().collapseFrom(" asd   dad ", '$'));
        System.out.println(CharMatcher.javaDigit().or(CharMatcher.whitespace()).removeFrom(" hello sss  "));
        System.out.println(CharMatcher.javaDigit().or(CharMatcher.whitespace()).retainFrom(" hello 123 sss  "));
    }

}
