package route.simulation

import org.scalatest.WordSpecLike

class SimulationAppSpec extends WordSpecLike {

  "Simulation" should {

    "validate input parameters length" in {
      assertThrows[AssertionError](SimulationApp.main(Array("4")))
    }

    "validate initialPosition" in {
      assertThrows[AssertionError](SimulationApp.main(Array("-1", "0")))
      assertThrows[AssertionError](SimulationApp.main(Array("0", "-1")))
      assertThrows[AssertionError](SimulationApp.main(Array("10", "0")))
      assertThrows[AssertionError](SimulationApp.main(Array("0", "10")))
    }

    "run successfully" in {
      SimulationApp.main(Array("0", "0"))
    }
  }
}
