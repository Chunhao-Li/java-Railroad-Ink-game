package MyTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;
import  static comp1110.ass2.HelperMethod.*;

public class TestCountErrorsScoreTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testNoErrors() {
        assertEquals(0, countErrorsScore("B1G12A0G02"));
        assertEquals(0, countErrorsScore("B0G12A0F16A1F03"));
    }

    @Test
    public void testDeadEnd() {
        assertEquals(-1, countErrorsScore("A5A10B2A01"));
        assertEquals(-2, countErrorsScore("A0B00A4A10"));

    }


}
