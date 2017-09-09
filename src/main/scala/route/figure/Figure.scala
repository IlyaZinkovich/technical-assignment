package route.figure

/**
  * Chequerboard figure interface.
  */
trait Figure {

  /**
    * Decides whether the figure can be moved from source vertex to destination.
    *
    * @param fromVertex vertex representing a chequerboard cell in which the figure is placed
    * @param toVertex   vertex representing a chequerboard cell to move
    * @return           true/false depending on whether the figure can move from source vertex to destination
    */
  def canMove(fromVertex: (Int, Int), toVertex: (Int, Int)): Boolean
}
