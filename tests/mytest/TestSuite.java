package mytest;

import comp1110.ass2.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class combines tests from master repo and from tests written by Frederick Li.
 * @author Frederick Li
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AreConnectedNeighboursTest.class, GenerateDiceRollTest.class,
    GenerateMoveTest.class, GetAdvancedScoreTest.class, GetBasicScoreTest.class,
    IsBoardStringWellFormedTest.class, IsTilePlacementWellFormedTest.class,
    IsValidPlacementSequenceTest.class, CountExitsScoreTest.class,
    CountErrorsScoreTest.class, FindLongestRoadTest.class})
public class TestSuite {}
