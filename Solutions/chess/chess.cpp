/**
 * Solution to the "Chess" problem on Kattis.
 * @author Brendan Jones
 */
#include <cmath>
#include <cstdint>
#include <iostream>
#include <vector>

/* The possible colors of each tile. */
enum class Color {
    Black,
    White
};

/* The row and column of a tile. */
struct Tile {
    uint8_t col;
    uint8_t row;
};

bool operator==(const Tile& a, const Tile& b) {
    return (a.col == b.col && a.row == b.row);
}

bool operator!=(const Tile& a, const Tile& b) {
    return !(a == b);
}

inline Color GetTileColor(const Tile& tile) {
    uint8_t colNum = (tile.col - 'A');
    uint8_t rowNum = (tile.row - '1');

    return ((colNum % 2) ^ (rowNum % 2)) ? Color::White : Color::Black;
}

inline bool HasSolution(const Tile& current, const Tile& target) {
    return GetTileColor(current) == GetTileColor(target);
}

inline bool IsWithinBounds(Tile& pos, int8_t dX, int8_t dY) {
    if (pos.col <= 'A' && dX == -1) {
        return false; // We are at left edge.
    }
    if (pos.col >= 'H' && dX == 1) {
        return false; // We are at right edge.
    }
    if (pos.row <= '1' && dY == -1) {
        return false; // We are at top edge.
    }
    if (pos.row >= '8' && dY == 1) {
        return false; // We are at bottom edge.
    }

    return true;
}

std::vector<Tile> CalculateSolution(const Tile& start, const Tile& end) {
    auto solution = std::vector<Tile>();
    solution.push_back(start);

    Tile current = start;
    while(current != end) {
        // The difference between the two tiles.
        int8_t dX = end.col - current.col;
        int8_t dY = end.row - current.row;

        if(std::abs(dX) == std::abs(dY)) { // We can get to the end point from here.
            current = end;
        } else { // We cannot get to the end point from here.

            // Determine the direction we need to move.
            dX = (dX < 0) ? -1 : (dX > 0) ? 1 : (current.col == 'A') ? 1 : -1;
            dY = (dY < 0) ? -1 : (dY > 0) ? 1 : (current.row == '1') ? 1 : -1;

            // Find the intermediate point between the current and end points.
            do {
                current.col += dX;
                current.row += dY;
            } while (std::abs(end.col - current.col) != std::abs(end.row - current.row) && IsWithinBounds(current, dX, dY));
        }

        // Add the point to the list.
        solution.push_back(current);
    }

    // Return the solution set.
    return solution;
}

int main() {
    // The number of problems we need to solve.
    uint32_t numProblems;
    std::cin >> numProblems;

    Tile startPos = { };
    Tile endPos = { };
    for (uint32_t i = 0; i < numProblems; ++i) {
        // Read the position of the start position.
        std::cin >> startPos.col >> startPos.row;
        // Read the position of the end position.
        std::cin >> endPos.col >> endPos.row;

        if (HasSolution(startPos, endPos)) {
            // Find the solution.
            std::vector<Tile> solution = CalculateSolution(startPos, endPos);

            // Print the solution out.
            std::cout << (solution.size() - 1);
            for (auto& tile : solution) {
                std::cout << ' ' << tile.col << ' ' << tile.row;
            }
            std::cout << std::endl;
        } else {
            // There is no solution to this problem.
            std::cout << "Impossible" << std::endl;
        }
    }

    std::cin.get();
    std::cin.get();

    return 0;
}