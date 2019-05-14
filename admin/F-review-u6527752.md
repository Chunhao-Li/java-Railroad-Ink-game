Reviewer: Chunhao Li (u6527752)
Component: countExitsScore and helper methods for it
Author: Mingchao Sima (u6502811)

Review Comments:

1. The idea of splitting B2 tiles before finding routes is smart. HelperMethod.class: 124 - 129
2. Use HashSet to remove duplicates. HelperMethod.class: 137-138 
    (Although for connectedTiles, List also works).
3. Codes are appropriately documents and commented
4. Method decomposition is appropriate (replaceB2, getNeighbours, isB2Tile)
5. It follows Java code conventions (naming is appropriate and style is consistent)
6. Justifying whether route is still empty is better to understand. HelperMethod.class: 149-150 