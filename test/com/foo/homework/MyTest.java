package com.foo.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    public void testNode() {
        Assertions.assertNotNull(new Node(2));
    }
}
