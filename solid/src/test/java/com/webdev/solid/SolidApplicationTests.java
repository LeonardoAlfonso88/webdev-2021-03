package com.webdev.solid;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SolidApplicationTests {

    @Test
    void contextLoads() {

        assertEquals("1234", "1234");
    }

    @Test
    void contextLoad2s() {

        assertEquals("1234", "4567");
    }

    @Test
    void contextLoads3() {

        assertEquals("1234", "4567");
    }

}
