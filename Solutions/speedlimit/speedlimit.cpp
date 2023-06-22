/**
 * Solution to the "Speed Limit" problem on Kattis.
 * @author Brendan Jones
 */
#include <cmath>
#include <iostream>

int32_t ProcessTestCase(int32_t numLogs) {
    int32_t totalDistanceDriven = 0;

    int32_t lastTimeElapsed = 0;

    int32_t speed;
    int32_t currTimeElapsed;

    for (int32_t i = 0; i < numLogs; ++i) {
        std::cin >> speed >> currTimeElapsed;

        totalDistanceDriven += speed * (currTimeElapsed - lastTimeElapsed);

        lastTimeElapsed = currTimeElapsed;
    }

    return totalDistanceDriven;
}

int main() {
    int32_t numLogs;

    while ((std::cin >> numLogs) && numLogs != -1) {
        std::cout << ProcessTestCase(numLogs) << " miles" << std::endl;
    }

    return 0;
}