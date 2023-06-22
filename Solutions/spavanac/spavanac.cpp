/**
 * Solution to the "Spavanac" problem on Kattis.
 * @author Brendan Jones
 */
#include <iostream>

int main() {
    int32_t h;
    int32_t m;

    std::cin >> h >> m;

    m -= 45;
    if (m < 0) {
        --h;
        if (h < 0) {
            h = 24 + h;
        }
        m = 60 + m;
    }

    std::cout << h << " " << m << std::endl;

    return 0;
}