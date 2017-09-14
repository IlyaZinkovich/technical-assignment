package route.algorithm

import route.figure.Figure

/**
  * Graph based algorithm using deep first search to find figure routes on a chequerboard.
  *
  * @see [[https://en.wikipedia.org/wiki/Depth-first_search]]
  *
  * @param width  chequerboard width
  * @param height chequerboard height
  * @param figure figure for which the algorithm should find routes
  */
class RoutesGraph(width: Int, height: Int, figure: Figure) extends RouteFindingAlgorithm {

  private val adjacencyMap: Map[(Int, Int), Set[(Int, Int)]] = {
    val vertices = for (x <- List.range(0, height); y <- List.range(0, width)) yield (x, y)
    vertices.map(fromVertex => fromVertex -> adjacentVertices(fromVertex, vertices)).toMap
  }

  private def adjacentVertices(fromVertex: (Int, Int), vertices: List[(Int, Int)]): Set[(Int, Int)] = {
    vertices.map(toVertex => (toVertex, figure.canMove(fromVertex, toVertex))).filter(_._2).map(_._1).toSet
  }

  override def findRoute(initialPosition: (Int, Int)): Seq[(Int, Int)] = {

    def deepFirstSearch(position: (Int, Int), path: List[(Int, Int)]): List[(Int, Int)] = {
      adjacencyMap(position).filter(!path.contains(_))
        .map(nonVisitedChild => deepFirstSearch(nonVisitedChild, nonVisitedChild :: path))
        .find(_.size == width * height).getOrElse(path)
    }

    deepFirstSearch(initialPosition, List(initialPosition)).reverse
  }
}
