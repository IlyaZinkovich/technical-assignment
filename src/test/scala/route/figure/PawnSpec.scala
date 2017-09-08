package route.figure

import org.scalatest.WordSpecLike

class PawnSpec extends WordSpecLike {

	"A Pawn" should {

		"move up" in {
			assert(Pawn.canMoveUp((3, 0), (0, 0)))
		}

		"move down" in {
			assert(Pawn.canMoveDown((0, 0), (3, 0)))
		}

		"move left" in {
			assert(Pawn.canMoveLeft((0, 3), (0, 0)))
		}

		"move right" in {
			assert(Pawn.canMoveRight((0, 0), (0, 3)))
		}

		"move up left" in {
			assert(Pawn.canMoveUpLeft((2, 2), (0, 0)))
		}

		"move up right" in {
			assert(Pawn.canMoveUpRight((2, 0), (0, 2)))
		}

		"move down left" in {
			assert(Pawn.canMoveDownLeft((0, 2), (2, 0)))
		}

		"move down right" in {
			assert(Pawn.canMoveDownRight((0, 0), (2, 2)))
		}

	}
}
