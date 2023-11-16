package com.neonexsoft.vclstest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Yun Yeji
 * @fileName : DbTests
 * @description
 * @since : 2023-11-16
 */


public class DbTests {


    @Test
    public void getData(){
        double a = 1.1;
        double b = 2.2;
        double c = 3.3;
        Assertions.assertEquals(a+b, c);

    }

}
