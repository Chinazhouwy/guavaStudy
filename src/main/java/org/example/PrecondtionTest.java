package org.example;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class PrecondtionTest {

    @Test
    public void test01(){
       Preconditions.checkNotNull("xxx","xxxx%s","123");
        assert "" != null : "水水水水";
    }

    @Test
    public void test02(){
        TestPerson personObj = new TestPerson("Abner Chai");
        String personName = null;
        assert (personName=personObj.getName())!=null;
        System.out.println(personName.length());
    }

    class TestPerson{
        private String name = null;
        public TestPerson(String name){
            this.name = name;
        }
        public void setName(String nameStr){
            this.name = nameStr;
        }
        public String getName(){
            return this.name;
        }
    }


}
