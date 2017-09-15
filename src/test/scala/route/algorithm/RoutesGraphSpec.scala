package route.algorithm

import org.scalatest.WordSpecLike
import route.figure.Pawn

class RoutesGraphSpec extends WordSpecLike {

  "A Route Graph" should {

    "provide route through all graph from any initial position" in {
      val figure = Pawn
      val routesGraph = new RoutesGraph(figure)

      for (x <- List.range(0, 10); y <- List.range(0, 10)) {
        val initialPosition = (x, y)
        val route = routesGraph.findRoute(initialPosition)

        assert(route.size == 100, s"route through all graph is not found for initial position $initialPosition")

        route.sliding(2, 1).map(pair => (pair.head, pair.last))
          .foreach(pair => {
            val from = pair._1
            val to = pair._2
            assert(figure.canMove(from, to),
              s"figure cannot move from $from to $to, initial position is $initialPosition")
          })
      }
    }
  }
}
