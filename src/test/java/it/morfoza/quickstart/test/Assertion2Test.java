package it.morfoza.quickstart.test;

;
import org.assertj.neo4j.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Anna Kacprzak on 2016-08-12.
 */
public class Assertion2Test {
//    @Test
//    public  void should (){
//      double   a =12.7;
//        double b= 30.6;
//        Assert.assertEquals(a , b);
//    }

//    public void should2 () {
//        double c = 2.5;
//        double d =  5.5;
//        Assert.assertNotEquals(c, d );
//    }
    @Test
            public void testWithAssterJ() {

        String a = "1111.112333333aaaa";
//        Assertions.assertThat(a).containsOnlyDigits();
//        assertThat(a).doesNotStartWith("1111");
        List<String> stringi = new ArrayList<>();
        stringi.add("aaaa");
        assertThat(stringi).contains("aaaa");
    }

}
