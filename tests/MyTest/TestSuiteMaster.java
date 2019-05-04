package MyTest;

import comp1110.ass2.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AreConnectedNeighboursTest.class, GenerateDiceRollTest.class,
    GenerateMoveTest.class, GetAdvancedScoreTest.class, GetBasicScoreTest.class,
    IsBoardStringWellFormedTest.class, IsTilePlacementWellFormedTest.class,
    IsValidPlacementSequenceTest.class})
public class TestSuiteMaster {

}
