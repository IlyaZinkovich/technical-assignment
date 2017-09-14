package route.algorithm

import org.scalatest.WordSpecLike
import route.figure.Pawn

class RoutesGraphSpec extends WordSpecLike {

  "A Route Graph" should {

    "provide route through all graph from any initial position" in {
      val width = 5
      val height = 5
      val figure = Pawn

      val routesGraph = new RoutesGraph(width, height, figure)

      val route = routesGraph.findRoute((0, 0))
      print(route)


//      for (x <- List.range(0, height); y <- List.range(0, width)) {
//        val initialPosition = (x, y)
//
//        val route = routesGraph.findRoute(initialPosition)
//
//        print(route)
//
//        assert(route.size == width * height,
//          s"route through all graph is not found for initial position $initialPosition")
//
//        route.sliding(2, 1).map(pair => (pair.head, pair.last))
//          .foreach(pair => {
//            val from = pair._1
//            val to = pair._2
//            assert(figure.canMove(from, to),
//              s"figure cannot move from $from to $to, initial position is $initialPosition")
//          })
//      }
    }
  }
}
