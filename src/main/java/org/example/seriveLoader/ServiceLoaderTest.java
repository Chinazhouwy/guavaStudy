package org.example.seriveLoader;

import org.junit.Test;

import java.util.ServiceLoader;

public class ServiceLoaderTest {

    @Test
    public void test01(){
        ServiceLoader<interfaceClass> serviceLoader  = ServiceLoader.load(interfaceClass.class);
        for(interfaceClass service : serviceLoader) {
            System.out.println(service.say());
        }
    }

}
