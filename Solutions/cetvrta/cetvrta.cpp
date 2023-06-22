/**
 * Solution to the "Cetvrta" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>
#include <map>

int main() {
    std::map<uint16_t, uint16_t> coordsX;
    std::map<uint16_t, uint16_t> coordsY;

    for (uint32_t i = 0; i < 3; ++i) {
        uint32_t coord;

        std::cin >> coord;
        ++coordsX[coord];

        std::cin >> coord;
        ++coordsY[coord];
    }

    for (auto pair : coordsX) {
        if (pair.second == 1) {
            std::cout << pair.first << ' ';
            break;
        }
    }

    for (auto pair : coordsY) {
        if (pair.second == 1) {
            std::cout << pair.first << std::endl;
            break;
        }
    }

    return 0;
}