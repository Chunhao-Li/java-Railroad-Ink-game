package mytest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.List;

import static comp1110.ass2.HelperMethod.getOrientations;
import static org.junit.Assert.assertTrue;

/**
 * Test orientations: test if the length and the content match the expect
 * @author Mingchao Sima(u6502811)
 */

public class GetOrientationsTest {

    String[] one = {"B1"};
    String[] two = {"A1","A4","B2"};
    String[] three = {"A0","A2","A3","A5","B0","S0","S1","S2","S3","S4","S5"};

    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testIsLengthCorrect(){

        for (String tile:two) {
            List<Character> result = getOrientations(tile);
            assertTrue("Expected 2 members but got " + result.size(), result.size() == 2);
        }
        for (String tile:one) {
            List<Character> result = getOrientations(tile);
            assertTrue("Expected 8 members but got " + result.size(), result.size() == 8);
        }
        for (String tile:three) {
            List<Character> result = getOrientations(tile);
            assertTrue("Expected 4 members but got " + result.size(), result.size() == 4);
        }
    }

    @Test
    public void testIsTotallyMatch(){
        List<Character> expect = new ArrayList<>();
        expect.add('0');
        expect.add('1');
        for (String tile:two) {
            List<Character> result = getOrientations(tile);
            assertTrue("Out put in not exact match of expected result", result.equals(expect));
        }
        expect.add('2');
        expect.add('3');
        for (String tile:three) {
            List<Character> result = getOrientations(tile);
            assertTrue("Out put in not exact match of expected result", result.equals(expect));
        }
        expect.add('4');
        expect.add('5');
        expect.add('6');
        expect.add('7');
        for (String tile:one) {
            List<Character> result = getOrientations(tile);
            assertTrue("Out put in not exact match of expected result", result.equals(expect));
        }

    }

}
