# Solution to Platform - Assignment 2 by Ilya Zinkovich

Deep first search algorithm implementation for search of pawn route through all chequerboard cells. 

Notes:  
Graph model is chosen as the most natural way to represent any routes.  
Chequerboard cells are mapped to graph vertices and legitimate move from one cell to another 
is mapped to graph edge between vertices representing corresponding cells.  
Deep first search was chosen as an algorithm that allows to find all reachable vertices in a graph
from a given start vertex with ability to track path to them.  

Prerequisites:  
sbt installed

Execution steps:  
Execute run.sh script providing initial position on 10x10 chequerboard 
in format: "verticalPosition horizontalPosition"
both verticalPosition and horizontalPosition should be 0 based indexes in range (0, 10),
0 inclusive, 10 exclusive

Example: ./run.sh 3 5