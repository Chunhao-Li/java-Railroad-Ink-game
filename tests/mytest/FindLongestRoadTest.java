package mytest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;
import static comp1110.ass2.RailroadInk.*;

public class FindLongestRoadTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testRailwayRoadOneOption() {
        String[] test1 = {"A2F01","A0F10","B0E10"};
        assertEquals(3, findLongestRoad(test1, 'r'));
        String[] test2 = {"A2B01","A2B13","B1B22","A0C01","B0C11"};
        assertEquals(5, findLongestRoad(test2, 'r'));
    }

    @Test
    public void testHighwayRoadOneOption() {
        String[] test1 = {"A3A10","A5A23","A4B20","B1C20","S3C30"};
        assertEquals(4, findLongestRoad(test1, 'h'));
        String[] test2 = {"A3G10","A5D00","A0A30","B1F12","A5G20","A5F22","B0F37",
                "A3C01","A1F01","B2C11"};
        assertEquals(5, findLongestRoad(test2, 'h'));
    }

    static final String[] fullGame1 = {"A3A10","A5B11","S0B20","B0C22","A5B33",
            "A1G30","B0C30","A5A23","A5D20","A0D31","S4D41","B2E41","A0F40",
            "A1B61","B0B53","A3B40","A4C40","A2F30","S1E31","A3D52", "A3E52",
            "A4F50","B1D11","A4G50","A1E21","A1E10","B2F11","B0G12", "A3F21",
            "A3G20","A0B00"};

    static final String[] fullGame2 = {"A1A30","A1G30","B2F31","A3F42","A2E32",
            "A1D30","B2E20","A5F21","A4D20","A2E10","A5G41","B2C20","S3C30",
            "A3G52","B2B20","A1D10","S1B31","A4E40","A1B11","S5B00","A4D40",
            "B0B43","A3A22","A0C12","B1C42","A2B53","A3F50","A3E50","A0B60",
            "A0A52","B1F63"};

    @Test
    public void testRailwayRoadMultiOptions() {
        assertEquals(8, findLongestRoad(fullGame1, 'r'));
        assertEquals(13,findLongestRoad(fullGame2,'r') );
    }

    @Test
    public void testHighwayRoadMultiOptions() {
        assertEquals(8, findLongestRoad(fullGame1, 'h'));
        assertEquals(12, findLongestRoad(fullGame2, 'h'));
    }
}
