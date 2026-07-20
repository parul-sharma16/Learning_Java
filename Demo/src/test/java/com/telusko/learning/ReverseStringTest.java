package com.telusko.learning;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReverseStringTest {
    @Test
    void test() {
        ReverseString rs = new ReverseString();
        String actual = rs.reverseString("Parul");
        String expected = "luraP";
        assertEquals(expected, actual);
    }
}
