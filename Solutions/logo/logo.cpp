/**
 * Solution to the "Logo" problem on Kattis.
 * @author Brendan Jones
 */
#include <cmath>
#include <cstdint>
#include <iostream>
#include <string>

constexpr double PI = 3.14159265358979323846;

void ProcessTestCase() {
    // The number of commands to read in for this test case.
    uint32_t numCommands;
    std::cin >> numCommands;

    // The current command and number of units.
    std::string command;
    uint32_t units;

    // The current position of the turtle.
    double posX = 0.0;
    double posY = 0.0;

    // The current direction that the turtle is facing (Along the positive X axis by default).
    double angle = 0.0;
    
    for (uint32_t i = 0; i < numCommands; ++i) {
        // Read the command and number of units.
        std::cin >> command >> units;

        if (command == "fd") {
            // Move forward along the forward vector.
            posX += units * std::sin(angle);// SIN_TABLE[angle];
            posY += units * std::cos(angle);// COS_TABLE[angle];
        } else if (command == "bk") {
            // Move backward along the forward vector.
            posX -= units * std::sin(angle);// SIN_TABLE[angle];
            posY -= units * std::cos(angle);// COS_TABLE[angle];
        } else if (command == "lt") {
            // Turn anticlockwise and clamp the angle to [0, 360).
            angle += (units / 180.0) * PI;
        } else if (command == "rt") {
            // Turn clockwise and clamp the angle to [0, 360).
            angle -= (units / 180.0) * PI;
        }
    }

    // Calculate the distance from the original to the current position, and round it to the nearest integer.
    double distance = std::sqrt(posX * posX + posY * posY);
    std::cout << static_cast<uint32_t>(std::round(distance)) << std::endl;
}

int main() {
    // The number of test cases in this input.
    uint32_t numTestCases;
    std::cin >> numTestCases;

    for(uint32_t i = 0; i < numTestCases; ++i) {
        ProcessTestCase();
    }

    return 0;
}