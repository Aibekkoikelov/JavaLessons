package mycode.JavaRush;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

    @Test
    public void should_return_hello() {
        Solution2 s = new Solution2();
        assertEquals("hello", s.hello());
    }

}