package route.algorithm

/**
  * Interface to all algorithms that can search routes from initial position
  * through all cells of a chequerboard.
  */
trait RouteFindingAlgorithm {

  /**
    * Finds route from initial position through all chequerboard cells.
    *
    * @param initialPosition  initial position of figure on chequerboard
    * @return                 route in format of cells sequence representing each route step
    */
  def findRoute(initialPosition: (Int, Int)): Seq[(Int, Int)]
}
