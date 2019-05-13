Reviewer: Mingchao Sima (u6502811)
Component: task 5: areConnectedNeighbours
Author: Haoyan Liu (u6720989) and Chunhao Li (u6527752)

Review Comments:

1. Considering each tile as a String shape(use getShape method) and judging whether the connected 
   directions of two tiles is the same is a efficient way.
2. Codes are well-documented and use “if” keyword to handle the different situations which are the
   StringA is at the left, right, top, or bottom of the StringB.
3. The program decomposition is appropriate. The getShape method is also appropriate.
4. Variables contain tilePlacement and orientation which are a char array of tile placement which 
   contains 5 elements and a char which is in the range '0'-'7' respectively and the name of method 
   getShape means that this method can get the shape of tilePlacement with a given orientation.
5. I do not find any error in task 5 and the method getShape.