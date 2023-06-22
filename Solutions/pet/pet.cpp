/**
 * Solution to the "Pet" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>

const int32_t NUM_CONTESTANTS = 5;

int main() {
    int32_t topScorer = 0;
    int32_t topScore = 0;
    for (int32_t i = 0; i < NUM_CONTESTANTS; ++i) {
        int32_t currScore = 0;

        int32_t value;
        for (int32_t j = 0; j < NUM_CONTESTANTS - 1; ++j) {
            std::cin >> value;
            currScore += value;
        }

        if (currScore > topScore) {
            topScorer = i + 1;
            topScore = currScore;
        }
    }
    std::cout << topScorer << " " << topScore << std::endl;
    return 0;
}