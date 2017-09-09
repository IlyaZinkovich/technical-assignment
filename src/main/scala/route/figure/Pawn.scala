package route.figure

/**
  * A chequerboard figure that can vertically and horizontally through two cells
  * and diagonally through one cell.
  */
object Pawn extends Figure {

  def canMoveUp(from: (Int, Int), to: (Int, Int)): Boolean = {
    (from._1 - to._1 == 3) && (from._2 == to._2)
  }

  def canMoveDown(from: (Int, Int), to: (Int, Int)): Boolean = {
    (from._1 - to._1 == -3) && (from._2 == to._2)
  }

  def canMoveLeft(from: (Int, Int), to: (Int, Int)): Boolean = {
    (from._1 == to._1) && (from._2 - to._2 == 3)
  }

  def canMoveRight(from: (Int, Int), to: (Int, Int)): Boolean = {
    (from._1 == to._1) && (from._2 - to._2 == -3)
  }

  def canMoveUpLeft(from: (Int, Int), to: (Int, Int)): Boolean = {
    (from._1 - to._1 == 2) && (from._2 - to._2 == 2)
  }

  def canMoveUpRight(from: (Int, Int), to: (Int, Int)): Boolean = {
    (from._1 - to._1 == 2) && (from._2 - to._2 == -2)
  }

  def canMoveDownLeft(from: (Int, Int), to: (Int, Int)): Boolean = {
    (from._1 - to._1 == -2) && (from._2 - to._2 == 2)
  }

  def canMoveDownRight(from: (Int, Int), to: (Int, Int)): Boolean = {
    (from._1 - to._1 == -2) && (from._2 - to._2 == -2)
  }

  def canMove(fromVertex: (Int, Int), toVertex: (Int, Int)): Boolean = {
    List(canMoveUp _,
      canMoveDown _,
      canMoveLeft _,
      canMoveRight _,
      canMoveUpLeft _,
      canMoveUpRight _,
      canMoveDownLeft _,
      canMoveDownRight _).map(move => move.apply(fromVertex, toVertex)).reduce(_ | _)
  }
}
