/**
 * Solution to the "Encoded Message" problem on Kattis.
 * @author Brendan Jones
 */
#include <cmath>
#include <iostream>
#include <string>

void ProcessTestCase() {
    // Read the encoded message.
    std::string message;
    std::cin >> message;

    // Find the sqrt of the message length.
    int32_t size = static_cast<int32_t>(std::sqrt(message.length()));

    // Decode the message (basically a matrix transpose)
    for (int32_t i = size - 1; i >= 0; --i) {
        for (int32_t j = 0; j < size; ++j) {
            std::cout << message[i + (size * j)];
        }
    }
    std::cout << std::endl;
}

int main() {
    uint32_t numCases;
    std::cin >> numCases;
    for (uint32_t i = 0; i < numCases; ++i) {
        ProcessTestCase();
    }
    return 0;
}