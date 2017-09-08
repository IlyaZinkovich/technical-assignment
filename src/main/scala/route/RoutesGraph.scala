package route

import route.figure.Figure

class RoutesGraph(width: Int, height: Int, figure: Figure) {

	val adjacencyMap: Map[(Int, Int), Set[(Int, Int)]] = {
		Map((0, 0) -> Set((0, 3)))
		figure.moves()
	}
}
