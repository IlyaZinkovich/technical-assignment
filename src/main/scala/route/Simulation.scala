package route

import route.algorithm.RoutesGraph
import route.figure.Pawn

object Simulation {

  def main(args: Array[String]): Unit = {
    val width = 10
    val height = 10
    val figure = Pawn

    val initialPosition = (0, 0)
    val route = new RoutesGraph(width, height, figure).route(initialPosition)
    val matrix: Array[Array[Boolean]] = Array.ofDim[Boolean](width, height)
    route.foreach(cell => {
      matrix(cell._1)(cell._2) = true
      printMatrix(matrix)
    })
  }

  private def printMatrix(matrix: Array[Array[Boolean]]) = {
    println(matrix.map(_.map(b => if (b) "x" else "o").mkString("|")).mkString("\n"))
    println
  }
}
