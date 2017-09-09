package route.figure

abstract class Figure {

	def canMove(fromVertex: (Int, Int), toVertex: (Int, Int)): Boolean
}
