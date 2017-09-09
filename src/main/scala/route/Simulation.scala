package route

import route.algorithm.RoutesGraph
import route.figure.Pawn

object Simulation {

  def main(args: Array[String]): Unit = {
    validateArgumentsLength(args)
    val width = validWidth(args(0))
    val height = validHeight(args(1))
    simulate(width, height, validInitialPosition(args(2), args(3), width, height))
  }

  private def simulate(width: Int, height: Int, initialPosition: (Int, Int)) = {
    val figure = Pawn

    val route = new RoutesGraph(width, height, figure).route(initialPosition)

    println("Route: ")
    println(route.mkString(", "))

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

  private def validWidth(arg: String) = {
    val width = arg.toInt
    assert(width > 0, "Width should be greater than 0")
    width
  }

  private def validHeight(arg: String) = {
    val height = arg.toInt
    assert(height > 0, "Height should be greater than 0")
    height
  }

  private def validateArgumentsLength(args: Array[String]) = {
    if (args.length < 4) {
      throw new RuntimeException(
        s"""Not enough arguments: ${args.length}
           |Please provide arguments in the following format:
           |width height initialHorizontalPosition initialVerticalPosition
           |each argument should be an integer greater than 0
           |and initial position should fit provided width and height
         """.stripMargin)
    }
  }
}
