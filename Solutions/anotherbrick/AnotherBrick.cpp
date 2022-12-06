/**
 * Solution to the "Another Brick in the Wall" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>

/**
 * Attempts to complete the next row.
 */
int CanCompleteNextRow(int wallWidth, int remainingBricks) {
	int currentWidth = 0;
	for (int i = 0; i < remainingBricks; ++i) {
        int brickWidth;
		std::cin >> brickWidth;
		
		currentWidth += brickWidth;
		if (currentWidth > wallWidth) {
			return -1; // Too long for the current row.
		} else if (currentWidth == wallWidth) {
			return i;
		}
	}

    // Not long enough.
	return -1;
}

int main() {
	int wallHeight;
	std::cin >> wallHeight;

	int wallWidth;
	std::cin >> wallWidth;

	int numBricks;
	std::cin >> numBricks;

	int currentRow = 0;
	int currentWidth = 0;

	for (int row = 0; row < wallHeight; ++row) {
		int bricksUsed = CanCompleteNextRow(wallWidth, numBricks);
		if (bricksUsed == -1) {
			std::cout << "NO" << std::endl;
			return 0;
		} else {
			numBricks -= bricksUsed;
		}
	}

	std::cout << "YES" << std::endl;
	return 0;
}