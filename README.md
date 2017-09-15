# Solution to Platform - Assignment 2 by Ilya Zinkovich

Graph-based search algorithm implementation for search of pawn route through all chequerboard cells. 

Notes:  
Graph model is chosen as the most natural way to represent any routes.  
Chequerboard is split into four 5x5 partials which cells are mapped 
to graph vertices and legitimate move from one cell to another 
is mapped to graph edge between vertices representing corresponding cells.  
Algorithm computes routes through each 5x5 partial and combines them together
into one cyclic route through the whole 10x10 chequerboard 
that is rotated until it match initial figure position.  

The following table shows a chequerboard with selected up-left partial (with dashes) 
and "in" and "out" cell of each partial path.


| - | - | - | - | - | out |   |   |   |   |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| - | - | - | - | - |   |   |   |   |   |
| - | - | - | in | - |   |   |   |   |   |
| - | - | - | - | - |   |   | in |   |   |
| out | - | - | - | - |   |   |   |   |   |
|   |   |   |   |   |   |   |   |   | out |
|   |   | in |   |   |   |   |   |   |   |
|   |   |   |   |   |   | in |   |   |   |
|   |   |   |   |   |   |   |   |   |   |
|   |   |   |   | out |   |   |   |   |   |

Prerequisites:  
sbt installed

Execution steps:  
Execute run.sh script providing initial position on 10x10 chequerboard 
in format: "verticalPosition horizontalPosition"
both verticalPosition and horizontalPosition should be 0 based indexes in range (0, 10),
0 inclusive, 10 exclusive

Example: ./run.sh 3 5