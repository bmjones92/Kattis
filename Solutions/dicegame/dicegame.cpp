/**
 * Solution to the "Dice Game" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>
#include <string>

uint32_t ReadNextLine() {
    uint32_t sum = 0;

    uint32_t number;
    for (uint32_t i = 0; i < 4; ++i) {
        std::cin >> number;
        sum += number;
    }

    return sum;
}

int main() {
    uint32_t gunnarScore = ReadNextLine();
    uint32_t emmaScore = ReadNextLine();

    if (gunnarScore > emmaScore) {
        std::cout << "Gunnar" << std::endl;
    } else if (gunnarScore < emmaScore) {
        std::cout << "Emma" << std::endl;
    } else {
        std::cout << "Tie" << std::endl;
    }

    return 0;
}