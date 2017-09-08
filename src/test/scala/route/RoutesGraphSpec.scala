package route

import org.scalatest.WordSpecLike
import route.figure.Pawn

class RoutesGraphSpec extends WordSpecLike {

	"A Route Graph" should {
		"initialize" in {
			val routesGraph = new RoutesGraph(10, 10, Pawn)
		}
	}
}
