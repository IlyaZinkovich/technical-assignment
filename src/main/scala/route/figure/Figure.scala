package route.figure

abstract class Figure {

	def moves(): List[((Int, Int), (Int, Int)) => Boolean]
}
