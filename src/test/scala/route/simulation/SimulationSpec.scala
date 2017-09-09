package route.simulation

import org.scalatest.WordSpecLike

class SimulationSpec extends WordSpecLike {

  "Simulation" should {

    "validate input parameters length" in {
      assertThrows[AssertionError](Simulation.main(Array("10", "10")))
    }

    "validate width" in {
      assertThrows[AssertionError](Simulation.main(Array("-1", "10", "0", "0")))
    }

    "validate height" in {
      assertThrows[AssertionError](Simulation.main(Array("10", "-1", "0", "0")))
    }

    "validate initialPosition" in {
      assertThrows[AssertionError](Simulation.main(Array("10", "10", "-1", "0")))
      assertThrows[AssertionError](Simulation.main(Array("10", "10", "0", "-1")))
      assertThrows[AssertionError](Simulation.main(Array("10", "10", "11", "0")))
      assertThrows[AssertionError](Simulation.main(Array("10", "10", "0", "11")))
    }

    "run successfully" in {
      Simulation.main(Array("10", "10", "0", "0"))
    }
  }
}
