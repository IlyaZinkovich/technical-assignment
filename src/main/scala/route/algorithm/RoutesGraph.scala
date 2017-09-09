package route.algorithm

import route.figure.Figure

class RoutesGraph(width: Int, height: Int, figure: Figure) extends RouteFindingAlgorithm {

  private val adjacencyMap: Map[(Int, Int), Set[(Int, Int)]] = {
    val vertices = for (x <- List.range(0, height); y <- List.range(0, width)) yield (x, y)
    vertices.map(fromVertex => fromVertex -> adjacentVertices(fromVertex, vertices)).toMap
  }

  private def adjacentVertices(fromVertex: (Int, Int), vertices: List[(Int, Int)]): Set[(Int, Int)] = {
    vertices.map(toVertex => (toVertex, figure.canMove(fromVertex, toVertex))).filter(_._2).map(_._1).toSet
  }

  override def findRoute(initialPosition: (Int, Int)): Seq[(Int, Int)] = {
    var path = List(initialPosition)

    def deepFirstSearch(position: (Int, Int)): List[(Int, Int)] = {
      adjacencyMap(position).filter(!path.contains(_))
        .foreach(nonVisitedChild => {
          path = nonVisitedChild :: path
          deepFirstSearch(nonVisitedChild)
          path = position :: path
        })
      path
    }

    deepFirstSearch(initialPosition).reverse
  }
}
