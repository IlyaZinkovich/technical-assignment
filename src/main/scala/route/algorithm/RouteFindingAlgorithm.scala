package route.algorithm

trait RouteFindingAlgorithm {

  def findRoute(initialPosition: (Int, Int)): Seq[(Int, Int)]
}
