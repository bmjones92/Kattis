#include <iostream>

int main() {
    int32_t numIterations;
    std::cin >> numIterations;

    for (int32_t i = 1; i <= numIterations; ++i) {
        std::cout << i << ' ' << "Abracadabra" << std::endl;
    }

    return 0;
}