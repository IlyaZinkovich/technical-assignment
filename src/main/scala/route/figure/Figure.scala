package route.figure

trait Figure {

  def canMove(fromVertex: (Int, Int), toVertex: (Int, Int)): Boolean
}
