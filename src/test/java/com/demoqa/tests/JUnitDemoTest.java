package com.demoqa.tests;

import org.junit.jupiter.api.*;

public class JUnitDemoTest {

    @BeforeAll
    static void setUp() {
        System.out.println("### @BeforeAll !");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("### @AfterAll !");
    }

    @BeforeEach
    void beforeEachTest() {
        // open("ya.ru");
        System.out.println("###    @BeforeEach !");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("###    @AfterEach !");
    }

    @Test
    void simpleTestZero() {
        System.out.println("###         @Test simpleTestZero() !");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void simpleTestOne() {
        System.out.println("###         @Test simpleTestOne() !");
        Assertions.assertTrue(3 > 2);
    }
}
