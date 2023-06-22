/**
 * Solution to the "Eight Queens" problem on Kattis.
 * @author Brendan Jones
 */
#include <cmath>
#include <cstdint>
#include <iostream>
#include <vector>

const int32_t BOARD_SIZE = 8;
const int32_t NUM_QUEENS = 8;

struct Position {
    int16_t x;
    int16_t y;
};

bool CheckValidity(std::vector<Position>& positions) {
    for (int16_t currPiece = 0; currPiece < NUM_QUEENS; ++currPiece) {
        Position currPos = positions[currPiece];
        for (int16_t nextPiece = currPiece + 1; nextPiece < NUM_QUEENS; ++nextPiece) {
            Position nextPos = positions[nextPiece];

            int16_t deltaX = currPos.x - nextPos.x;
            if (deltaX == 0) {
                return false;
            }

            int16_t deltaY = currPos.y - nextPos.y;
            if (deltaY == 0) {
                return false;
            }

            if (std::abs(deltaX) == std::abs(deltaY)) {
                return false;
            }
        }
    }
    return true;
}

int main() {
    std::vector<Position> positions;

    char curr = '\0';
    for (int16_t row = 0; row < BOARD_SIZE; ++row) {
        for (int16_t col = 0; col < BOARD_SIZE; ++col) {
            std::cin >> curr;
            if (curr == '*') {
                positions.push_back({ col, row });
            }
        }
    }

    std::cout << (CheckValidity(positions) ? "valid" : "invalid") << std::endl;

    return 0;
}