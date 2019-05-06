package mytest;

import  static comp1110.ass2.HelperMethod.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

public class CountExitsScoreTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testOneRoute() {
        assertEquals(0, countExitsScore("A1A30A0B31S1B40B0B51"));
        assertEquals(4, countExitsScore("A1A30A0B31S1B40B0B51A4A40S3C40A0D44B0D51A4D61") );
        assertEquals(0, countExitsScore("A2A30"));

    }

    @Test
    public void testMultipleRoutes() {
        assertEquals(4, countExitsScore("B2B00A3A10A2F01A3A21A5C01A1G30B0F30A0F10B2B10A1E10A5C10S4D00A0D13"));
        assertEquals(12, countExitsScore("B2G10A0F61A2E60A5A57B2F10A2D64A2C60A4A41S1B63B2E10A0D51A0C53A3A31A2G30A2F30B2D10A4B30A3C30B2C10A2C40A5D31B2B10S4D46A2B40A3G50A5F56B2A10A3A20A3B20A3C20"));

    }
}
