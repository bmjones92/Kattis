/**
 * Solution to the "Ladder" problem on Kattis.
 * @author Brendan Jones
 */
#include <cmath>
#include <cstdint>
#include <iostream>

const double PI = 3.14159265358979323846;

double DegreesToRadians(double angle) {
    return PI * angle / 180.0;
}

int main() {
    int32_t height;
    int32_t angle;

    std::cin >> height >> angle;

    double sin = std::sin(DegreesToRadians(angle));

    std::cout << static_cast<int32_t>(std::ceil(height / sin)) << std::endl;

    return 0;
}