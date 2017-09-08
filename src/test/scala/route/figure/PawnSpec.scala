package route.figure

import org.scalatest.WordSpecLike

class PawnSpec extends WordSpecLike {

	val pawn = new Pawn()

	"A Pawn" should {

		"move up" in {
			assert(pawn.canMoveUp((3, 0), (0, 0)))
		}

		"move down" in {
			assert(pawn.canMoveDown((0, 0), (3, 0)))
		}

		"move left" in {
			assert(pawn.canMoveLeft((0, 3), (0, 0)))
		}

		"move right" in {
			assert(pawn.canMoveRight((0, 0), (0, 3)))
		}

		"move up left" in {
			assert(pawn.canMoveUpLeft((2, 2), (0, 0)))
		}

		"move up right" in {
			assert(pawn.canMoveUpRight((2, 0), (0, 2)))
		}

		"move down left" in {
			assert(pawn.canMoveDownLeft((0, 2), (2, 0)))
		}

		"move down right" in {
			assert(pawn.canMoveDownRight((0, 0), (2, 2)))
		}

	}
}
