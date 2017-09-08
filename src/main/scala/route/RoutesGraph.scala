package route

import route.figure.Figure

class RoutesGraph(width: Int, height: Int, figure: Figure) {

	private val adjacencyMap: Map[(Int, Int), Set[(Int, Int)]] = {
		val vertices = for(x <- List.range(0, height); y <- List.range(0, width)) yield (x, y)
		vertices.map(fromVertex => fromVertex -> adjacentVertices(vertices, fromVertex)).toMap
	}

	private def adjacentVertices(vertices: List[(Int, Int)], fromVertex: (Int, Int)) = {
		vertices.map(toVertex => (toVertex, canMove(fromVertex, toVertex))).filter(_._2).map(_._1).toSet
	}

	private def canMove(fromVertex: (Int, Int), toVertex: (Int, Int)) = {
		figure.moves().map(move => move.apply(fromVertex, toVertex)).reduce(_ | _)
	}

	def route(initialPosition: (Int, Int)): Seq[(Int, Int)] = {
		List()
	}
}
