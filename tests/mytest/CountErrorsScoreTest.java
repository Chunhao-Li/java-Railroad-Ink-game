package mytest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;
import  static comp1110.ass2.RailroadInk.*;

/**
 * Test errors: Errors are the edges of routes
 *      that are not connected to an edge of the board
 * - DO NOT count as errors:
 *      Routes that end at the edge of the board (whether on an exit or not)
 *      Exits that are not connected to a route
 */
public class CountErrorsScoreTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testNoErrors() {
        assertEquals(0, countErrorsScore("B1G12A0G02"));
        assertEquals(0, countErrorsScore("B0G12A0F16A1F03"));
    }

    @Test
    public void testMultipleErrors() {
        assertEquals(-1, countErrorsScore("A5A10B2A01"));
        assertEquals(-2, countErrorsScore("A0B00A4A10"));
        assertEquals(-5, countErrorsScore("A0B00A5A14A4A25S4A33B2B30A1A00A5C30A5C25B0D20A0B43A3G10B0F12A2E10A0E20B1D17A4D01A5G20A1C40A1D40B2E41S5E51A5F22A5E32S0F30A2G30B2F41A4E63B1D51A4D61A1G40A4F51"));

    }


}
