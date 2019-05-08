package mytest;

import comp1110.ass2.RailroadInk;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class GenerateDiceRollTestBob {

    private static int BASE_ITERATIONS = 1000;

    @Rule
    public Timeout globalTimeout = Timeout.millis(200);

    @Test
    public void testLength() {
        for (int i = 0; i < BASE_ITERATIONS; i++) {
            int numRolls = RailroadInk.generateDiceRoll().length() >>> 1;
            assertFalse("Expected a string of eight charactors, but got rolled: " + numRolls, numRolls != 4);
        }
    }

    @Test
    public void testIsRandomFace() {
        int cnt[] = new int[4];
        for (int i = 0; i < BASE_ITERATIONS; i++) {
            String roll = RailroadInk.generateDiceRoll();
            if (roll.charAt(0) == 'B') {
                cnt[0]++;
            } else if (roll.charAt(2) == 'B') {
                cnt[1]++;
            } else if (roll.charAt(4) == 'B') {
                cnt[2]++;
            } else { // roll. charAr(6)=="B"
                cnt[3]++;
            }
        }
        assertFalse("never find B tile in position 0 of rolled result", cnt[0] != 0);
        assertFalse("never find B tile in position 2 of rolled result", cnt[1] != 0);
        assertFalse("never find B tile in position 4 of rolled result", cnt[2] != 0);
        assertFalse("never find B tile in position 6 of rolled result", cnt[3] != 0);
    }
}
