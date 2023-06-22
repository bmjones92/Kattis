/**
 * Solution to the "Secret Message" problem on Kattis.
 * @author Brendan Jones
 */
#include <algorithm>
#include <cstdint>
#include <iostream>
#include <string>
#include <cmath>

 /**
  * Calculates the size of the matrix based on the size of the message.
  * @param size The length of the message.
  */
uint32_t CalculateMatrixSize(uint32_t size) {
    return static_cast<uint32_t>(ceil(sqrt(static_cast<double>(size))));
}

/**
 * Processes a single message.
 */
void ProcessMessage() {
    // Read the message.
    std::string message;
    std::cin >> message;

    std::string result;

    // Populate the message result.
    uint32_t matrixSize = CalculateMatrixSize(message.length());
    for (uint32_t col = 0; col < matrixSize; ++col) {
        for (int32_t row = matrixSize - 1; row >= 0; --row) {
            uint32_t index = row * matrixSize + col;
            if (index < message.length()) {
                result += message[index];
            }
        }
    }
    std::cout << result << std::endl;
}

int main() {
    uint32_t numMessages;
    std::cin >> numMessages;

    for (uint32_t i = 0; i < numMessages; ++i) {
        ProcessMessage();
    }

    return 0;
}