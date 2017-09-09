package route

import org.scalatest.WordSpecLike
import route.figure.Pawn

class RoutesGraphSpec extends WordSpecLike {

  "A Route Graph" should {

    "provide route through all graph from initial position" in {
      val width = 10
      val height = 10
      val figure = Pawn
      val initialPosition = (0, 0)

      val route = new RoutesGraph(width, height, figure).route(initialPosition)

      assert(route.toSet.size == width * height)
      route.sliding(2, 1).map(pair => (pair.head, pair.last))
        .foreach(pair => {
          val from = pair._1
          val to = pair._2
          assert(figure.canMove(from, to), s"figure cannot move from $from to $to")
        })

      val matrix: Array[Array[Boolean]] = Array.ofDim[Boolean](width, height)
      route.foreach(cell => {
        matrix(cell._1)(cell._2) = true
        printMatrix(matrix)
      })
    }
  }

  private def printMatrix(matrix: Array[Array[Boolean]]) = {
    println(matrix.map(_.map(b => if (b) "x" else "o").mkString("|")).mkString("\n"))
    println
  }
}
