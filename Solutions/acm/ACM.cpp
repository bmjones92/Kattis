/**
 * Solution to the "ACM Contest Scoring" problem on Kattis.
 * @author Brendan Jones
 */
#include <cstdint>
#include <iostream>
#include <map>
#include <string>

int main() {

    // The time penalty given for each failed answer (on an problem that is eventually solved)
    const uint32_t FAIL_TIME_PENALTY = 20;
    
    // The correct answer string.
    const std::string VALID_RESULT = "right";

    std::map<char, uint32_t> numFailedAttempts;

    uint32_t numProblemsSolved = 0;
    uint32_t totalScore = 0;

    uint32_t time = -1;
    while (std::cin >> time && time != -1) { // -1 indicates we are finished reading data.
        char problemID;
        std::cin >> problemID;

        std::string result;
        std::cin >> result;

        if (result == VALID_RESULT) {
            // Every question that is eventually answered correctly receives a penalty
            // for the number of wrong attempts that were made previously.
            ++numProblemsSolved;
            totalScore += (numFailedAttempts[problemID] * FAIL_TIME_PENALTY) + time;
        } else {
            // Tracks the number of failed attempts that we've made for each problem.
            ++numFailedAttempts[problemID];
        }
    }

    std::cout << numProblemsSolved << " " << totalScore;
    return 0;
}