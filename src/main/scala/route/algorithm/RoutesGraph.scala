package route.algorithm

import route.figure.Figure

/**
  * Graph based algorithm for figure routes search on a 10x10 chequerboard.
  * Chequerboard is split into four 5x5 partials.
  * Algorithm computes routes through each 5x5 partial and combines them together
  * into one cyclic route through the whole 10x10 chequerboard
  * that is rotated until it match initial figure position.
  *
  * @param figure figure for which the algorithm should find routes
  */
class RoutesGraph(figure: Figure) extends RouteFindingAlgorithm {

  private[this] lazy val partialHeight = 5
  private[this] lazy val partialWidth = 5

  private[this] lazy val adjacencyMap: Map[(Int, Int), Set[(Int, Int)]] = {
    val vertices = for (x <- List.range(0, partialHeight); y <- List.range(0, partialWidth)) yield (x, y)
    vertices.map(fromVertex => fromVertex -> adjacentVertices(fromVertex, vertices)).toMap
  }

  private[this] def adjacentVertices(fromVertex: (Int, Int), vertices: List[(Int, Int)]): Set[(Int, Int)] = {
    vertices.map(toVertex => (toVertex, figure.canMove(fromVertex, toVertex))).filter(_._2).map(_._1).toSet
  }

  private[this] lazy val fullPath = {
    val (inPartialPosition, outPartialPosition) = artificiallySelectedPartialInAndOut
    val partialPath = depthFirstSearch(inPartialPosition, outPartialPosition, List(inPartialPosition)).reverse
    val partialsCoordinatesWithRotationCount = List(((0, 0), 0), ((1, 0), 1), ((1, 1), 2), ((0, 1), 3))

    partialsCoordinatesWithRotationCount.flatMap(coordinateAndRotation => {
      rotatePathCoordinatesCounterClockwise(partialPath, coordinateAndRotation._2)
        .map(vertex => shiftToRealCoordinates(coordinateAndRotation._1, vertex))
    })
  }

  private def artificiallySelectedPartialInAndOut = {
    ((2, 3), (4, 0))
  }

  private[this] def depthFirstSearch(inPosition: (Int, Int),
                                     outPosition: (Int, Int),
                                     path: List[(Int, Int)]): List[(Int, Int)] = {
    val optionalPath = adjacencyMap(inPosition).filter(!path.contains(_))
      .map(nonVisitedChild => depthFirstSearch(nonVisitedChild, outPosition, nonVisitedChild :: path))
      .find(route => isCircularRoutePart(route, outPosition))

    optionalPath match {
      case Some(list) => list
      case None => if (isCircularRoutePart(path, outPosition)) path else Nil
    }
  }

  private[this] def rotatePathCoordinatesCounterClockwise(path: List[(Int, Int)], times: Int): List[(Int, Int)] = {
    if (times == 0) {
      return path
    }
    rotatePathCoordinatesCounterClockwise(path.map(vertex => (partialHeight - 1 - vertex._2, vertex._1)), times - 1)
  }

  private[this] def shiftToRealCoordinates(coordinates: (Int, Int), vertex: (Int, Int)) = {
    (vertex._1 + partialHeight * coordinates._1, vertex._2 + partialWidth * coordinates._2)
  }

  private[this] def isCircularRoutePart(route: List[(Int, Int)], outPosition: (Int, Int)) = {
    route.size == partialWidth * partialHeight && route.head == outPosition
  }

  override def findRoute(initialPosition: (Int, Int)): Seq[(Int, Int)] = {
    rotatePathUntilMatch(initialPosition, fullPath)
  }

  private[this] def rotatePathUntilMatch(position: (Int, Int), path: List[(Int, Int)]): List[(Int, Int)] = {
    if (path.head == position) {
      return path
    }
    rotatePathUntilMatch(position, path.tail :+ path.head)
  }
}
