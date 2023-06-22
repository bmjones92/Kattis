/**
 * Solution to the "Black Friday" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <cstdint>
#include <iostream>
#include <vector>

constexpr uint32_t OUTCOME_EMPTY = 1000000;
constexpr uint32_t OUTCOME_DUPLICATE = 1000001;

constexpr uint32_t NUM_OUTCOMES = 6;

void DetermineWinner(uint32_t outcomes[NUM_OUTCOMES]) {
    for (uint32_t i = NUM_OUTCOMES - 1; i < NUM_OUTCOMES; --i) {
        if (outcomes[i] != OUTCOME_EMPTY && outcomes[i] != OUTCOME_DUPLICATE) {
            std::cout << (outcomes[i] + 1) << std::endl;
            return;
        }
    }
    std::cout << "none" << std::endl;
}

int main() {
    uint32_t numParticipants;
    std::cin >> numParticipants;

    uint32_t outcomes[NUM_OUTCOMES] = { OUTCOME_EMPTY, OUTCOME_EMPTY, OUTCOME_EMPTY, OUTCOME_EMPTY, OUTCOME_EMPTY, OUTCOME_EMPTY };

    uint32_t result;
    for (uint32_t i = 0; i < numParticipants; ++i) {
        std::cin >> result;
        --result;

        if (outcomes[result] == OUTCOME_EMPTY) {
            outcomes[result] = i;
        } else {
            outcomes[result] = OUTCOME_DUPLICATE;
        }
    }

    DetermineWinner(outcomes);

    return 0;
}