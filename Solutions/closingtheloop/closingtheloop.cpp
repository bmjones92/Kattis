#include <algorithm>
#include <cstdint>
#include <functional>
#include <iostream>
#include <string>
#include <vector>
#include <queue>

void ProcessTest(uint32_t testID) {
    std::priority_queue<uint8_t, std::vector<uint8_t>, std::less<uint8_t>> redSegments;
    std::priority_queue<uint8_t, std::vector<uint8_t>, std::less<uint8_t>> blueSegments;

    // Read the number of segments.
    uint32_t numSegments;
    std::cin >> numSegments;

    std::string segment;
    for (uint16_t i = 0; i < numSegments; ++i) {
        std::cin >> segment;

        char color = segment[segment.length() - 1];
        segment = segment.substr(0, segment.length() - 1);
        if (color == 'R') { // Segment is red.
            redSegments.push(std::stoi(segment));
        } else { // Segment is blue.
            blueSegments.push(std::stoi(segment));
        }
    }

    numSegments = 0;
    uint32_t length = 0;
    if (redSegments.size() != 0 && blueSegments.size() != 0) { // If there is at least one segment of each color.
        // Note: We must read segments in as pairs because they loop.
        while (!redSegments.empty() && !blueSegments.empty()) { // While there is at least one remaining segment of each color...
            // Add the length of both segments to the loop.
            length += redSegments.top();
            length += blueSegments.top();

            // Pop the head segments from each list.
            redSegments.pop();
            blueSegments.pop();

            // Add the number of segments to the loop.
            numSegments += 2;
        }

        length -= numSegments; // Account for the knots.
    }

    // Print the result.
    std::cout << "Case #" << testID << ": " << length << std::endl;
}

int main() {
    uint32_t numTests = 0;
    std::cin >> numTests;
    for (uint32_t i = 0; i < numTests; ++i) {
        ProcessTest(i + 1);
    }

    return 0;
}