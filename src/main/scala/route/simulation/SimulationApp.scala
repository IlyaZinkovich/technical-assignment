package route.simulation

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory
import route.algorithm.{RouteFindingAlgorithm, RoutesGraph}
import route.figure.{Figure, Pawn}

/**
  * Application entry point that accepts program arguments in
  * "initialVerticalPosition initialHorizontalPosition" format,
  * validates them and runs simulation of route search algorithm
  * printing route and chequerboard on each route step.
  */
object SimulationApp {

  private val logger = Logger(LoggerFactory.getLogger(this.getClass))

  def main(args: Array[String]): Unit = {
    validateArgumentsLength(args)
    simulate(validInitialPosition(args(0), args(1), 10, 10))
  }

  private def simulate(initialPosition: (Int, Int)) = {
    val figure: Figure = Pawn
    val algorithm: RouteFindingAlgorithm = new RoutesGraph(figure)

    val route = algorithm.findRoute(initialPosition)

    logger.info(s"Route: ${route.mkString(", ")}")

    val matrix: Array[Array[Boolean]] = Array.ofDim[Boolean](10, 10)
    for ((cell, index) <- route.view.zipWithIndex) {
      matrix(cell._1)(cell._2) = true
      printMatrix(matrix, index)
    }
  }

  private def printMatrix(matrix: Array[Array[Boolean]], step: Int) = {
    val matrixOutput = matrix.map(_.map(b => if (b) "x" else "o").mkString("|")).mkString("\n")
    logger.info(s"Chequerboard on ${step + 1} step: \n$matrixOutput")
  }

  private def validateArgumentsLength(args: Array[String]) = {
    assert(args.length == 2,
      s"""Not enough arguments: ${args.length}
         |Please provide arguments in the following format:
         |initialHorizontalPosition initialVerticalPosition
         |initial position should fit [0, 10) range,
         |0 inclusive, 10 exclusive
         """.stripMargin)
  }

  private def validInitialPosition(initialVerticalPositionArg: String,
                                   initialHorizontalPositionArg: String,
                                   width: Int, height: Int) = {
    val initialVerticalPosition = initialVerticalPositionArg.toInt
    assert((0 <= initialVerticalPosition) && (initialVerticalPosition < height),
      s"Initial vertical position should fit (0, $height) range")
    val initialHorizontalPosition = initialHorizontalPositionArg.toInt
    assert((0 <= initialHorizontalPosition) && (initialHorizontalPosition < width),
      s"Initial horizontal position should fit (0, $width) range")
    (initialVerticalPosition, initialHorizontalPosition)
  }
}
