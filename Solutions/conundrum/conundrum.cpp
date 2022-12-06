#include <fstream>
#include <iostream>

const char* TRANSFORMED = "PER";

int main() {
    int changes = 0;
    
    char current;
    for (int i = 0; std::cin >> current; ++i) {
        if (current != TRANSFORMED[i % 3]) {
            ++changes;
        }
    }
    
    std::cout << changes << std::endl;
    
    return 0;
}