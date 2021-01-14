package org.example;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class StopWatchTest {

    @Test
    public void stopWatchTest_01(){
        Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println(stopwatch.toString());
        System.out.println(stopwatch.stop().elapsed(TimeUnit.NANOSECONDS));
    }

}
